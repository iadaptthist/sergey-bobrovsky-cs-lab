import java.util.*;

public class Level1
{
    public static int SumOfThe(int N, int [] data)
      {
        int sum = 0;

        for(int i = 0; i < N; i++) {
            sum += data[i];
        }

        for(int i = 0; i < N; i++) {
            if (data[i] == sum - data[i]) {
                return data[i];
            }
        }
        throw new IllegalArgumentException("No number equals sum of the rest numbers.");
      }
}

