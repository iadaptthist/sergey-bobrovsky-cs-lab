import java.util.*;

public class Level1
{
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2)
      {
        if (H2 > H1 || W2 > W1) {
            return false;
        }

        String[] map = S1.trim().split("\\s+");
        String[] tanks = S2.trim().split("\\s+");

        for (int i = 0; i <= H1 - H2; i++) {
            for (int j = 0; j <= W1 - W2; j++) {
                boolean found = true;

                for (int k = 0; k < H2; k++) {
                    for (int m = 0; m < W2; m++) {
                        if (map[i + k].charAt(j + m) != tanks[k].charAt(m)) {
                            found = false;
                            break;
                        }
                    }

                    if (!found) {
                        break;
                    }
                }

                if (found) {
                    return true;
                }
            }
        }

        return false;
      }
}

