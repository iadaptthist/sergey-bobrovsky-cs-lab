import java.util.*;

public class Level1
{
    public static int ConquestCampaign(int N, int M, int L, int[] battalion)
      {
        int[][] trainingGround = new int[N][M];

        int currentDay = 1;

        for (int i = 0; i < L * 2; i += 2) {
            int row = battalion[i] - 1;
            int col = battalion[i + 1] - 1;

            trainingGround[row][col] = currentDay;
        }

        int totalDays = 1;
        boolean hasCapturedNewCells = true;

        while (hasCapturedNewCells) {
            hasCapturedNewCells = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if (trainingGround[i][j] == currentDay) {

                        if (i + 1 < N && trainingGround[i + 1][j] == 0) {
                            trainingGround[i + 1][j] = currentDay + 1;
                            hasCapturedNewCells = true;
                        }

                        if (i - 1 >= 0 && trainingGround[i - 1][j] == 0) {
                            trainingGround[i - 1][j] = currentDay + 1;
                            hasCapturedNewCells = true;
                        }

                        if (j + 1 < M && trainingGround[i][j + 1] == 0) {
                            trainingGround[i][j + 1] = currentDay + 1;
                            hasCapturedNewCells = true;
                        }

                        if (j - 1 >= 0 && trainingGround[i][j - 1] == 0) {
                            trainingGround[i][j - 1] = currentDay + 1;
                            hasCapturedNewCells = true;
                        }
                    }
                }
            }

            if (hasCapturedNewCells) {
                totalDays++;
                currentDay++;
            }
        }

        return totalDays;
      }
}
