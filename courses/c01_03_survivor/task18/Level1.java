import java.util.*;

public class Level1
{
    public static boolean MisterRobot(int N, int [] data)
      {
        int [] copyData = new int[N];
        for (int i = 0; i < N; i++) {
            copyData[i] = data[i];
        }

        for (int i = 1; i <= N - 2; i++) {
            int targetIndex = i - 1;
            int currentIndex = targetIndex;

            for (int j = targetIndex; j < N; j++) {
                if (copyData[j] == i) {
                    currentIndex = j;
                    break;
                }
            }

            for (; currentIndex - targetIndex >= 2; currentIndex -= 2) {
                int rotationStartIndex = currentIndex - 2;

                int first = copyData[rotationStartIndex];
                int second = copyData[rotationStartIndex + 1];
                int third = copyData[rotationStartIndex + 2];

                copyData[rotationStartIndex] = third;
                copyData[rotationStartIndex + 1] = first;
                copyData[rotationStartIndex + 2] = second;
            }

            if (currentIndex == targetIndex + 1) {
                int first = copyData[targetIndex];
                int second = copyData[targetIndex + 1];
                int third = copyData[targetIndex + 2];

                copyData[targetIndex] = second;
                copyData[targetIndex + 1] = third;
                copyData[targetIndex + 2] = first;
            }
        }

        if (copyData[N - 2] == N - 1 && copyData[N - 1] == N) {
            return true;
        }

        return false;
      }
}

