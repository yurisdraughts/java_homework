import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        IsGood<Integer> isEven = new IsEven();
        System.out.print("Is 12 even? ");
        System.out.println(isEven.isGood(12));
        System.out.print("Is 23 even? ");
        System.out.println(isEven.isGood(23));
        System.out.println();

        IsGood<Integer> isPositive = new IsPositive();
        System.out.print("Is 2 positive? ");
        System.out.println(isPositive.isGood(2));
        System.out.print("Is -4 even? ");
        System.out.println(isPositive.isGood(-4));
        System.out.println();

        IsGood<String> beginsWithA = new BeginsWithA();
        System.out.print("Does Aardwark begin with A? ");
        System.out.println(beginsWithA.isGood("Aardvark"));
        System.out.print("Does Stockholm begin with A? ");
        System.out.println(beginsWithA.isGood("Stockholm"));
        System.out.println();
        
        IsGood<String> beginsWithTh = new BeginsWith("Th");
        System.out.print("Does Thessaloniki begin with Th? ");
        System.out.println(beginsWithTh.isGood("Thessaloniki"));
        System.out.print("Does Crete begin with Th? ");
        System.out.println(beginsWithTh.isGood("Crete"));
        System.out.println();
        
        List<String> listOfStrings = Arrays.asList("Aarau", "Brno", "Cottbus", "Cleveland");
        System.out.println(listOfStrings);
        IsGood<String> beginsWithC = new BeginsWith("C");
        List<String> newListOfStrings = (List<String>) filter(listOfStrings, beginsWithC);
        System.out.println(newListOfStrings);
        System.out.println();

        List<Integer> listOfIntegers = Arrays.asList(12, 23, -8, -15);
        System.out.println(listOfIntegers);
        List<Integer> listOfEvenIntegers = filter(listOfIntegers, isEven);
        System.out.print("Which ones are even?");
        System.out.println(listOfEvenIntegers);
        List<Integer> listOfPositiveIntegers = filter(listOfIntegers, isPositive);
        System.out.print("Which ones are positive?");
        System.out.println(listOfPositiveIntegers);
    }

    public static <T> List<T> filter(List<T> collection, IsGood<T> isGood) {
        List<T> result = new ArrayList<>();
        for (T element : collection) {
            if (isGood.isGood(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
