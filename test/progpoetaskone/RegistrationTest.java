package progpoetaskone;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RegistrationTest {
    
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
//    public void testInvalidGetUsername() {
//        System.out.println("Testing output for an invalid username...");
//        String expResult = "kyle!!!!!!!";
//        String result = Registration.getUsername();
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testValidGetUsername() {    
//        System.out.println("Testing output for a valid username...");
//        String expResult = "kyl_1";
//        String result = Registration.getUsername();
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
//    public void testInvalidGetPassword() {
//        System.out.println("Testing output for an invalid password...");
//        String expOutput = "password";
//        String actualOutput = Registration.getPassword();
//        assertEquals(expOutput, actualOutput);
//    }   
//        
//    @Test
//    public void testValidGetPassword() { 
//        System.out.println("Testing output for a valid password...");
//        String expOutput = "Ch&&sec@ke99!";
//        String actualOutput = Registration.getPassword();
//        assertEquals(expOutput, actualOutput);
//
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