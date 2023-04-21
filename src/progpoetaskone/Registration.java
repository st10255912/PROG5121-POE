

package progpoetaskone;

import java.util.Scanner;


public class Registration {
    
    public static void main(String[] args) {
        String profile;
        
        housekeeping();
        String username = getUsername();
        String password = getPassword();
        String firstName = getFirstName();
        String lastName = getLastName();
        
        registerUser(username, password, firstName, lastName);
 
    } 
    
    public static void housekeeping() {
        System.out.println("""
                           Welcome to PROG5121 Task 1 (ST10255912)
                           =======================================
                           Please follow the prompts to register a new account!
                           
                           """);
    }
    
    public static String getUsername() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = kb.next();
        
        while (!checkUserName(username)) {
            System.out.println("Invalid Username. \nUsername must be no longer than 5 characters and must contain an underscore (_)");
            
            return getUsername();
            
        }
        System.out.println("Username successfully captured!");
        return username;
    }
    
    public static boolean checkUserName(String username) {
        while(!username.contains("_") || username.length() > 5)
        {
            return false;
        }
        return true;
    }
    
    public static String getPassword() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Password: ");
        String password = kb.next();
        
        while (!checkPasswordComplexity(password)) {
            System.out.println("""
                               Invalid password.
                               Please enter a password that contains the following:
                               -At least 8 characters long.
                               -At least one uppercase letter.
                               -At least one lowercase letter.
                               -At least one digit. 
                               -At least 1 special character.""");
            
            return getPassword();
        }
        System.out.println("Password successfully captured!");
        return password;
    }
    
    public static boolean checkPasswordComplexity(String password) {
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
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String firstName = kb.next();
        
        return firstName;
    }

    public static String getLastName() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Last Name:");
        String lastName = kb.next();
        
        return lastName;
    }
    
    public static void registerUser(String username, String password, String firstName, String lastName) {
        System.out.println("\nUsername is correctly formatted!\n"
                            + "Password meets complexity requirements!\n"
                            + "Username:... " + username
                            + "\nPassword:... " + password
                            + "\nFirst Name:. " + firstName
                            + "\nLast Name:.. " + lastName + "\n"
                            + "\nRegistration Successful!"
                            + "\n=======================================");
    }
}




