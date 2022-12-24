import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private LocalDate dateOfBirth;
    private float averageScore;

    public Student(String name, int dayOfMonth, int month, int year, float averageScore) {
        this.name = name;
        this.dateOfBirth = LocalDate.of(year, month, dayOfMonth);
        this.averageScore = averageScore;
    }

    public String getName() {
        String nameCopy = new String(name);
        return nameCopy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        LocalDate dateOfBirthCopy = LocalDate.from(dateOfBirth);
        return dateOfBirthCopy;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Student [name=" + name +
                ", dateOfBirth=" + dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", averageScore=" + averageScore + "]";
    }
}
