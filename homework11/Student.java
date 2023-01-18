public class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        return this.name.compareTo(student.getName());
    }

    @Override
    public String toString() {
        return "Student [name=" + name + "]";
    }

    public String getName() {
        return name;
    }

}
