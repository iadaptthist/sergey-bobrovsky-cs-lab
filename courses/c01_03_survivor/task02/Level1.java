import java.util.*;

public class Level1
{
    public static int odometer(int [] oksana)
      {
        if (oksana == null || oksana.length < 2) {
            throw new IllegalArgumentException("Array must not be null and must contain at least 2 elements.");
        }

        int totalDistanceKm = 0;
        int prevTimeH = 0;

        for(int i = 0; i < oksana.length; i += 2) {
            int speedKmH = oksana[i];
            int curTimeH = oksana[i + 1];

            if (curTimeH < prevTimeH) {
                throw new IllegalArgumentException("The current time must be later than the previous time.");
            }

            totalDistanceKm += speedKmH * (curTimeH - prevTimeH);
            prevTimeH = curTimeH;
        }
        return totalDistanceKm;
      }
}
