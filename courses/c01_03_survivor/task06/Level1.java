import java.util.*;

public class Level1
{
    public static string PatternUnlock(int N, int [] hits)
      {
        int [] x = new int[10];
        int [] y = new int[10];

        x[6] = 0; y[6] = 0;
        x[1] = 1; y[1] = 0;
        x[9] = 2; y[9] = 0;

        x[5] = 0; y[5] = 1;
        x[2] = 1; y[2] = 1;
        x[8] = 2; y[8] = 1;

        x[4] = 0; y[4] = 2;
        x[3] = 1; y[3] = 2;
        x[7] = 2; y[7] = 2;

        int straightLineCount = 0;
        int diagonalLineCount = 0;

        for(int i = 1; i < N; i++) {
            int a = hits[i - 1];
            int b = hits[i];

            int xDifference = x[a] - x[b];
            int yDifference = y[a] - y[b];

            if (xDifference < 0) {
                xDifference = -xDifference;
            }

            if (yDifference < 0) {
                yDifference = -yDifference;
            }

            if (xDifference == 1 && yDifference == 1) {
                diagonalLineCount++;
            } else if (xDifference + yDifference == 1) {
                straightLineCount++;
            }
        }

        double lengthLine = straightLineCount + diagonalLineCount * 1.414213562373095;

        long roundingToFifthDigit = (long)(lengthLine * 100000.0 + 0.5);

        String s = Long.toString(roundingToFifthDigit);
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                result += s.charAt(i);
            }
        }

        return result;
      }
}

