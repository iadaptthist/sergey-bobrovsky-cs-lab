import java.util.ArrayList;

public class Level1 {
    public static int findSecondMax(ArrayList<Integer> numbers) {
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("List must contain at least two elements");
        }

        int firstMax = numbers.get(0);
        int secondMax = numbers.get(1);

        if (secondMax > firstMax) {
            int temp = firstMax;
            firstMax = secondMax;
            secondMax = temp;
        }

        return findSecondMaxRecursive(numbers, 2, firstMax, secondMax);
    }

    private static int findSecondMaxRecursive(ArrayList<Integer> numbers, int index, int firstMax, int secondMax) {
        if (index == numbers.size()) {
            return secondMax;
        }

        int current = numbers.get(index);

        if (current >= firstMax) {
            secondMax = firstMax;
            firstMax = current;
        } else if (current > secondMax) {
            secondMax = current;
        }

        return findSecondMaxRecursive(numbers, index + 1, firstMax, secondMax);
    }
}

