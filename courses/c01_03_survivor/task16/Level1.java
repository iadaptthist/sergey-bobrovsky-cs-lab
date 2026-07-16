import java.util.*;

public class Level1
{
    public static int MaximumDiscount(int N, int [] price)
      {
        int [] copyPrice = new int[N];
        for (int i = 0; i < N; i++) {
            copyPrice[i] = price[i];
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (copyPrice[j] < copyPrice[j + 1]) {
                    int temp = copyPrice[j];
                    copyPrice[j] = copyPrice[j + 1];
                    copyPrice[j + 1] = temp;
                }
            }
        }

        int totalDiscount = 0;

        for (int i = 2; i < N; i += 3) {
            totalDiscount += copyPrice[i];
        }

        return totalDiscount;
      }
}

