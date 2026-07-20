import java.util.*;

public class Level1
{
    public static String BiggerGreater(String input)
      {
        String alphabet = "abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        char[] chars = input.toCharArray();

        int i;

        for (i = chars.length - 2; i >= 0; i--) {
            if (alphabet.indexOf(chars[i]) < alphabet.indexOf(chars[i + 1])) {
                break;
            }
        }

        if (i < 0) {
            return "";
        }

        int j;

        for (j = chars.length - 1; j > i; j--) {
            if (alphabet.indexOf(chars[j]) > alphabet.indexOf(chars[i])) {
                break;
            }
        }

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        for (int left = i + 1, right = chars.length - 1; left < right; left++, right--) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }

        return new String(chars);
    }
}

