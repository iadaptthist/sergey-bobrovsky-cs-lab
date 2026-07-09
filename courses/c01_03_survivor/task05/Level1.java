import java.util.*;

public class Level1
{
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary)
      {
        int [] sortedIds = new int[N];
        int [] sortedSalary = new int[N];

        for (int i = 0; i < N; i++) {
            sortedIds[i] = ids[i];
            sortedSalary[i] = salary[i];
        }

        boolean xchange = true;

        while(xchange) {
            xchange = false;
            for(int i = 0; i < N - 1; i ++) {
                if (sortedIds[i] > sortedIds[i + 1]) {
                    int x = sortedIds[i];
                    sortedIds[i] = sortedIds[i + 1];
                    sortedIds[i + 1] = x;
                    xchange = true;
                }
            }
        }

        xchange = true;

        while(xchange) {
            xchange = false;
            for(int i = 0; i < N - 1; i ++) {
                if (sortedSalary[i] > sortedSalary[i + 1]) {
                    int x = sortedSalary[i];
                    sortedSalary[i] = sortedSalary[i + 1];
                    sortedSalary[i + 1] = x;
                    xchange = true;
                }
            }
        }

        int [] result = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ids[i] == sortedIds[j]) {
                    result[i] = sortedSalary[j];
                    break;
                }
            }
        }

        return result;
      }
}

