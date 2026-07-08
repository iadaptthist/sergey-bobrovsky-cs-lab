import java.util.*;

public class Level1
{
    public static int ConquestCampaign(int N, int M, int L, int [] battalion)
      {
        int[][] trainingGround = new int[N][M];

        int capturedCountCells = 0;
        int totalCells = N * M;

        for (int i = 0; i < L * 2; i += 2) {
            int row = battalion[i] - 1;
            int col = battalion[i + 1] - 1;

            if (trainingGround[row][col] == 0) {
                trainingGround[row][col] = 1;
                capturedCountCells++;
            }
        }

        if (capturedCountCells == totalCells) {
            return 1;
        }

        int day = 1;

        while (capturedCountCells < totalCells) {
            day++;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {

                    if (trainingGround[row][col] > 0 && trainingGround[row][col] < day) {

                        if (row > 0 && trainingGround[row - 1][col] == 0) {
                            trainingGround[row - 1][col] = day;
                            capturedCountCells++;
                        }

                        if (row < N - 1 && trainingGround[row + 1][col] == 0) {
                            trainingGround[row + 1][col] = day;
                            capturedCountCells++;
                        }

                        if (col > 0 && trainingGround[row][col - 1] == 0) {
                            trainingGround[row][col - 1] = day;
                            capturedCountCells++;
                        }

                        if (col < M - 1 && trainingGround[row][col + 1] == 0) {
                            trainingGround[row][col + 1] = day;
                            capturedCountCells++;
                        }

                        if (capturedCountCells == totalCells) {
                            return day;
                        }
                    }
                }
            }
        }

        return day;
      }
}

