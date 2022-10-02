/**
 * TODO: Complete the solution for Student
 */
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    public Student(String firstName, String lastName, String PID){
        if(firstName==null||lastName==null||PID==null){
            throw new IllegalArgumentException();
        }
        this.firstName=firstName;
        this.lastName=lastName;
        this.PID=PID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPID() {
        return PID;
    }

    @Override
    public boolean equals(Object o) {
        if(compareTo((Student)o)==0){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,lastName,PID);
    }

    @Override
    public int compareTo(Student o) {
        if(this.lastName.equals(o.lastName)==false){
            return this.lastName.compareTo(o.lastName);
        }
        if(this.firstName.equals(o.firstName)==false){
            return this.firstName.compareTo(o.firstName);
        }
        if(this.PID.equals(o.PID)==false){
            return this.PID.compareTo(o.PID);
        }
        return 0;
    }
}
