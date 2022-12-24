import java.util.Arrays;

public class Tasks {
    public static void main(String[] args) {
        StudentGroup studentGroup = new StudentGroup(Arrays.asList(
                new Student("Yuri", 18, 4, 1993, 4.5f),
                new Student("Elena", 18, 4, 1991, 4.7f),
                new Student("Mikhail", 4, 12, 1994, 3.6f),
                new Student("Arkady", 23, 8, 1992, 4.1f)));

        // task1(studentGroup);
        task2(studentGroup);
        // task3(studentGroup);
    }

    public static void task1(StudentGroup studentGroup) {
        System.out.println("TASK 1");

        StudentGroupIterator studentIter = new StudentGroupIterator(studentGroup);
        while (studentIter.hasNext()) {
            System.out.println(studentIter.next());
        }
        System.out.println();

        for (Student student : studentGroup) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void task2(StudentGroup studentGroup) {
        System.out.println("TASK 2");

        GroupListIterator groupListIterator = new GroupListIterator(studentGroup);

        while (groupListIterator.hasNext()) {
            System.out.println(groupListIterator.next());
        }
        System.out.println();

        while (groupListIterator.hasPrevious()) {
            System.out.println(groupListIterator.previous());
        }
        System.out.println();
    }

    public static void task3(StudentGroup studentGroup) {
        System.out.println("TASK 3");

        ReverseIterator reverseStudentIter = new ReverseIterator(studentGroup);

        while (reverseStudentIter.hasNext()) {
            System.out.println(reverseStudentIter.next());
        }
        System.out.println();
    }
}