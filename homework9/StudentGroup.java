import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class StudentGroup implements Iterable<Student> {
    private List<Student> studentList;

    public StudentGroup(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int size() {
        return studentList.size();
    }

    public Student getStudent(int index) {
        return studentList.get(index);
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(this);
    }

    public ListIterator<Student> listIterator() {
        return new GroupListIterator(this);
    }

    public Iterator<Student> descendingIterator() {
        return new ReverseIterator(this);
    }
}
