
package progpoetaskone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JOptionPane;

public class Task {
    /*
    Initializes the totalDuration variable which will keep track of the total hrs of all the added tasks created while the program is running
    Initializes the hashmap for the taskNumbersByDeveloper variable.
    */
    private static int totalDuration = 0;
    private static Map<String, AtomicInteger> taskNumbersByDeveloper = new HashMap<>();

    public static void run() {
        /*
        Displays an intro message
        Opens the task_numbers.txt file (which closes when the program closes)
            Doing this saves memory because instead of having to open and close the file to add each detail, it just opens it at the beginning and closes it at the end.
        Calls the menu() method so the user can choose how to proceed
        */
        JOptionPane.showMessageDialog(null, "Welcome to EasyKhanban");
        loadTaskNumbers();
        menu();
    }

    public static void menu() {
        /*
        This is the menu from which the user will choose to either add a task, show a report or exit.
            If they choose to add a task then the addTask() method will run
            If they choose to show report then "Coming soon" will be displayed
            If they choose to exit then the program will close after a goodbye message is displayed
            If they choose something out of scope then the program will reprompt then after displaying an error message.
        */
        String[] options = {"Option 1) Add Task", "Option 2) Show Report", "Option 3) Exit"};
        int selections = JOptionPane.showOptionDialog(null, "Choose an option:", "Numeric Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (selections) {
            case 0:
                addTask();
                JOptionPane.showMessageDialog(null, "Total hours: \n" + returnTotalHours());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Coming Soon");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Thank you for using this program!\n==============================");
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input, Please try again.");
                break;
        }
        menu();
    }

    public static void addTask() {
        /*
        Opens the file tasks.txt and writes the task to that file while the task is being created
        If the task creation is not complete then it will not be saved to the file.
        */
        int numOfTasks = getNumOfTasks();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt", true))) {
            for (int taskNumber = 0; taskNumber < numOfTasks; taskNumber++) {
                Tasks task = createTask();
                totalDuration += task.getTaskDuration();
                saveTaskToFile(writer, task);
                printTaskDetails(task);
            }

            saveTaskNumbers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Tasks createTask() {
        //Calls all the methods involved with creating the task.
        String taskStatus = getTaskStatus();
        String devName = getDevName();
        String taskName = getTaskName();
        String taskDescription = getTaskDescription();
        int taskDuration = getTaskDuration();
        String taskId = createTaskID(devName, taskName, getTaskNumberForDeveloper(devName));

        return new Tasks(taskStatus, devName, taskName, taskDescription, taskDuration, taskId);
    }

    public static void saveTaskToFile(BufferedWriter writer, Tasks task) throws IOException {
        /*
        Saves the task details to the tasks.txt file
        This will be useful later on to search through when trying to find a certain task.
        */
        String taskDetails = task.getTaskStatus() + ";" + task.getDevName() + ";" + task.getTaskName() + ";"
                + task.getTaskDescription() + ";" + task.getTaskDuration() + ";" + task.getTaskId();
        writer.write(taskDetails);
        writer.newLine();
    }

    public static void printTaskDetails(Tasks task) {
        //Prints out the task details after each task has been created.
        String taskDetails = "**Task Status**\n" + task.getTaskStatus() +
             "\n\n**Developer Name**\n" + task.getDevName() +
             "\n\n**Task Name**\n" + task.getTaskName() +
             "\n\n**Task Description**\n" + task.getTaskDescription() +
             "\n\n**Task Duration**\n" + task.getTaskDuration() +
             "\n\n**Task ID**\n" + task.getTaskId();


        JOptionPane.showMessageDialog(null, taskDetails.toString());
    }

    public static int getNumOfTasks() {
        /*
        Initializes the numOfTasks variable
        Prompts the user to enter the number of tasks they would like to assign.
        Catches any errors and reprompts the user to enter a valid number of tasks to assign.
        */
        int numOfTasks = 0;
        try {
            numOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of tasks you would like to assign: "));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            numOfTasks = getNumOfTasks();
        }
        return numOfTasks;
    }

    public static String getTaskStatus() {
        /*
        Creates 3 buttons for the user to choose from for selecting the "To Do", "Doing" or "Done" status
            A list of the options
            prompts the user to select an option
            then sets the taskStatus variable with the appropriate status.
        */
        String[] taskOption = {"To Do", "Doing", "Done"};
        int chosenOption = JOptionPane.showOptionDialog(null, "Choose an option:", "Numeric Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, taskOption, taskOption[0]);

        String taskStatus = "";
        switch (chosenOption) {
            case 0:
                JOptionPane.showMessageDialog(null, "To Do Selected");
                taskStatus = "TO DO";
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Doing Selected");
                taskStatus = "DOING";
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Done Selected");
                taskStatus = "DONE";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input, Please try again.");
                taskStatus = getTaskStatus();
                break;
        }
        return taskStatus;
    }

    public static String getDevName() {
        //Prompts the user to enter the developers name.
        return JOptionPane.showInputDialog(null, "Enter the first and last name of the developer the task will be assigned to: ");
    }

    public static String getTaskName() {
        //Prompts the user to enter the name of the task that will be assigned to the developer.
        return JOptionPane.showInputDialog(null, "Enter the name of the task");
    }

    public static String getTaskDescription() {
        /*
        Prompts the user to enter the description of the task that will be assigned to the developer
        If the taskDescription is more than 50 characters then it will reprompt the user to enter an appropriate description under 50 characters
        */
        String taskDescription = JOptionPane.showInputDialog(null, "Enter a description of the task: ");

        while (taskDescription.length() >= 50) {
            JOptionPane.showMessageDialog(null, "Description too long, please enter a description less than 50 characters.");
            taskDescription = getTaskDescription();
        }
        return taskDescription;
    }

    public static int getTaskDuration() {
        /*
        Initializes the taskDuration
        Prompts the user to enter the expected time it would take for the assigned dev to complete the task
        Catches any errors and then prompts the user again.
        */
        int taskDuration = 0;
        try {
            taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of hours the task will take to complete: "));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            taskDuration = getTaskDuration();
        }
        return taskDuration;
    }

    public static String createTaskID(String devName, String taskName, int taskNumber) {
        /*
        For the first part of the TaskID, it takes the task name and task the first three characters of that.
        For the second part, the task number (which is being kept track of in task_numbers.txt file) is used directly
        For the third part, it takes the developers name, seperates it by the whitespace, takes the first string after being seperated, then gets the last three characters.
            For the third part, when it gets the last three characters, it starts from the max length of the first string (their first name) then stops at (the max length - 3).
        */
        String taskIdPartOne = taskName.substring(0, 2);
        String[] words = devName.split("\\s+");
        String firstWord = words[0];
        String taskIdPartThree = firstWord.substring(Math.max(0, firstWord.length() - 3));
        return taskIdPartOne.toUpperCase() + ":" + taskNumber + ":" + taskIdPartThree.toUpperCase();
    }

    public static int returnTotalHours() {
        //Returns the totalDuration, which is updated after each task has been added.
        return totalDuration;
    }
    
    private static void saveTaskNumbers() {
        /*
        Adding the task numbers in the task_numbers.txt file
            If the dev does not have a task number then their name will be added and their task number will be set to 0 and increment from there.
            The data will be added as such: 'the developers name':'their task number'. E.g: Caleb Hartslief:1
            Configuring it using a hashmap.
        */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("task_numbers.txt"))) {
            for (Map.Entry<String, AtomicInteger> entry : taskNumbersByDeveloper.entrySet()) {
                String devName = entry.getKey();
                int taskNumber = entry.getValue().get();
                writer.write(devName + ":" + taskNumber);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void loadTaskNumbers() {
        /*
        Loading from task_numbers.txt
            This reads the contents of the .txt file
            It then seperates the dev's name and their respective last saved task number
            It then stores it in the data structure taskNumbersByDeveloper :)
        */
        try (BufferedReader reader = new BufferedReader(new FileReader("task_numbers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String devName = parts[0];
                    int taskNumber = Integer.parseInt(parts[1]);
                    taskNumbersByDeveloper.put(devName, new AtomicInteger(taskNumber));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    public static int getTaskNumberForDeveloper(String devName) {
        //Using AtomicInteger because its more efficient than using a standard counting setup in this case.
        AtomicInteger taskNumber = taskNumbersByDeveloper.get(devName);
        if (taskNumber != null) {
            return taskNumber.incrementAndGet();
        } else {
            taskNumbersByDeveloper.put(devName, new AtomicInteger(0));
            return 0;
        }
    }

    private static class Tasks {
        //Declaring the private variables
        private String taskStatus;
        private String devName;
        private String taskName;
        private String taskDescription;
        private int taskDuration;
        private String taskId;
        
        
        //Setting 'This' types
        public Tasks(String taskStatus, String devName, String taskName, String taskDescription,
                    int taskDuration, String taskId) {
            this.taskStatus = taskStatus;
            this.devName = devName;
            this.taskName = taskName;
            this.taskDescription = taskDescription;
            this.taskDuration = taskDuration;
            this.taskId = taskId;
        }
        
        
        //Getters
        public String getTaskStatus() {
            return taskStatus;
        }

        public String getDevName() {
            return devName;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getTaskDescription() {
            return taskDescription;
        }

        public int getTaskDuration() {
            return taskDuration;
        }

        public String getTaskId() {
            return taskId;
        }
    }
}
