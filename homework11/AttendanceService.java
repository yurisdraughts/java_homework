import java.util.TreeMap;
import java.time.LocalDate;

// хранится информация обо всех студентах
// список дат занятий и для каждой даты — посетил студент занятие или нет

public class AttendanceService {
    private TreeMap<Student, TreeMap<LocalDate, Boolean>> attendanceData;

    public AttendanceService(TreeMap<Student, TreeMap<LocalDate, Boolean>> attendanceData) {
        this.attendanceData = attendanceData;
    }

    public TreeMap<Student, TreeMap<LocalDate, Boolean>> getAttendanceData() {
        return attendanceData;
    }
}