package progpoetaskone;

import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        
        //runs the method that is used to select 1. 2. or esc.
        UserSelection();
    }
    
    public static void UserSelection() {
        
        //While loop used so that users can continuosly register and login until exited.
        while(true){
            Scanner kb = new Scanner(System.in);
            //Prompts user to select one of three options.
            System.out.println( "1: Register \n2: Login \n3: Exit \n\nEnter your choice: ");
            String choice = kb.next();
            
            //This checks if nothing was entered, if nothing was entered then the user will be prompted to try again.
            if(choice.trim().equals("")){
                System.out.println("Invalid choice!\nPress 'Esc' to exit.");
                UserSelection();
                break;
            }
            
            //Parsing the user input into an integer. It was a string to check for null or nothing but now must be an integer.
            int chosenNum = Integer.parseInt(choice);
            
            switch(chosenNum){
                case 1:
                    
                    //Option for Registration.
                    Registration registration = new Registration();
                    registration.run();
                    break;
                case 2:
                    
                    //Option for Login.
                    Login login = new Login();
                    login.run();
                    break;
                case 3:
                    
                    //Option for Exit
                    System.out.println("Thank you for using this program. Bye!");
                    System.exit(0);
                default:
                    
                    //If anything other than nothing, null, 1 or 2 is entered
                    System.out.println("Invalid choice! Try Again.");
                    break;
            }
        }
    }
}