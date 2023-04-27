

package progpoetaskone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class UserDatabase {
    
    String directory = System.getProperty("user.dir");
    String filePath = directory + File.separator + "credentials.txt";
    
    public static void run() {
    String fileName = "credentials.txt";
    String username = "myUsername";
    String password = "myPassword";

    try {
      FileWriter writer = new FileWriter(fileName);
      writer.write(username + ":" + password);
      writer.close();
      System.out.println("Successfully wrote credentials to file.");
    } catch (IOException e) {
      System.out.println("An error occurred while writing to the file.");
      e.printStackTrace();
    }
  }
}
    

