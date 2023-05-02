
package progpoetaskone;

import org.junit.*;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Login tests starting...");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Login tests complete!");
    }
    
    @Before
    public void setUp() {
        System.out.println("Method test starting...");
    }
    
    @After
    public void tearDown() {
        System.out.println("Method Testing complete!");
    }

    @Test
    public void testLoginUser() {
        System.out.println("Testing loginUser method with an invalid login...");
        String invalidUsername = "kyle!!!!!!!";
        String invalidPassword = "password";
        assertFalse(Login.loginUser(invalidUsername, invalidPassword));
        
        System.out.println("Testing loginUser method with a valid login...");
        String validUsername = "kyl_1";
        String validPassword = "Ch&&sec@ke99!";
        assertTrue(Login.loginUser(validUsername, validPassword));
    }
}
