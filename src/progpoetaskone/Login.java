

package progpoetaskone;

import java.util.Scanner;


public class Login {
    
    public static void main(String[] args) {
        
        String loginUsername = getLoginUsername();
        String loginPassword = getLoginPassword();
        
        boolean valid = loginUser(loginUsername, loginPassword);
        
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
    
    public static boolean loginUser(String loginUsername, String loginPassword) {
        
        String username = "H_rt1";
        String password = "H@rtslief1";
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
