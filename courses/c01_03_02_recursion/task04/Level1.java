public class Level1 {
    public static boolean isPalindromeString(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private static boolean isPalindrome(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return true;
        }

        if (s.charAt(startIndex) != s.charAt(endIndex)) {
            return false;
        }

        return isPalindrome(s, startIndex + 1, endIndex - 1);
    }
}

