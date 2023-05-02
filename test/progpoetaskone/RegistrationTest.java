package progpoetaskone;

import org.junit.*;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RegistrationTest {
    
    Registration registration = new Registration();

    public RegistrationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Registration tests starting...");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Registration tests complete!");
    }
    
    @Before
    public void setUp() {
        System.out.println("Method test starting...");
    }
    
    @After
    public void tearDown() {
        System.out.println("Method Testing complete!");
    }

//    @Test
//    public void testGetUsername() {
//        System.out.println("Testing output for an invalid username...");
//        String expResult = "Invalid Username. \nUsername must be no longer than 5 characters and must contain an underscore (_)";
//        
//        String result = Registration.getUsername();
//        
//        System.out.println(result);
//        
//        assertEquals(expResult, result);
//        
//        
//        System.out.println("Testing output for a valid username...");
//        expResult = "kyl_1";
//        
//        result = Registration.getUsername();
//        
//        System.out.println(result);
//        
//        assertEquals(expResult, result);
//    }

    @Test
    public void testCheckUserName() {
        System.out.println("Testing an invalid username...");
        String invalidUsername = "kyle!!!!!!!";
        assertFalse(Registration.checkUsername(invalidUsername));
        
        System.out.println("Testing an valid username...");
        String validUsername = "kyl_1";
        assertTrue(Registration.checkUsername(validUsername));
    }
        
//    @Test
//    public void testGetPassword() {
//        System.out.println("Testing output for an invalid username...");
//        String expResult = "password";
//        
//        String result = Registration.getPassword();
//        
//        System.out.println(expResult);
//        System.out.println(result);
//        
//        assertEquals(expResult, result);
//        
//        
//        System.out.println("Testing output for a valid username...");
//        expResult = "Ch&&sec@ke99!";
//        
//        result = Registration.getPassword();
//        
//        System.out.println(expResult);
//        System.out.println(result);
//        
//        assertEquals(expResult, result);
//    }
    
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("Testing an invalid password...");
        String invalidPassword = "password";
        assertFalse(Registration.checkPasswordComplexity(invalidPassword));
        
        System.out.println("Testing a valid password...");
        String validPassword = "Ch&&sec@ke99!";
        assertTrue(Registration.checkPasswordComplexity(validPassword));
    }
}