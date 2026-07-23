import java.util.*;

public class Level1
{
    public static String [] TreeOfLife(int H, int W, int N, String [] tree)
      {
        int[][] branchAge = new int[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                branchAge[i][j] = tree[i].charAt(j) == '+' ? 1 : 0;
            }
        }

        int[] rowOffsets = {0, -1, 1, 0, 0};
        int[] columnOffsets = {0, 0, 0, -1, 1};

        for (int year = 1; year <= N; year++) {
            boolean isDeathYear = year % 2 == 0;
            boolean[][] mustDie = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (branchAge[i][j] > 0) {
                        branchAge[i][j]++;
                    } else if (!isDeathYear) {
                        branchAge[i][j] = 1;
                    }

                    if (isDeathYear && branchAge[i][j] >= 3) {
                        mustDie[i][j] = true;
                    }
                }
            }

            if (!isDeathYear) {
                continue;
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    for (int k = 0; k < 5; k++) {
                        int nextRow = i + rowOffsets[k];
                        int nextColumn = j + columnOffsets[k];

                        if (nextRow >= 0 && nextRow < H && nextColumn >= 0 && nextColumn < W && mustDie[nextRow][nextColumn]) {
                            branchAge[i][j] = 0;
                            break;
                        }
                    }
                }
            }
        }

        String[] result = new String[H];

        for (int i = 0; i < H; i++) {
            StringBuilder row = new StringBuilder(W);

            for (int j = 0; j < W; j++) {
                row.append(branchAge[i][j] > 0 ? '+' : '.');
            }

            result[i] = row.toString();
        }

        return result;
    }
}

