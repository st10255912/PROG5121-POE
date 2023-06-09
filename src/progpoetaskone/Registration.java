



package progpoetaskone;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Registration {
    
    public static void run() {
        
        housekeeping();
        
        //Setting the .txt file to a variable to be used to write into.
        String fileName = "credentials.txt";
        
        //Setting variables to the outputs of the methods so that they can be written to a .txt file & used in a final output message.
        String username = getUsername();
        String password = getPassword();
        String firstName = getFirstName();
        String lastName = getLastName();
        
        //This writes the username, password, firstname and lastname into a .txt file. Then will start the same process on the next line.
        try {
            FileWriter writer = new FileWriter(fileName, true);
            
            //The writer object will append each variable and seperate it by a colon.
            writer.write(username + ":" + password + ":" + firstName + ":" + lastName + "\n");
            writer.close();
        } catch (IOException e) {
            
            //This lets the user know that there was a problem registering their profile.
            JOptionPane.showMessageDialog(null,"An error occurred while registering your profile");
            
            //The system will then close as a safety feature.
            System.exit(0);
        }

        registerUser(username, password, firstName, lastName);
    }

    public static void housekeeping() {
        
        //Displays a message to let the user know that the registration process has begun.
        JOptionPane.showMessageDialog(null, "      Welcome to PROG5121 Task 1 (ST10255912)\n=========================================\nPlease follow the prompts to register a new account!");                
    }
    
    public static String getUsername() {
        
        //Prompts the user for a username, also giving them the needed requirements.
        String username = JOptionPane.showInputDialog(null, "Username must be:\n-No longer than 5 characters and,\n-Must contain an underscore (_)\n\n\nEnter Username:");

        while(!checkUsername(username) || username.isEmpty()) {
            
            //This displays a message to let the user know that the username that they entered isnt valid.
            JOptionPane.showMessageDialog(null, "Invalid Username. \nUsername must be no longer than 5 characters and must contain an underscore (_)");
            
            //Then the user will be made to restart the username creation process.
            return getUsername();
        }
        
        //Lets the user know that their password has been successfully captured.
        JOptionPane.showMessageDialog(null,"Username is correctly formatted!....\n\nUsername successfully captured!");
        return username;
    }
    
    public static boolean checkUsername(String username) {
        
        //This checks if null was returned (for example if they press esc or the 'x' in the top right corner) then closed the program as an exit option.
        if(username == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using this program. Bye!");
            System.exit(0);
        }
        
        /*
        This while loop checks if:
        -If the username does not contain an underscore 
        OR 
        -The username if longer than 5 characters.
        */
        while(!username.contains("_") || username.length() > 5)
        {
            
            //If it meets the conditions of not containing an underscore or being longer than 5 characters then it will return false.
            return false;
        }
        
        //If the username does not meet the conditions by inluding an underscore AND the length is less then or equal to 5.
        return true;
    }
    
    public static String getPassword() {
        
        //Prompts the user for a password, also giving them the needed requirements.
        String password = JOptionPane.showInputDialog(null, "Please ensure that the password contains:\n -At least 8 characters long.\n-At least one uppercase letter.\n-At least one lowercase letter.\n-At least one digit.\n-At least 1 special character.\n\n\n Enter password:\n");
        
        //Checks if the password has passed the requirements.
        while(!checkPasswordComplexity(password) || password.isEmpty()) {
            
            //This displays a message to let the user know that the password that they entered isnt valid.
            JOptionPane.showMessageDialog(null,"Invalid password.\nPlease enter a password that contains the following:\n-At least 8 characters long.\n-At least one uppercase letter.\n-At least one lowercase letter.\n-At least one digit.\n-At least 1 special character.");
            
            //Then the user will be made to restart the password creation process.
            return getPassword();
        }
        
        //Lets the user know that their password has been successfully captured.
        JOptionPane.showMessageDialog(null,"Password meets complexity requirements!....\n\nPassword successfully captured!");
        return password;
    }
    
    public static boolean checkPasswordComplexity(String password) {
        
        //This checks if null was returned (for example if they press esc or the 'x' in the top right corner) then closed the program as an exit option.
        if(password == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using this program. Bye!");
            System.exit(0);
        }
        
        //This checks to see if the password is atleast 8 characters in length.
        if(password.length() < 8) {
            return false;
        }
        
        //Setting up some variables to check the password.
        boolean hasUppercase = false;   
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        //Splitting the string into a bunch of characters and then checking each character.
        for(char c : password.toCharArray()) {
            if(Character.isUpperCase(c)) {
                
                //checks if the character is uppercase.
                hasUppercase = true;
            } else if(Character.isLowerCase(c)) {
                
                //checks if the character is lowercase.
                hasLowercase = true;
            } else if(Character.isDigit(c)) {
                
                //checks if the character is a number.
                hasDigit = true;
            } else if(!Character.isDigit(c)&& !Character.isLetter(c)&& !Character.isWhitespace(c)){
                
                //checks that the character is not a number or a letter or a whitespace. If true then the character must be a special character.
                hasSpecial = true;
            }
            
            //Only if the string contains an uppercase, lowercase, a number and a special character does it return true.
            if(hasUppercase && hasLowercase && hasDigit && hasSpecial) {
                return true;
            }
        }
        
        //If the string doesnt meet the criteria then it will return false. This will be catched in the getPassword() method and a new attempt will be requested.
        return false;
    }
    
    public static String getFirstName() {
        
        //prompts the user for thier last name.
        String firstName = JOptionPane.showInputDialog(null,"Enter Your First Name: ");
        
        //This checks if null was returned (for example if they press esc or the 'x' in the top right corner) then closed the program as an exit option.
        if(firstName == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using this program. Bye!");
            System.exit(0);
        }
        
        //Checks if the checking method has cleared the last name, Note* this is just a way to make sure the user enters their last name.
        while(!checkFirstName(firstName)){
            
            //Outputs a message to let the user know that thier last name wasnt captured.
            JOptionPane.showMessageDialog(null,"It looks like you left the previous option empty. Please Enter your first name again.");
            
            //takes the user back to start the method again.
            return getFirstName();
        }

        return firstName;
    }
    
    public static boolean checkFirstName(String firstName){
        
        //checks if nothing is entered.
        while(firstName.length() < 1) {
            return false;
        }
        return true;
    }

    public static String getLastName() {
        
        //prompts the user for thier last name.
        String lastName = JOptionPane.showInputDialog(null,"Enter Your First Name: ");
        
        //This checks if null was returned (for example if they press esc or the 'x' in the top right corner) then closed the program as an exit option.
        if(lastName == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using this program. Bye!");
            System.exit(0);
        }
        
        //Checks if the checking method has cleared the last name, Note* this is just a way to make sure the user enters their last name.
        while(!checkFirstName(lastName)){
            
            //Outputs a message to let the user know that thier last name wasnt captured.
            JOptionPane.showMessageDialog(null,"It looks like you left the previous option empty. Please Enter your last name again.");
            
            //takes the user back to start the method again.
            return getLastName();
        }

        return lastName;
    }
    
    public static boolean checkLastName(String lastName){
        
        //checks if nothing is entered.
        while(lastName.length() < 1) {
            return false;
        }
        return true;
    }
    
    public static void registerUser(String username, String password, String firstName, String lastName) {
        
        //Outputs the users profile info.
        JOptionPane.showMessageDialog(null, "Your Profile: \n\nUsername:..... " + username + "\nPassword:..... " + password + "\nFirst Name:... " + firstName + "\nLast Name:.... " + lastName + "\n\nRegistration Successful!\n=======================================");                       
    }
}




/*
Java – Write to File. Webpage can be found at: https://www.baeldung.com/java-write-to-file
Java Program to Check Whether the String Consists of Special Characters. Webpage can be found at: https://www.geeksforgeeks.org/java-program-to-check-whether-the-string-consists-of-special-characters/
*/








