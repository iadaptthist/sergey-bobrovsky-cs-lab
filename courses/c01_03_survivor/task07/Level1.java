import java.util.*;

public class Level1
{
    public static int [] WordSearch(int len, String s, String subs)
      {
        java.util.ArrayList<String> lines = new java.util.ArrayList<>();
        String [] inputWords = s.split(" ");
        String currentLine = "";

        for(String word : inputWords) {
            if (word.length() > len) {
                if (!currentLine.isEmpty()) {
                    lines.add(currentLine);
                    currentLine = "";
                }

                while (word.length() > len) {
                    lines.add(word.substring(0, len));
                    word = word.substring(len);
                }
                currentLine = word;

            } else {
                if (currentLine.isEmpty()) {
                    currentLine = word;
                } else if (currentLine.length() + 1 + word.length() <= len) {
                    currentLine = currentLine + " " + word;
                } else {
                    lines.add(currentLine);
                    currentLine = word;
                }
            }
        }

        if (!currentLine.isEmpty()) {
            lines.add(currentLine);
        }

        int [] result = new int[lines.size()];
        for(int i = 0; i < lines.size(); i++) {
            if ((" " + lines.get(i) + " ").contains(" " + subs + " ")) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
      }
}

