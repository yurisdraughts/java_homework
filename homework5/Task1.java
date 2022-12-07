import java.util.Arrays;
import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) {
        // создаём телефонную книгу
        HashMap<String, Integer[]> phoneBook = createNewPhonebook();
        pn(phoneBook);

        // добавляем 1-ю запись
        p(addEntryToPhonebook(phoneBook, "Иванов Иван Иванович", new Integer[] { 7_111_11_11, 7_222_22_22 }));
        pn(phoneBook);

        // добавляем 2-ю запись
        p(addEntryToPhonebook(phoneBook, "Иванов Евгений Петрович", new Integer[] { 7_111_22_11, 7_222_11_22 }));
        pn(phoneBook);

        // пробуем добавить запись с тем же ключом, что и 1-я запись
        p(addEntryToPhonebook(phoneBook, "Иванов Иван Иванович", new Integer[] { 7_333_33_33 }));
        pn(phoneBook);

        // пробуем найти человека по существующему номеру телефона
        pn(findPersonByNumber(phoneBook, 7_111_11_11));

        // пробуем найти человека по номеру телефона, которого нет в телефонной книге
        pn(findPersonByNumber(phoneBook, 7_444_44_44));
    }

    static HashMap<String, Integer[]> createNewPhonebook() {
        return new HashMap<String, Integer[]>();
    }

    static boolean addEntryToPhonebook(HashMap<String, Integer[]> phonebook, String name, Integer[] phoneNumbers) {
        // добавляет запись и возвращает true если запись не существует,
        // если запись уже существует - возвращает false
        return phonebook.putIfAbsent(name, phoneNumbers) == null;
    }

    static String findPersonByNumber(HashMap<String, Integer[]> phonebook, Integer phoneNumber) {
        // возвращает имя по номеру телефона, или null, если номера нет в словаре
        // поиск по имени может осуществляться стандартными средствами Java -
        // phonebook.get() - и не требует отдельного метода
        for (HashMap.Entry<String, Integer[]> nameToPhoneNumbers : phonebook.entrySet()) {
            if (Arrays.asList(nameToPhoneNumbers.getValue()).indexOf(phoneNumber) != -1) {
                return nameToPhoneNumbers.getKey();
            }
        }

        return null;
    }

    static <T> void p(T arg) {
        System.out.print(arg);
    }

    static <T> void pn(T arg) {
        System.out.println(arg);
    }
}