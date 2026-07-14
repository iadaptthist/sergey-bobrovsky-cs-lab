import java.util.*;

public class Level1
{
    public static String BigMinus(String s1, String s2)
    {
        if (s1.equals(s2)) {
            return "0";
        }

        boolean isFirstNumberSmaller = false;
        if (s1.length() < s2.length()) {
            isFirstNumberSmaller = true;
        } else if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) < s2.charAt(i)) {
                    isFirstNumberSmaller = true;
                    break;
                } else if (s1.charAt(i) > s2.charAt(i)) {
                    break;
                }
            }
        }

        if (isFirstNumberSmaller) {
            String originalS1 = s1;
            s1 = s2;
            s2 = originalS1;
        }

        char[] digits = new char[s1.length()];

        int indexS1 = s1.length() - 1;
        int indexS2 = s2.length() - 1;

        int borrow = 0;

        while (indexS1 >= 0) {
            int digit1 = s1.charAt(indexS1) - '0' - borrow;
            int digit2 = 0;

            if (indexS2 >= 0) {
                digit2 = s2.charAt(indexS2) - '0';
                indexS2--;
            }

            borrow = 0;

            if (digit1 < digit2) {
                digit1 += 10;
                borrow = 1;
            }

            digits[indexS1] = (char) ('0' + digit1 - digit2);

            indexS1--;
        }

        int firstNonZeroNumberIndex = 0;
        while (firstNonZeroNumberIndex < digits.length - 1 && digits[firstNonZeroNumberIndex] == '0') {
            firstNonZeroNumberIndex++;
        }

        StringBuilder result = new StringBuilder();

        for (int index = firstNonZeroNumberIndex; index < digits.length; index++) {
            result.append(digits[index]);
        }

        return result.toString();
      }
}

