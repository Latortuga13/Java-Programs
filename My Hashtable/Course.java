/**
 * TODO: Complete the solution for Course
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    public Course(String department, 
                  String number, 
                  String description,
                  int capacity){
        if(department==null||number==null||description==null||capacity<0){
            throw new IllegalArgumentException();
        }
        this.capacity=capacity;
        this.department=department;
        this.number=number;
        this.description=description;
        this.enrolled = new HashSet<Student>();
    }

    public String getDepartment(){
        return department;
    }

    public String getNumber(){
        return number;
    }

    public String getDescription(){
        return description;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean enroll(Student student) {
        if(student==null){
            throw new IllegalArgumentException("You put an illegal input in for the list");
        }
        if(enrolled.size()<capacity && 
            enrolled.contains(student)==false){
            enrolled.add(student);
            return true;
        }
        return false;
    }

    public boolean unenroll(Student student) {
        if(student==null){
            throw new IllegalArgumentException("You put an illegal input in for the list");
        }
        if(enrolled.contains(student)){
            enrolled.remove(student);
            return true;
        }
        return false;
    }

    public void cancel() {
        enrolled.clear();
    }

    public boolean isFull() {
        if(enrolled.size()==capacity){
            return true;
        }
        return false;
    }

    public int getEnrolledCount() {
        return enrolled.size();
    }

    public int getAvailableSeats() {
        return capacity-enrolled.size();
    }

    public HashSet<Student> getStudents() {
        return (HashSet<Student>)enrolled.clone();
    }

    public ArrayList<Student> getRoster() {
        ArrayList<Student> roster = new ArrayList<Student>();
        Iterator<Student> itor = enrolled.iterator();
        while(itor.hasNext()){
            roster.add(itor.next());
        }
        return roster;
    }

    public String toString() {
        return department+" "+number+" ["+capacity+"]"+"\n"+description;
    }
}

