

package progpoetaskone;

import javax.swing.JOptionPane;

public class Registration {
    
    public static void run() {
        
        housekeeping();
        
        String username = getUsername();
        String password = getPassword();
        JOptionPane.showMessageDialog(null,"Username and Password successfully captured!");
        String firstName = getFirstName();
        String lastName = getLastName();

        registerUser(username, password, firstName, lastName);

    } 
    
    public static void housekeeping() {
        JOptionPane.showMessageDialog(null, """
                           Welcome to PROG5121 Task 1 (ST10255912)
                           =======================================
                           Please follow the prompts to register a new account!
                           
                           """);
    }
    
    public static String getUsername() {
        String username = JOptionPane.showInputDialog(null, """
                                                                                    Username must be: 
                                                                                    -No longer than 5 characters and,
                                                                                    -Must contain an underscore (_)

                                                            
                                                                                    Enter Username: """);
        
        while (!checkUserName(username) || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Username. \nUsername must be no longer than 5 characters and must contain an underscore (_)");
            
            return getUsername();
            
        }
        
        return username;
    }
    
    public static boolean checkUserName(String username) {
        if (username == null) {
            JOptionPane.showMessageDialog(null,"bye!");
            System.exit(0);
        }
        
        while(!username.contains("_") || username.length() > 5)
        {
            return false;
        }
        return true;
    }
    
    public static String getPassword() {
        String password = JOptionPane.showInputDialog(null, """
                                                                                    a password that contains the following:
                                                                                    -At least 8 characters long.
                                                                                    -At least one uppercase letter.
                                                                                    -At least one lowercase letter.
                                                                                    -At least one digit. 
                                                                                    -At least 1 special character.   
                                                            
                                                  
                                                                                    Enter password: """);
        
        while (!checkPasswordComplexity(password) || password.isEmpty()) {
            JOptionPane.showMessageDialog(null,"""
                                                                    Invalid password.
                                                                    Please enter a password that contains the following:
                                                                    -At least 8 characters long.
                                                                    -At least one uppercase letter.
                                                                    -At least one lowercase letter.
                                                                    -At least one digit. 
                                                                    -At least 1 special character.""");
            
            return getPassword();
        }
        
        return password;
    }
    
    public static boolean checkPasswordComplexity(String password) {
        if (password == null) {
            JOptionPane.showMessageDialog(null,"bye!");
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
        
        if (firstName == null) {
            JOptionPane.showMessageDialog(null,"bye!");
            System.exit(0);
        }
        
        return firstName;
    }

    public static String getLastName() {
        String lastName = JOptionPane.showInputDialog(null,"Enter Your Last Name: ");
        
        if (lastName == null) {
            JOptionPane.showMessageDialog(null,"bye!");
            System.exit(0);
        }
        
        return lastName;
    }
    
    public static void registerUser(String username, String password, String firstName, String lastName) {
        JOptionPane.showMessageDialog(null, 
                            "\nUsername is correctly formatted!\n"
                            + "Password meets complexity requirements!\n"
                            + "Username:..... " + username
                            + "\nPassword:..... " + password
                            + "\nFirst Name:... " + firstName
                            + "\nLast Name:.... " + lastName + "\n"
                            + "\nRegistration Successful!"
                            + "\n======================================="); 
    }
}




