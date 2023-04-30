

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
        String loginFirstName = getLoginFirstName(loginUsername, loginPassword);
        String loginLastName = getLoginLastName(loginUsername, loginPassword);
        boolean valid = loginUser(loginUsername, loginPassword);
        String returnLoginStatus = returnLoginStatus(valid, loginFirstName, loginLastName);

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
        if(loginUsername == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using the program. Bye!");
            System.exit(0);
        }
        if (loginUsername.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
            getLoginUsername();
        } 
        return loginUsername;
    }
    
    public static String getLoginPassword() {
        String loginPassword = JOptionPane.showInputDialog(null, "Enter Password: ");
        if(loginPassword == null) {
            JOptionPane.showMessageDialog(null,"Thank you for using the program. Bye!");
            System.exit(0);
        }
        if (loginPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
            getLoginPassword();
        }
        return loginPassword;
    }
    
    public static String getLoginFirstName(String loginUsername, String loginPassword){
        String fileName = "credentials.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                if (parts[0].equals(loginUsername) && parts[1].equals(loginPassword)) {
                    String loginFirstName = parts[2];
                    return loginFirstName;
            }
        }
        reader.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return null;
    }
    
    public static String getLoginLastName(String loginUsername, String loginPassword){
        String fileName = "credentials.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                if (parts[0].equals(loginUsername) && parts[1].equals(loginPassword)) {
                    String loginLastName = parts[3];
                    return loginLastName;
                }
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
                        return valid;
                    }
            }

        reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }

        return false;
    }
    
    public static String returnLoginStatus(boolean valid, String loginFirstName, String loginLastName){
        String loginStatus;

        if(valid == true){
            loginStatus = "Successful Login!\nWelcome " + loginFirstName + " " + loginLastName;
            JOptionPane.showMessageDialog(null, loginStatus);
            System.exit(0);
        } else {
            loginStatus = "Unsuccessful Login!\nUsername or Password may be incorrect!\nTry Again.";
            JOptionPane.showMessageDialog(null, loginStatus);
            run();
        }
        return loginStatus;
    }
    
}

        
    

