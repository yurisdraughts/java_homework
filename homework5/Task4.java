import java.util.ArrayList;
import java.util.HashSet;

public class Task4 {
    public static void main(String[] args) {
        findSolutions();

        for (int i = 0; i < allSolutions.size(); i++) {
            System.out.printf("%d: ", i + 1);
            System.out.println(allSolutions.get(i));
        }
    }

    static void findSolutions() {
        for (int i = 0; i < 8; i++) {
            findSolutionsForOneSquare(i, generateInitialWhitelist(), new ArrayList<Integer>());
        }
    }

    static void findSolutionsForOneSquare(int position, ArrayList<Integer> whitelist, ArrayList<Integer> solution) {
        ArrayList<Integer> newWhitelist = updateWhitelist(position, whitelist);

        ArrayList<Integer> updatedSolution = new ArrayList<>(solution);
        updatedSolution.add(position);

        if (newWhitelist.size() == 0 && updatedSolution.size() == 8) {
            allSolutions.add(updatedSolution);
        } else {
            for (Integer availablePosition : newWhitelist) {
                findSolutionsForOneSquare(availablePosition, newWhitelist, updatedSolution);
            }
        }
    }

    static ArrayList<Integer> updateWhitelist(int position, ArrayList<Integer> whitelist) {
        HashSet<Integer> newWhitelist = new HashSet<>(whitelist);

        int lineStart = position - position % 8;
        // убираем предыдущие горизонтали
        for (int i = 0; i < lineStart; i++) {
            newWhitelist.remove(i);
        }

        // убираем оставшиеся клетки на той же горизонтали
        for (int i = lineStart; i < lineStart + 8; i++) {
            newWhitelist.remove(i);
        }

        // убираем вертикаль
        int i = position;
        while (i < 64) {
            newWhitelist.remove(i);
            i += 8;
        }

        // убираем диагонали
        i = position;
        while (true) {
            newWhitelist.remove(i);
            if (i % 8 == 0)
                break;
            i += 7;
        }

        i = position;
        while (true) {
            newWhitelist.remove(i);
            if (i % 8 == 7)
                break;
            i += 9;
        }

        ArrayList<Integer> result = new ArrayList<Integer>(newWhitelist);
        result.sort(null);

        return result;
    }

    static ArrayList<Integer> generateInitialWhitelist() {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            set.add(i);
        }
        return set;
    }

    public static ArrayList<ArrayList<Integer>> allSolutions = new ArrayList<>();
}
