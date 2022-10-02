/**
 * TODO: Add your file header
 * Name: Seth
 * ID: A17075727
 * Email: schng@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This is my custom tester. It tests the methods i wrote in course.java, sanctuary.java, and student.java.
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when the values are not the same
     */
    @Test
    public void testEquals() {
        Student student1 = new Student(new String("Test"), 
        new String("Student"), new String("A12345678"));
        Student student2 = new Student(new String("Test2"), 
        new String("Student32"), new String("A135792470"));
        assertEquals(student1.equals(student2),false);
    }

    /**
     * Test the compareTo method when 
     */
    @Test
    public void testCompareTo() {
        Student student1 = new Student(new String("Test"), 
        new String("Student"), new String("A12345678"));
        Student student2 = new Student(new String("Test"), 
        new String("Student"), new String("A12345678"));
        assertEquals(student1.compareTo(student2),0);
    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when Illegal argument exception is thrown
     */
    @Test
    public void testEnroll() {
        Student student1 = null;
        Course science = new Course("science", "228", "a science class", 200);
        boolean thrown = false;
        try{
            science.enroll(student1);
        }
        catch(IllegalArgumentException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You put an illegal input in for the list",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * Test the unenroll method when Illegal argument exception is thrown
     */
    @Test
    public void testUnenroll() {
        Student student1 = null;
        Course science = new Course("science", "228", "a science class", 200);
        boolean thrown = false;
        try{
            science.unenroll(student1);
        }
        catch(IllegalArgumentException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You put an illegal input in for the list",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * Test the getRoster method when there is no one in the class
     */
    @Test
    public void testGetRoster() {
        Course science = new Course("science", "228", "a science class", 200);
        ArrayList<Student> roster = new ArrayList<Student>();
        assertEquals(science.getRoster(),roster);
    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when max species or max animals is less then 0
     */
    @Test
    public void testSanctuaryConstructor() {
        boolean thrown=false;
        boolean thrown1=false;
        try{
            Sanctuary sanct1 = new Sanctuary(-1,10);
        }
        catch(IllegalArgumentException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You put an illegal input in",iae.getMessage());
        }
        assertTrue(thrown);
        try{
            Sanctuary sanct2 = new Sanctuary(10,-1);
        }
        catch(IllegalArgumentException iae){
            thrown1 = true;
            assertEquals("check if exception was thrown","You put an illegal input in",iae.getMessage());
        }
        assertTrue(thrown1);
    }

    /**
     * Test the rescue method when the species animal space is full
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary sanct = new Sanctuary(100, 20);
        sanct.sanctuary.put("snake", 5);
        assertEquals(5, sanct.rescue("Snake", 100));
    }

    /**
     * Test the rescue method when species value is null and when num is <=0
     */
    @Test
    public void testRescueTestTwo(){
        Sanctuary sanct = new Sanctuary(100, 20);
        boolean thrown = false;
        boolean thrown1 = false;
        try{
            sanct.rescue(null, 10);
        }
        catch(IllegalArgumentException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You put an illegal input in",iae.getMessage());
        }
        try{
            sanct.rescue("fish", 0);
        }
        catch(IllegalArgumentException iae){
            thrown1 = true;
            assertEquals("check if exception was thrown","You put an illegal input in",iae.getMessage());
        }
        assertTrue(thrown);
        assertTrue(thrown1);
    }

    /**
     * Test the release method when num is <=0
     */
    @Test
    public void testReleaseTestOne(){
        Sanctuary sanct = new Sanctuary(100, 20);
        boolean thrown = false;
        try{
            sanct.release(null, 0);
        }
        catch(IllegalArgumentException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You put an illegal input in",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * Test the release method when the species getting released equals 0
     */
    @Test
    public void testReleaseTestTwo(){
        Sanctuary sanct = new Sanctuary(50, 5);
        sanct.sanctuary.put("wolves", 6);
        sanct.release("wolves",6);
        assertFalse(sanct.sanctuary.containsKey("wolves"));
    }
}

