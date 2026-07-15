import java.util.*;

public class Level1
{
    public static int [] UFO(int N, int [] data, boolean octal)
      {
        int numberSystemOfInputData;
        if (octal) {
            numberSystemOfInputData = 8;
        } else {
            numberSystemOfInputData = 16;
        }

        int [] result = new int[N];
        for(int i = 0; i < N; i++) {
            int converted = 0;
            int multiplier = 1;
            for (int j = data[i]; j > 0; j /= 10) {
                converted += (j % 10) * multiplier;
                multiplier *= numberSystemOfInputData;
            }
            result[i] = converted;
        }
        return result;
      }
}

