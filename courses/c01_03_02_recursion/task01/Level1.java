import java.util.*;

public class Level1
{
    public static double recursiveRaiseToPower(int N, int M) 
  {
        if (N == 0 && M < 0) {
            throw new ArithmeticException("Zero cannot be raised to a negative power");
        }

        if (M == 0) {
            return 1.0;
        }
        if (M < 0) {
            return 1.0 / recursiveRaiseToPower(N, -M);
        }
        return N * recursiveRaiseToPower(N, M - 1);
    }
}

