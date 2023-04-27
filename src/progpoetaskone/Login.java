

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
        boolean valid = loginUser(loginUsername, loginPassword);
        String loginStatus = returnLoginStatus(valid);
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
        return loginUsername;
    }
    
    public static String getLoginPassword() {
        String loginPassword = JOptionPane.showInputDialog(null, "Enter Password: ");
        return loginPassword;
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
        String fileName = "credentials.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String firstName = parts[2];
                String lastName = parts[3];
                String loginStatus;
                if(valid == true){
                    loginStatus = "Successful Login!";
                    JOptionPane.showMessageDialog(null,loginStatus + "\nWelcome " + firstName + " " + lastName);
                }else 
                    loginStatus = "Unsuccessful Login!\nPress '2' to try again!";
            return loginStatus;
            }
            
        reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return loginStatus;
    }

        
    

