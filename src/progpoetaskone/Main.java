

package progpoetaskone;

import javax.swing.JOptionPane;


public class Main {
    
    public static void main(String[] args) {
        NumberFormatExceptionHandling();
    }
    
    public static void UserSelection() throws NumberFormatException{
        while(true){
            String choice = (JOptionPane.showInputDialog(null, "1: Register \n2: Login \nEsc: Exit \n\nEnter your choice: "));
           
            if(choice == null) {
                JOptionPane.showMessageDialog(null,"""
                                                                  Thank you for using this program!
                                                                ==============================
                                                                             """);
                System.exit(0);
            }
            else if(choice.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Invalid choice!\nPress 'Esc' to exit.");
                UserSelection();
                break;
            }

            int chosenNum = Integer.parseInt(choice);
            
            switch(chosenNum){
                case 1:
                    Registration registration = new Registration();
                    registration.run();
                    break;
                case 2:
                    Login login = new Login();
                    login.run();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Invalid choice");
                    break;
            }
        }
    }
    
    public static void NumberFormatExceptionHandling(){
        try {
            UserSelection();
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Invalid choice");
            UserSelection();
        }
    }
}