import java.util.*;

public class Level1
{
    public static boolean TransformTransform(int A[], int N)
      {
        long lengthBLong = (long) N * (N + 1) / 2;

        if (lengthBLong > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Transformed array is too large.");
        }

        int lengthB = (int) lengthBLong;
        int[] B = new int[lengthB];
        int index = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                int endIndex = i + j;
                int max = A[j];

                for (int k = j + 1; k <= endIndex; k++) {
                    if (A[k] > max) {
                        max = A[k];
                    }
                }
                B[index] = max;
                index++;
            }
        }

        long sum = 0L;

        for (int i = 0; i < lengthB; i++) {
            for (int j = 0; j < lengthB - i; j++) {
                int endIndex = i + j;
                int max = B[j];

                for (int k = j + 1; k <= endIndex; k++) {
                    if (B[k] > max) {
                        max = B[k];
                    }
                }
                sum += max;
            }
        }

        return sum % 2 == 0;
    }
}


