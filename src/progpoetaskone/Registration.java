

package progpoetaskone;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Registration {
    
    public static void run() {
        
        housekeeping();
        String fileName = "credentials.txt";
        String username = getUsername();
        String password = getPassword();
        String firstName = getFirstName();
        String lastName = getLastName();

        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(username + ":" + password + ":" + firstName + ":" + lastName + "\n");
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"An error occurred while registering your profile");
        }

        registerUser(username, password, firstName, lastName);
  }


    
    public static void housekeeping() {
        JOptionPane.showMessageDialog(null, "Welcome to PROG5121 Task 1 (ST10255912)\n=======================================\nPlease follow the prompts to register a new account!");                
    }
    
    public static String getUsername() {
        String username = JOptionPane.showInputDialog(null, "Username must be:\n-No longer than 5 characters and,\n-Must contain an underscore (_)\n\n\nEnter Username:");

        while (!checkUsername(username) || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Username. \nUsername must be no longer than 5 characters and must contain an underscore (_)");
            return getUsername();
        }
        JOptionPane.showMessageDialog(null,"Username is correctly formatted!....\n\nUsername successfully captured!");
        return username;
    }
    
    public static boolean checkUsername(String username) {
        if (username == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using this program. Bye!");
            System.exit(0);
        }
        
        while(!username.contains("_") || username.length() > 5)
        {
            return false;
        }
        return true;
    }
    
    public static String getPassword() {
        String password = JOptionPane.showInputDialog(null, "Please ensure that the password contains:\n -At least 8 characters long.\n-At least one uppercase letter.\n-At least one lowercase letter.\n-At least one digit.\n-At least 1 special character.\n\n\n Enter password:\n");
                                                                          
        while(!checkPasswordComplexity(password) || password.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Invalid password.\nPlease enter a password that contains the following:\n-At least 8 characters long.\n-At least one uppercase letter.\n-At least one lowercase letter.\n-At least one digit.\n-At least 1 special character.");
            return getPassword();
        }
        JOptionPane.showMessageDialog(null,"Password meets complexity requirements!....\n\nPassword successfully captured!");
        return password;
    }
    
    public static boolean checkPasswordComplexity(String password) {
        if (password == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using this program. Bye!");
            System.exit(0);
        }
        
        if(password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;   
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isDigit(c)&& !Character.isLetter(c)&& !Character.isWhitespace(c)){
                hasSpecial = true;
            }

            if (hasUppercase && hasLowercase && hasDigit && hasSpecial) {
                return true;
            }
        }
        
        return false;
    }
    
    public static String getFirstName() {
        String firstName = JOptionPane.showInputDialog(null,"Enter Your First Name: ");
        
        if(firstName == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using this program. Bye!");
            System.exit(0);
        }
        while(!checkFirstName(firstName)){
            JOptionPane.showMessageDialog(null,"It looks like you left the previous option empty. Please Enter your first name again.");
            return getFirstName();
        }

        return firstName;
    }
    
    public static boolean checkFirstName(String firstName){
        while(firstName.length() < 1) {
            return false;
        }
        return true;
    }

    public static String getLastName() {
        String lastName = JOptionPane.showInputDialog(null,"Enter Your First Name: ");
    
        if(lastName == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using this program. Bye!");
            System.exit(0);
        }
        while(!checkFirstName(lastName)){
            JOptionPane.showMessageDialog(null,"It looks like you left the previous option empty. Please Enter your last name again.");
            return getLastName();
        }

        return lastName;
    }
    
    public static boolean checkLastName(String lastName){
        while(lastName.length() < 1) {
            return false;
        }
        return true;
    }
    
    public static void registerUser(String username, String password, String firstName, String lastName) {
        JOptionPane.showMessageDialog(null, "Your Profile: \n\nUsername:..... " + username + "\nPassword:..... " + password + "\nFirst Name:... " + firstName + "\nLast Name:.... " + lastName + "\n\nRegistration Successful!\n=======================================");                       
    }
}




