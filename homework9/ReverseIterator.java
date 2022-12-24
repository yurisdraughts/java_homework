import java.util.Iterator;

public class ReverseIterator implements Iterator<Student> {
    private int index;

    private StudentGroup studentGroup;

    public ReverseIterator(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
        this.index = studentGroup.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Student next() {
        return studentGroup.getStudent(index--);
    }
}
