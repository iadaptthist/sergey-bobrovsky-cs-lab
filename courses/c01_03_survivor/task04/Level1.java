import java.util.*;

public class Level1
{
    public static int [] MadMax(int N, int [] Tele)
      {
        if (Tele == null || Tele.length != N || N < 1 || N > 127 || N % 2 == 0) {
        throw new IllegalArgumentException("Invalid input");
        }

        int [] result = new int[N];
        for(int i = 0; i < N; i++) {
            result[i] = Tele[i];
        }

        boolean xchange = true;

        while(xchange) {
            xchange = false; // we assume that the array is already sorted

            for(int i = 0; i < N - 1; i ++) {
                if(result[i] > result[i + 1]) {
                    // if we find elements that are not in ascending order, we swap them
                    int x = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = x;
                    xchange = true;
                }
            }
        }

        int startIndex = N / 2;
        int endIndex = N - 1;

        while (startIndex < endIndex) {
            int x = result[startIndex];
            result[startIndex] = result[endIndex];
            result[endIndex] = x;
            startIndex++;
            endIndex--;
        }

        return result;
      }
}

