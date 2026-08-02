public class Level1
{
    public static long recursiveSumDigits(long n) 
  {
        if (n < 0) {
            n = -n;
        }

        if (n < 10) {
            return n;
        }

        return n % 10 + recursiveSumDigits(n / 10);
    }
}
