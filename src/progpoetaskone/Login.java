

package progpoetaskone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;




public class Login {
    
    public static void run() {
        
        housekeeping();
        //Setting up variables to the outputs of methods so that they can be used in other methods.
        String loginUsername = getLoginUsername();
        String loginPassword = getLoginPassword();
        String loginFirstName = getLoginFirstName(loginUsername, loginPassword);
        String loginLastName = getLoginLastName(loginUsername, loginPassword);
        boolean valid = loginUser(loginUsername, loginPassword);
        returnLoginStatus(valid, loginFirstName, loginLastName);
    }  
    
    public static void housekeeping() {
        
        //Displays a message to let the user know that the registration process has begun.
        JOptionPane.showMessageDialog(null, "                    Login Page\n=================================\n      Please follow the prompts to login!");                                                                   
    }
    
    public static String getLoginUsername() {
        
        //Prompts the user for a username.
        String loginUsername = JOptionPane.showInputDialog(null, "Enter Username: ");
        
        //This checks if null was returned (for example if they press esc or the 'x' in the top right corner) then closed the program as an exit option.
        if(loginUsername == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using the program. Bye!");
            System.exit(0);
        }
        
        //If nothing was entered then the user will be prompted to try again.
        if(loginUsername.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
            getLoginUsername();
        }
        
        //If the username is not null or nothing then it will be returned.
        return loginUsername;
    }
    
    public static String getLoginPassword() {
        
        //Prompts the user for a password.
        String loginPassword = JOptionPane.showInputDialog(null, "Enter Password: ");
        
        //This checks if null was returned (for example if they press esc or the 'x' in the top right corner) then closed the program as an exit option.
        if(loginPassword == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using the program. Bye!");
            System.exit(0);
        }
        
        //If nothing was entered then the user will be prompted to try again.
        if(loginPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
            getLoginPassword();
        }
        
        //If the password is not null or nothing then it will be returned.
        return loginPassword;
    }
    
    public static String getLoginFirstName(String loginUsername, String loginPassword){
        
        //Setting the .txt file to a variable to be used to write into.
        String fileName = "credentials.txt";
        
        try {
            
            //Sets up reader object to read .txt file.
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            
            //Checks only if the array is not null. This also checks line by line.
            while((line = reader.readLine()) != null) {
                
                //Checks array seperated by a colon.
                String[] parts = line.split(":");
                
                //Checks if the username and password exists in the array.
                if(parts[0].equals(loginUsername) && parts[1].equals(loginPassword)) {
                    
                    //If the username and password do exist then it will grab the first name in that array.
                    String loginFirstName = parts[2];
                    return loginFirstName;
            }
        }
            
        //stops the reader.
        reader.close();
        
        //Used to catch any formatting errors that could be related to getting the first name of the user.
        } catch(IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        
        //If nothing exists then null will be returned to save space.
        return null;
    }
    
    public static String getLoginLastName(String loginUsername, String loginPassword){
        
        //Setting the .txt file to a variable to be used to write into.
        String fileName = "credentials.txt";

        try {
            
            //Sets up reader object to read .txt file.
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            
            //Checks only if the array is not null. This also checks line by line.
            while((line = reader.readLine()) != null) {
                
                //Checks array seperated by a colon.
                String[] parts = line.split(":");
                
                //Checks if the username and password exists in the array.
                if(parts[0].equals(loginUsername) && parts[1].equals(loginPassword)) {
                    
                    //If the username and password do exist then it will grab the last name in that array.
                    String loginLastName = parts[3];
                    return loginLastName;
                }
            }
            
        //stops the reader.   
        reader.close();
        
        //Used to catch any formatting errors that could be related to getting the last name of the user.
        } catch(IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        
    //If nothing exists then null will be returned to save space.
    return null;
    }
    
    public static boolean loginUser(String loginUsername, String loginPassword) {
        
        //Setting the .txt file to a variable to be used to write into.
        String fileName = "credentials.txt";
        
        //Setting a boolean variable to set the login successful or unsuccessful.
        boolean valid = false;

        try {
            
            //Sets up reader object to read .txt file.
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            
            //Checks only if the array is not null. This also checks line by line.
            while((line = reader.readLine()) != null) {
                
                //Checks array seperated by a colon.
                String[] parts = line.split(":");
                
                //Sets the first string in the array to username.
                String username = parts[0];
                
                //Sets the second string in the array to password.
                String password = parts[1];
                    
                    //Checks if the username and password that is stored matches the username and password that the user entered when logging in.
                    if(loginUsername.equals(username) && loginPassword.equals(password)) {
                        
                        //If it is equal then it will set that boolean variable to true to let the program know that a match has been found
                        valid = true;
                        
                        //It will then return the result.
                        return valid;
                    }
            }
            
        //stops the reader.
        reader.close();
        
        //Used to catch any formatting errors that could be related to getting the last name of the user.
        } catch(IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    
    //If nothing exists then null will be returned to save space.
    return false;
    }
    
    public static String returnLoginStatus(boolean valid, String loginFirstName, String loginLastName){
        
        //Setting up an empty string to be used later.
        String loginStatus;
        
        if(valid == true){
            
            //If the username and password match what is stored then the output will be:
            loginStatus = "Successful Login!\nWelcome " + loginFirstName + " " + loginLastName;
            JOptionPane.showMessageDialog(null, loginStatus);
            
            //Then the program will close. ***NOTE*** This will later be used to open their previous kanban board.
            Task task = new Task();
            task.run();
        } else {
            
            //If the username and password does not match what is stored then the output will be:
            loginStatus = "Unsuccessful Login!\nUsername or Password may be incorrect!\nTry Again.";
            JOptionPane.showMessageDialog(null, loginStatus);
            
            String failOption = JOptionPane.showInputDialog(null, "Please choose one of the following options: \n1. Return to main menu \n\n2. Retry Login");
            
            if(failOption == null) {
                JOptionPane.showMessageDialog(null,"Thank you for using this program!\n==============================");                                                        
                System.exit(0);
            }else if(failOption.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Invalid choice!\nPress 'Esc' to exit.");
                run();
                
            }
            
            int failOptionChoice = Integer.parseInt(failOption);
            
            switch(failOptionChoice) {
                    case 1:
                        Main main = new Main();
                        main.userSelection();
                        break;
                    case 2:
                        //The user will then be returned to the beginning of the login process to try again.
                        run();
                        break;
                    default:
                        //If anything other than nothing, null, 1 or 2 is entered
                        JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
                        break;
            }  
        }
    return loginStatus;
    }
}

        
    


//Reading a plain text file in Java. Webpage can be found at: https://stackoverflow.com/questions/4716503/reading-a-plain-text-file-in-java    
    


        
    

