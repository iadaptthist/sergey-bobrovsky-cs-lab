import java.util.List;

public class Level1 {
    public static void printEvenNumbersRecursive(List<Integer> list) {
        printEvenNumbersRecursive(list, 0);
    }

    private static void printEvenNumbersRecursive(List<Integer> list, int index) {
        if (index >= list.size()) {
            return;
        }

        if (list.get(index) % 2 == 0) {
            System.out.println(list.get(index));
        }

        printEvenNumbersRecursive(list, index + 1);
    }
}

