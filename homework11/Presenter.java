import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

// Распечатать всех студентов и посещаемость каждого в процентах
// Распечатать студентов, отсортировав их по убыванию посещаемости (вверху самые посещающие)
// Распечатать студентов с посещаемостью ниже 25%

public class Presenter {
    private AttendanceService attendanceService;
    private AttendanceView attendanceView;

    public Presenter(TreeMap<Student, TreeMap<LocalDate, Boolean>> attendanceData) {
        this.attendanceService = new AttendanceService(attendanceData);
        this.attendanceView = new AttendanceView();
    }

    private TreeMap<Student, Integer> getAttendancePercentage() {
        TreeMap<Student, TreeMap<LocalDate, Boolean>> attendance = this.attendanceService.getAttendanceData();
        TreeMap<Student, Integer> result = new TreeMap<>();

        for (Map.Entry<Student, TreeMap<LocalDate, Boolean>> studentAttendance : attendance.entrySet()) {
            Collection<Boolean> records = studentAttendance.getValue().values();
            int attendedClassesNumber = 0;

            for (Boolean record : records) {
                if (record == true) {
                    attendedClassesNumber++;
                }
            }

            Integer percentage = (int) (100 * ((float) attendedClassesNumber / records.size()));

            result.put(studentAttendance.getKey(), percentage);
        }

        return result;
    }

    public void printAttendancePercentages() {
        this.attendanceView.print("Attendance Percentages: ", getAttendancePercentage());
    }

    public void printSortedByAttendance() {
        TreeMap<Student, Integer> attendancePercentage = getAttendancePercentage();
        ArrayList<Integer> sortedPercentages = new ArrayList<>(attendancePercentage.values());
        Collections.sort(sortedPercentages);
        Collections.reverse(sortedPercentages);
        ArrayList<Student> result = new ArrayList<>();

        for (Integer percentage : sortedPercentages) {
            for (Map.Entry<Student, Integer> studentAttendance : attendancePercentage.entrySet()) {
                if (studentAttendance.getValue() == percentage) {
                    result.add(studentAttendance.getKey());
                }
            }
        }

        this.attendanceView.print("Sorted By Attendance: ", result);
    }

    public void printLowAttendance() {
        TreeMap<Student, Integer> attendancePercentage = getAttendancePercentage();
        TreeSet<Student> result = new TreeSet<>();

        for (Map.Entry<Student, Integer> studentAttendance : attendancePercentage.entrySet()) {
            if (studentAttendance.getValue() < 25) {
                result.add(studentAttendance.getKey());
            }
        }

        this.attendanceView.print("Low Attendance: ", result);
    }

    public void addStudent(Student student, TreeMap<LocalDate, Boolean> attendanceData) {
        this.attendanceService.getAttendanceData().put(student, attendanceData);
    }

    public void addRecord(Student student, LocalDate date, Boolean wasPresent) {
        TreeMap<LocalDate, Boolean> attendanceData = this.attendanceService.getAttendanceData().get(student);
        attendanceData.put(date, wasPresent);
    }

    public void addRecord(Student student) {
        addRecord(student, LocalDate.now(), true);
    }
}
