import java.util.*;

public class Level1
{
    public static boolean white_walkers(String village)
      {
        boolean hasValidPair = false;
        int previousDigit = -1;
        int equalsCount = 0;

        for (int i = 0; i < village.length(); i++) {
            char currentChar = village.charAt(i);

            if (currentChar == '=') {
                equalsCount++;
                continue;
            }

            if (currentChar < '0' || currentChar > '9') {
                continue;
            }

            int currentDigit = currentChar - '0';

            boolean digitsSumToTen = (previousDigit != -1 && previousDigit + currentDigit == 10);

            if (digitsSumToTen && equalsCount != 3) {
                return false;
            }

            if (digitsSumToTen) {
                hasValidPair = true;
            }

            previousDigit = currentDigit;
            equalsCount = 0;
        }

        return hasValidPair;
    }
}

