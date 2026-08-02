public class Level1 
{
    public static boolean isStringPalindrome(String s) 
  {
        if (s.length() <= 1) {
            return true;
        }

        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        char[] remainingChars = new char[s.length() - 2];
        for (int i = 1; i < s.length() - 1; i++) {
            remainingChars[i - 1] = s.charAt(i);
        }

        return isStringPalindrome(new String(remainingChars));
    }
}

