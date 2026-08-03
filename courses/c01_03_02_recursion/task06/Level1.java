import java.util.List;

public class Level1 {
    public static void printEvenIndicesRecursive(List<Integer> list) {
        printEvenIndicesRecursive(list, 0);
    }

    private static void printEvenIndicesRecursive(List<Integer> list, int index) {
        if (index >= list.size()) {
            return;
        }

        System.out.println(list.get(index));

        printEvenIndicesRecursive(list, index + 2);
    }
}

