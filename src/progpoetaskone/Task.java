
package progpoetaskone;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;


public class Task {
    ArrayList <String> developer = new ArrayList <String> ();
    ArrayList <String> taskNames = new ArrayList <String> ();
    ArrayList <String> taskID = new ArrayList <String> ();
    ArrayList <Integer> taskDuration = new ArrayList <Integer> ();
    ArrayList <String> taskStatus = new ArrayList <String> ();
    ArrayList <String> taskDescription = new ArrayList <String> ();
    ArrayList <String> tasks = new ArrayList <String> ();
   
    public static int totalHours = 0;
    public static int taskNumber = 0;
    public static int index = 0;
    
    public static void run() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKhanban");
        Task task = new Task();
        task.menu();
    }
    
    public void menu() {
        
        int selections = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your choice:\n\nOption 1) Add Tasks\nOption 2) Show Report\nOption 3) Quit"));

        switch (selections) {
            case 1:
                addTask();
                break;
            case 2:
                report();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Thank you for using this program!\n==============================");
                int sum = 0;
                for (int i = 0; i < taskDuration.size(); i++) {
                    sum += taskDuration.get(i);
                }
                JOptionPane.showMessageDialog(null, "The Total number of hours of all tasks is: " + sum);
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input, Please try again.");
                break;
        }
        menu();
    }
    
    public void addTask() {
        int taskAmt = getNumberOfTasks();
        for (int i = 1; i <= taskAmt; i++) { 
            getTaskStatus();
            getDevName();
            getTaskName();
            getTaskDescription();
            getTaskDuration();
            createTaskID();
            JOptionPane.showMessageDialog(null,printTaskDetails());
            JOptionPane.showMessageDialog(null, "Task successfully captured!");
            index = index++;
            taskNumber = taskNumber + 1;    
        }
        
        JOptionPane.showMessageDialog(null, "The Total number of hours between \nall the newly added tasks is : " + totalHours);
        totalHours = 0;
    }
    
    public static int getNumberOfTasks() {
        int numOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of \ntasks you would like to assign: "));
        return numOfTasks;
    }
    
    public String getTaskStatus() {
        int chosenOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose an option:\n\nOption 1) To Do\nOption 2) Doing\nOption 3) Done"));

        
        switch (chosenOption) {
            case 1:
                taskStatus.add(index, "TO DO");
                break;
            case 2:
                taskStatus.add(index, "DOING");
                break;
            case 3:
                taskStatus.add(index, "DONE");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input, Please try again.");
                getTaskStatus();
                break;
        }
        return taskStatus.get(index);
    }
    
    public String getDevName() {
        String developerNameInput = JOptionPane.showInputDialog(null, "Please enter the name of the developer \nwho this task will be assigned to: ");
        if (developerNameInput == null || developerNameInput.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Input.");
            getDevName();
        }
        developer.add(index,developerNameInput);
        return developer.get(index);
    }
    
    public String getTaskName() {
        String taskNamesInput = JOptionPane.showInputDialog(null, "Please enter the name of the task: ");
        if (taskNamesInput == null) {
            JOptionPane.showMessageDialog(null, "Invalid Input.");
            getTaskName();
        }
        taskNames.add(index,taskNamesInput);
        return taskNames.get(index);
    }
    
    public String getTaskDescription() {
        String taskDescriptionInput = JOptionPane.showInputDialog(null, "Please enter the description of this task");
        if (taskDescriptionInput == null) {
            JOptionPane.showMessageDialog(null, "Invalid Input.");
            getTaskDescription();
        }
        taskDescription.add(index,taskDescriptionInput);
        return taskDescription.get(index);
    }
    
    public int getTaskDuration() {
        int taskDurationInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of hours it \nshould take to complete this task"));
        taskDuration.add(index,taskDurationInput);
        returnTotalHours();
        return taskDuration.get(index);
    }
    
    public static boolean checkTaskDescription(String taskDescription) {
        while(taskDescription.length() < 50) {
            return true;
        }
        return false;
    }
    
    public String createTaskID() {
        /*First two letters of the task name: add task --> AD
        Task number: first task for dev --> 0
        Last three letters of the devs first name: Robyn Harrison --> BYN
        AD:0:BYN
        */
        String taskIdPartOne = taskNames.get(index);
        taskIdPartOne = taskIdPartOne.substring(0, 2);
        String[] words = developer.get(index).split("\\s+");
        String firstWord = words[0];
        String taskIdPartThree = firstWord.substring(Math.max(0, firstWord.length() - 3));
        String taskIDInput = taskIdPartOne.toUpperCase() + ":" + taskNumber + ":" + taskIdPartThree.toUpperCase();
        taskID.add(index, taskIDInput);
        return taskID.get(index);
    }
    
    public String printTaskDetails() {
        String taskDetails = "**Task Status**\n" + taskStatus.get(index) +
             "\n\n**Developer Name**\n" + developer.get(index) +
             "\n\n**Task Name**\n" + taskNames.get(index) +
             "\n\n**Task Description**\n" + taskDescription.get(index) +
             "\n\n**Task Duration**\n" + taskDuration.get(index) +
             "\n\n**Task ID**\n" + taskID.get(index);
        
        tasks.add(index, taskDetails);
        
        return taskDetails;
    }
    
    public int returnTotalHours() {
        totalHours = totalHours + taskDuration.get(index);
        return totalHours;
    }




    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

