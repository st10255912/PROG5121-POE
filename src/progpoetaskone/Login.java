

package progpoetaskone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;


public class Login {
    
    public static void run() {
        housekeeping();
        String loginUsername = getLoginUsername();
        String loginPassword = getLoginPassword();
        String loginFirstName = getLoginFirstName();
        String loginLastName = getLoginLastName();
        boolean valid = loginUser(loginUsername, loginPassword);
        String loginStatus = returnLoginStatus(valid);

        if(loginStatus.matches("Successful Login!")){
            JOptionPane.showMessageDialog(null,"Welcome " + loginFirstName + " " + loginLastName);
        }
    }  
    
    public static void housekeeping() {
        JOptionPane.showMessageDialog(null, """
                                                                    Login Page
                                                       ======================================
                                                         Please follow the prompts to login!

                                                                    """);
    }
    
    public static String getLoginUsername() {
        String loginUsername = JOptionPane.showInputDialog(null, "Enter Username: ");
        if (loginUsername.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
            getLoginUsername();
        }
        return loginUsername;
    }
    
    public static String getLoginPassword() {
        String loginPassword = JOptionPane.showInputDialog(null, "Enter Password: ");
        if (loginPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
            getLoginPassword();
        }
        return loginPassword;
    }
    
    public static String getLoginFirstName(){
        String fileName = "credentials.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                String firstName = parts[2];
                return firstName;
            }

        reader.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return null;
    }
    
    public static String getLoginLastName(){
        String fileName = "credentials.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                String firstName = parts[3];
                return firstName;

            }

        reader.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

         return null;
    }
    
    
    
    
    
    public static boolean loginUser(String loginUsername, String loginPassword) {
        String fileName = "credentials.txt";
        boolean valid = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String username = parts[0];
                String password = parts[1];

                    if (loginUsername.equals(username) && loginPassword.equals(password)) {
                        valid = true;
                        return true;
                    }
            }

        reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        if (valid) {
            System.out.println("Username and password match.");
        } else {
            System.out.println("Username and password do not match.");
        }
        return false;
    }
    
    public static String returnLoginStatus(boolean valid){
        String loginStatus;
        
        if(valid == true){
            loginStatus = "Successful Login!";
        } else
            loginStatus = "Unsuccessful Login!";
        return loginStatus;
    }
    
}

        
    

