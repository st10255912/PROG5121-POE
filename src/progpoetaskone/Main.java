

package progpoetaskone;

import javax.swing.JOptionPane;


public class Main {
    
    public static void main(String[] args) {
        UserSelection();
    }
    
    public static void UserSelection() {
        while(true){
            String choice = (JOptionPane.showInputDialog(null, "1. Register \n2. Login \n3. Exit \nEnter your choice: "));
            
            if(choice == null) {
                JOptionPane.showMessageDialog(null,"bye!");
                System.exit(0);
            }
            else if(choice.trim().equals("")){
                JOptionPane.showMessageDialog(null,"Invalid choice");
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
                case 3:
                    JOptionPane.showMessageDialog(null,"""
                                                                  Thank you for using this program!
                                                                ==============================
                                                                             """);
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Invalid choice");
                    break;
            }
        }
    }
}