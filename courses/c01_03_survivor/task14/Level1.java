import java.util.*;

public class Level1
{
    public static int Unmanned(int L, int N, int [][] track)
      {
        int currentTime = 0;
        int previousPosition = 0;

        for(int i = 0; i < N; i++) {
            int position = track[i][0];
            int redTime = track[i][1];
            int greenTime = track[i][2];

            currentTime += position - previousPosition;

            int cycleLength = redTime + greenTime;
            int timeInCycle = currentTime % cycleLength;

            if (timeInCycle < redTime) {
                currentTime += redTime - timeInCycle;
            }

            previousPosition = position;
        }

        currentTime += L - previousPosition;

        return currentTime;
      }
}

