/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sheng
 */
public class NewClassTest {
    
    public NewClassTest() {
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
     * Test of method method, of class NewClass.
     */
    @Test
    public void testMethod() {
        System.out.println("method");
        int i = 0;
        NewClass instance = new NewClass();
        instance.method(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
