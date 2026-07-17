import java.util.*;

public class Level1
{
    public static boolean LineAnalysis(String line)
      {
        if (line == null || line.isEmpty()) {
        return false;
        }

        if (line.charAt(0) != '*' || line.charAt(line.length() - 1) != '*') {
            return false;
        }

        int patternLength = -1;
        int currentLength = 0;

        for (int i = 1; i < line.length(); i++) {
            char symbol = line.charAt(i);

            if (symbol == '.') {
                currentLength++;
            } else if (symbol == '*' && patternLength == -1) {
                patternLength = currentLength;
                currentLength = 0;
            } else if (symbol == '*' && currentLength == patternLength) {
                currentLength = 0;
            } else {
                return false;
            }
        }

        return true;
      }
}

