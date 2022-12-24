import java.util.Iterator;

public class StudentGroupIterator implements Iterator<Student> {
    private int index;

    private StudentGroup studentGroup;

    public StudentGroupIterator(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < studentGroup.size();
    }

    @Override
    public Student next() {
        return studentGroup.getStudent(index++);
    }

}
