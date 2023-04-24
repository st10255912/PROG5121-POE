

package progpoetaskone;

import java.util.Scanner;


public class Login {
    
    public static void run() {
        
        String loginUsername = getLoginUsername();
        String loginPassword = getLoginPassword();
        int index = 0;
        boolean valid = loginUser(loginUsername, loginPassword, index);
        
        String loginStatus = returnLoginStatus(valid);
        System.out.println(loginStatus);
        
    }  
    
    public static String getLoginUsername() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String loginUsername = kb.next();
        
        return loginUsername;
    }
    
    public static String getLoginPassword() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Password: ");
        String loginPassword = kb.next();
        
        return loginPassword;
    }
    
    public static boolean loginUser(String loginUsername, String loginPassword, int index) {
        
        String username = UserCredentials.usernames[index];
        String password = UserCredentials.passwords[index];

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
                loginStatus = "Unsuccessful Login!";
        return loginStatus;
    }
}
