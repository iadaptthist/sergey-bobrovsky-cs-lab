import java.util.*;

public class Level1
{
    public static int squirrel(int N)
    {
        BigInteger result = BigInteger.valueOf(1);
        for(int i = 2; i <= N; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        // convert the result to a string and return its first character as an integer  
        String resultString = result.toString();
        return Integer.parseInt(String.valueOf(resultString.charAt(0)));
    }
}
