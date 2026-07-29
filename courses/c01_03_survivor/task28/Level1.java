import java.util.*;

public class Level1
{
    public static String Keymaker(int k)
      {
        boolean[] isDoorOpen = new boolean[k];

        for (int step = 1; step <= k; step++) {
            for (int doorIndex = step - 1; doorIndex < k; doorIndex += step) {
                isDoorOpen[doorIndex] = !isDoorOpen[doorIndex];
            }
        }

        char[] result = new char[k];
        for (int i = 0; i < k; i++) {
            if (isDoorOpen[i]) {
                result[i] = '1';
            }
            if (!isDoorOpen[i]) {
                result[i] = '0';
            }
        }

        return new String(result);
    }
}

