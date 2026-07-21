import java.util.*;

public class Level1
{
    public static boolean SherlockValidString(String s)
      {
        if (s == null || s.length() < 2) {
            return false;
        }

        int[] letterCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letterCounts[s.charAt(i) - 'a']++;
        }

        int[] frequencyCounts = new int[s.length() + 1];

        for (int i = 0; i < 26; i++) {
            if (letterCounts[i] > 0) {
                frequencyCounts[letterCounts[i]]++;
            }
        }

        int firstFrequency = 0;
        int secondFrequency = 0;

        for (int i = 1; i < frequencyCounts.length; i++) {
            if (frequencyCounts[i] > 0 && firstFrequency == 0) {
                firstFrequency = i;
            } else if (frequencyCounts[i] > 0 && secondFrequency == 0) {
                secondFrequency = i;
            } else if (frequencyCounts[i] > 0) {
                return false;
            }
        }

        if (secondFrequency == 0) {
            return true;
        }

        int firstFrequencyCount = frequencyCounts[firstFrequency];
        int secondFrequencyCount = frequencyCounts[secondFrequency];

        if (firstFrequency == 1 && firstFrequencyCount == 1) {
            return true;
        }

        if (secondFrequency - firstFrequency == 1 && secondFrequencyCount == 1) {
            return true;
        }

        return false;
    }
}

