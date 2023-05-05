
package progpoetaskone;

import javax.swing.JOptionPane;

public class Task {
    public static void run() {
        JOptionPane.showMessageDialog(null,"Welcome to EasyKanban");
        String[] options = {"Option 1) Add Task", "Option 2) Show Report", "Option 3) Exit"};
        int selections = JOptionPane.showOptionDialog(null, "Choose an option:", "Numeric Menu",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
       
        switch(selections) {
                case 0:
                    addTask();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    run();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"Thank you for using this program!\n==============================");                                                        
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null,"Invalid Input, Please try again.");
                    run();
                    break;
        }          
    }
    
    public static void addTask() {
        int taskNum = 0;
        int totalHrs = 0;
        int taskAmt = getTaskAmt();

        while(taskNum <= taskAmt - 1){
            String devFirstName = getDevFirstName();
            String devLastName = getDevLastName();
            String taskTitle = getTaskTitle();
            int taskDuration = getTaskHours();
            String taskDescription = getTaskDescription();
            String taskID = createTaskID(taskTitle, taskNum, devLastName);
            String taskStatus = getOptionSelection();
            totalHrs = totalHrs + taskDuration;
            taskNum = taskNum + 1;
            
            JOptionPane.showMessageDialog(null, "Task successfully captured");
            JOptionPane.showMessageDialog(null,printTaskDetails(taskStatus, taskNum, devFirstName, devLastName, taskTitle, taskDescription, taskDuration, taskID, taskAmt));
        }
        
        returnTotalHours(totalHrs);
        run();
    }

    public static String getDevFirstName() {
        String devFirstName = JOptionPane.showInputDialog(null, "Enter the first name of the developer \nthis task will be assigned to: \n");
        
        return devFirstName;
    }
    
    public static String getDevLastName() {
        String devLastName = JOptionPane.showInputDialog(null, "Enter the last name of the developer \nthis task will be assigned to: \n");

        
        return devLastName;
    }
    
    public static int getTaskAmt() {
        String count = JOptionPane.showInputDialog(null, "Please enter the number of tasks you would like to add: ");
        
        if(count == null){
                JOptionPane.showMessageDialog(null,"Invalid choice!\nPress the Exit option to exit.");
                run();
            }else if(count.isEmpty()){
                JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
                addTask();
            }

        int taskAmt = Integer.parseInt(count);
        return taskAmt;
    }
    
    public static String getOptionSelection() {
        String[] taskOption = {"To Do", "Doing", "Done"};        
        int chosenOption = JOptionPane.showOptionDialog(null, "Choose an option:", "Numeric Menu",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, taskOption, taskOption[0]);
        String taskStatus = "";
        switch(chosenOption) {
                case 0:
                    JOptionPane.showMessageDialog(null, "To Do Selected");
                    //Will add the task to the TO DO coloumn
                    taskStatus = "TO DO";
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Doing Selected");
                    //Will add the task to the DOING coloumn
                    taskStatus = "DOING";
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Done Selected");
                    //Will add the task to the DONE coloumn
                    taskStatus = "DONE";
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Invalid Input, Please try again.");

                    break;
        }   
        return taskStatus;
    }
    
    public static String getTaskTitle() {
        String taskTitle = JOptionPane.showInputDialog(null, "Enter the title of the task: \n\n");

            if(taskTitle == null){
                JOptionPane.showMessageDialog(null,"Invalid choice!\nPress the Exit option to exit.");
                run();
            }
            while(taskTitle.isEmpty()){
                JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
                addTask();
            }
        return taskTitle;
    }
    
    public static int getTaskHours() {
        String userTaskHours = JOptionPane.showInputDialog(null,"Enter the number of hours this task will take: \n\n");

            if(userTaskHours == null){
                JOptionPane.showMessageDialog(null,"Invalid choice!\nPress the Exit option to exit.");
                run();
            }
            while(userTaskHours.isEmpty()){
                JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
                addTask();
            }

            int taskDuration = Integer.parseInt(userTaskHours);
        return taskDuration;
    }
    
    public static String getTaskDescription(){
        String taskDescription = JOptionPane.showInputDialog("Please enter a description of the task. (Description cannot be over 50 characters)\n\n");

        if(taskDescription == null){
            JOptionPane.showMessageDialog(null,"Invalid choice!\nPress the Exit option to exit.");
                run();
        }
        while(taskDescription.isEmpty()){
            JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
            return getTaskDescription();
        }
        
        while(checkTaskDescription(taskDescription) == false){
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            return getTaskDescription();
        }
        
        return taskDescription;
    }
    
    public static boolean checkTaskDescription(String taskDescription) {

        while(taskDescription.length() < 50){
            return true;
        }
        
        return false;
    }
    
    public static String createTaskID(String taskTitle, int taskNum, String devLastName) {
        String taskIDTaskTitle = taskTitle.substring(0,2);
        String taskIDPartOne = taskIDTaskTitle.toUpperCase();
        
        String taskIDName = devLastName.substring(devLastName.length()-3);
        String taskIDPart3 = taskIDName.toUpperCase();
        
        String taskID = taskIDPartOne + ":" + taskNum + ":" + taskIDPart3;
        
        return taskID;
    }
    
    public static int returnTotalHours(int totalHrs) {
        JOptionPane.showMessageDialog(null, "Total Number of hours across all tasks: " + totalHrs);

        return totalHrs;
    }
    
    public static String printTaskDetails(String taskStatus, int taskNum, String devFirstName, String devLastName, String taskTitle, String taskDescription, int taskDuration, String taskID, int taskAmt) {
        String taskDetails;
        taskDetails = "Task Status: \n" + taskStatus + "\n\n" + "Developer Name: \n" + devFirstName + " " + devLastName + "\n\n" + "Task Number: \n" + taskNum + "\n\n" + "Title: \n" + taskTitle + "\n\n" + "Description: \n" + taskDescription + "\n\n" + "Task ID: \n" + taskID + "\n\n" + "Duration: \n" + taskDuration;

        return taskDetails;
    }
}
