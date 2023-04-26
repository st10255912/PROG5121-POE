

package progpoetaskone;

import javax.swing.JOptionPane;


public class Login {
    
    public static void run() {
        
        housekeeping();
        
        String loginUsername = getLoginUsername();
        String loginPassword = getLoginPassword();
        
        boolean valid = loginUser(loginUsername, loginPassword);
        
        String loginStatus = returnLoginStatus(valid);
        JOptionPane.showMessageDialog(null,loginStatus + "\nWelcome " + loginUsername);
        
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
        
        String username = "H_rt1";
        String password = "H@rtslief1";
        
        /*
        my best guess is to use a for loop like so:
        
        for(i=0 ; UserData ; i++) {
            if(loginUsername.equals(username) && loginPassword.equals(password)){
                return true;
            }
            return false;
        }
        
        I would hope that it would search through the UserData class's parrallel array
        and if the loginUsername and loginPassword match any username and password in
        the array then it would return true.
        
        */
        while(!loginUsername.equals(username) && !loginPassword.equals(password)){
            return false;
        }
        return true;
        
    }
    
    public static String returnLoginStatus(boolean valid){
        String loginStatus;
            if(valid == true){
                loginStatus = "Successful Login!";
            }else 
                loginStatus = "Unsuccessful Login!\nPress '2' to try again!";
                
        return loginStatus;
    }
}
