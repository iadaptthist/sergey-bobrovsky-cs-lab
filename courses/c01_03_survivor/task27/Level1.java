import java.util.*;

public class Level1
{
    public static boolean Football(int F[], int N)
      {
        int [] copyF = new int[N];
        for (int i = 0; i < N; i++) {
            copyF[i] = F[i];
        }

        int firstUnsortedIndex = -1;

        for (int i = 0; i < N - 1; i++) {
            if (copyF[i] > copyF[i + 1]) {
                firstUnsortedIndex = i;
                break;
            }
        }

        if (firstUnsortedIndex == -1) {
            return true;
        }

        int lastUnsortedIndex = -1;

        for (int i = N - 1; i > 0; i--) {
            if (copyF[i] < copyF[i - 1]) {
                lastUnsortedIndex = i;
                break;
            }
        }

        int temp = copyF[firstUnsortedIndex];
        copyF[firstUnsortedIndex] = copyF[lastUnsortedIndex];
        copyF[lastUnsortedIndex] = temp;

        boolean isSortedAfterSwap = true;
        for (int i = 0; i < N - 1; i++) {
            if (copyF[i] > copyF[i + 1]) {
                isSortedAfterSwap = false;
                break;
            }
        }

        if (isSortedAfterSwap) {
            return true;
        }

        temp = copyF[firstUnsortedIndex];
        copyF[firstUnsortedIndex] = copyF[lastUnsortedIndex];
        copyF[lastUnsortedIndex] = temp;

        for (int i = 0; i < (lastUnsortedIndex - firstUnsortedIndex + 1) / 2; i++) {
            int t = copyF[firstUnsortedIndex + i];
            copyF[firstUnsortedIndex + i] = copyF[lastUnsortedIndex - i];
            copyF[lastUnsortedIndex - i] = t;
        }

        boolean isSortedAfterReverse = true;
        for (int i = 0; i < N - 1; i++) {
            if (copyF[i] > copyF[i + 1]) {
                isSortedAfterReverse = false;
                break;
            }
        }

        return isSortedAfterReverse;
    }
}