//TASK 3 ADDITIONS >>>>>

    public void report() {
        
        String reportOption = JOptionPane.showInputDialog(null, "Choose one of the following options: \n\n"
                                                            + "1. Display all tasks with the status 'done': \n"
                                                            + "2. Display the task with the longest duration: \n"
                                                            + "3. Display all tasks: \n"
                                                            + "4. Search for a task: \n"
                                                            + "5. Delete a task: \n");
        
        if(reportOption == null) {
                JOptionPane.showMessageDialog(null,"Thank you for using this program!\n==============================");                                                          
                System.exit(0);
            }
            
            //This checks if nothing was entered, if nothing was entered then the user will be prompted to try again.
            else if(reportOption.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Invalid choice!\nPress 'Esc' to exit.");
                report();
                
            }
            
        //Parsing the user input into an integer. It was a string to check for null or nothing but now must be an integer.
        int chosenOption = Integer.parseInt(reportOption);
            
        switch (chosenOption) {
            case 1:
                displayAllDone();
                break;
            case 2:
                displayMostHours();
                break;
            case 3:
                displayAll();
                break;
            case 4:
                search();
                break;
            case 5:
                deleteTask();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input, Please try again.");
                report();
                break;
        }
    }
    
    public void displayAllDone() {
        for (int i = 0; i < taskStatus.size(); i++) {
            if(taskStatus.get(i).equals("Done")) {
                JOptionPane.showMessageDialog(null, tasks.get(i));
            }
        }
        report();
    }
    
    public void displayMostHours() {
        int longestTask = 0;
        for (int i = 0; i < taskDuration.size(); i++) {
            if(taskDuration.get(i) > longestTask){
                longestTask = taskDuration.get(i);
            }
            for (int j = 0; j < taskNumber; j++) {
                if(taskDuration.get(j) == longestTask) {
                    JOptionPane.showMessageDialog(null, "The longest task to complete will be the task named: " + taskNames.get(j));
                }
            }
            
        }
        report();
    }
    
    public void displayAll() {
        for (int i = 0; i < taskNumber; i++) {
                    JOptionPane.showMessageDialog(null, tasks.get(i));
                    /*
                        displays from newest to oldest
                            needs to be from oldest to newest
                            needs to be multiple tasks displayed at once
                    */
                }
        report();
    }
    
    public void search() {
        String searchInput = JOptionPane.showInputDialog(null, "Search for a task: \n");
        
        if(searchInput == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using this program!\n==============================");                                                          
            System.exit(0);
        } else if(searchInput.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Invalid choice!\nPress 'Esc' to exit.");
            search();
        }
        
        for (int i = 0; i < taskNumber; i++) {
            System.out.println(searchInput);
            if(searchInput.equals(taskNames.get(i))) {
                System.out.println(taskNames.get(i));
                JOptionPane.showMessageDialog(null, tasks.get(i));
            }
        }
        
        report();
        
    }
    
    public void deleteTask() {
        String searchInput = JOptionPane.showInputDialog(null, "Search for a task: \n");
        
        for (int i = 0; i < taskNumber; i++) {
            if(searchInput.equals(taskNames.get(i))) {
                JOptionPane.showMessageDialog(null, taskNames.get(i) + "Has been removed.");
                tasks.remove(i);
                
            }
        }
        report();
    }
    
    
    /*
        new button? 
    */
    
//    ArrayList <String> developer = new ArrayList <String> ();
//    ArrayList <String> taskNames = new ArrayList <String> ();
//    ArrayList <String> taskID = new ArrayList <String> ();
//    ArrayList <Integer> taskDuration = new ArrayList <Integer> ();
//    ArrayList <String> taskStatus = new ArrayList <String> ();
//    ArrayList <String> taskDescription = new ArrayList <String> ();
}