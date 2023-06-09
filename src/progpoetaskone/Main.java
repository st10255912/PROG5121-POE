package progpoetaskone;

import javax.swing.JOptionPane;


public class Main {
    
    public static void main(String[] args) {
        
        //runs the method that is used to select 1. 2. or esc.
        userSelection();
    }
    
    public static void userSelection() {
        
        //While loop used so that users can continuosly register and login until exited.
        while(true){
            
            //Prompts user to select one of three options.
            String choice = JOptionPane.showInputDialog(null, "1: Register \n2: Login \nEsc: Exit \n\nEnter your choice: ");
           
            /*if / if else used to make the program nicer to use.
            This checks if null was returned (for example if they press esc or the 'x' in the top right corner) then closed the program as an exit option.*/
            if(choice == null) {
                JOptionPane.showMessageDialog(null,"Thank you for using this program!\n==============================");                                                          
                System.exit(0);
            }
            
            //This checks if nothing was entered, if nothing was entered then the user will be prompted to try again.
            else if(choice.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Invalid choice!\nPress 'Esc' to exit.");
                userSelection();
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
                default:
                    
                    //If anything other than nothing, null, 1 or 2 is entered
                    JOptionPane.showMessageDialog(null,"Invalid choice! Try Again.");
                    break;
            }
        }
    }
}