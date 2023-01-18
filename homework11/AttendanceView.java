// позволяет отображать студентов и их посещаемость

public class AttendanceView {
    public <T> void print(String name, T data) {
        System.out.printf(name);
        System.out.println(data);
    }
}
