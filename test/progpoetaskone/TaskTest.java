package progpoetaskone;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TaskTest {
    
    public TaskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class Task.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Task.run();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of menu method, of class Task.
     */
    @Test
    public void testMenu() {
        System.out.println("menu");
        Task instance = new Task();
        instance.menu();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addTask method, of class Task.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Task instance = new Task();
        instance.addTask();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getNumberOfTasks method, of class Task.
     */
    @Test
    public void testGetNumberOfTasks() {
        System.out.println("getNumberOfTasks");
        int expResult = 2;
        int result = Task.getNumberOfTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTaskStatus method, of class Task.
     */
    @Test
    public void testGetTaskStatus() {
        System.out.println("getTaskStatus");
        Task instance = new Task();
        String expResult = "To Do";
        String result = instance.getTaskStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getDevName method, of class Task.
     */
    @Test
    public void testGetDevName() {
        System.out.println("getDevName");
        Task instance = new Task();
        String expResult = "Robyn Harrison";
        String result = instance.getDevName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTaskName method, of class Task.
     */
    @Test
    public void testGetTaskName() {
        System.out.println("getTaskName");
        Task instance = new Task();
        String expResult = "Login Feature”";
        String result = instance.getTaskName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTaskDescription method, of class Task.
     */
    @Test
    public void testGetTaskDescription() {
        System.out.println("getTaskDescription");
        Task instance = new Task();
        String expResult = "Create Login to authenticate users”";
        String result = instance.getTaskDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTaskDuration method, of class Task.
     */
    @Test
    public void testGetTaskDuration() {
        System.out.println("getTaskDuration");
        Task instance = new Task();
        int expResult = 8;
        int result = instance.getTaskDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        String taskDescriptionFalse = "This description is way too long for it to be accepted as a description for the program";
        boolean expResultFalse = false;
        boolean resultFalse = Task.checkTaskDescription(taskDescriptionFalse);
        assertEquals(expResultFalse, resultFalse);
        // TODO review the generated test code and remove the default call to fail.
        
        String taskDescriptionTrue = "This description is fine";
        boolean expResultTrue = true;
        boolean resultTrue = Task.checkTaskDescription(taskDescriptionTrue);
        assertEquals(expResultTrue, resultTrue);
        
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
        System.out.println("createTaskID");
        Task instance = new Task();
        String expResult = "LO:0:BYN";
        String result = instance.createTaskID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        Task instance = new Task();
        String expResult = "";
        String result = instance.printTaskDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}
