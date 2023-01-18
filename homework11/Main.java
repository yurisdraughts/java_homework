import java.time.LocalDate;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Presenter pr = new Presenter();

        LocalDate ld1 = LocalDate.of(2023, 1, 15);
        LocalDate ld2 = LocalDate.of(2023, 1, 16);
        LocalDate ld3 = LocalDate.of(2023, 1, 17);

        Student st1 = new Student("Андрей"); // 0 из 4 занятий
        pr.addStudent(st1, new TreeMap<LocalDate, Boolean>());
        pr.addRecord(st1, ld1, false);
        pr.addRecord(st1, ld2, false);
        pr.addRecord(st1, ld3, false);
        pr.addRecord(st1, LocalDate.now(), false);

        Student st2 = new Student("Елена"); // 1 из 4 занятий
        pr.addStudent(st2, new TreeMap<LocalDate, Boolean>());
        pr.addRecord(st2, ld1, false);
        pr.addRecord(st2, ld2, false);
        pr.addRecord(st2, ld3, false);
        pr.addRecord(st2);

        Student st3 = new Student("Илья"); // 4 из 4 занятий
        pr.addStudent(st3, new TreeMap<LocalDate, Boolean>());
        pr.addRecord(st3, ld1, true);
        pr.addRecord(st3, ld2, true);
        pr.addRecord(st3, ld3, true);
        pr.addRecord(st3);

        Student st4 = new Student("Ольга"); // 2 из 4 занятий
        pr.addStudent(st4, new TreeMap<LocalDate, Boolean>());
        pr.addRecord(st4, ld1, false);
        pr.addRecord(st4, ld2, false);
        pr.addRecord(st4, ld3, true);
        pr.addRecord(st4);

        pr.printAttendancePercentages();
        pr.printLowAttendance();
        pr.printSortedByAttendance();
    }
}
