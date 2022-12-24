import java.util.ListIterator;

public class GroupListIterator implements ListIterator<Student> {

    private int index;

    private StudentGroup studentGroup;

    public GroupListIterator(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < studentGroup.size();
    }

    @Override
    public Student next() {
        if (index == -1) index++;
        return studentGroup.getStudent(index++);
    }

    @Override
    public boolean hasPrevious() {
        return index >= 0;
    }

    @Override
    public Student previous() {
        if (index == studentGroup.size()) index--;
        return studentGroup.getStudent(index--);
    }

    @Override
    public int nextIndex() {
        return index++;
    }

    @Override
    public int previousIndex() {
        return index--;
    }

    @Override
    public void remove() {
        studentGroup.getStudentList().remove(index);
    }

    @Override
    public void set(Student student) {
        studentGroup.getStudentList().set(index, student);
    }

    @Override
    public void add(Student student) {
        studentGroup.getStudentList().add(index, student);
    }

}
