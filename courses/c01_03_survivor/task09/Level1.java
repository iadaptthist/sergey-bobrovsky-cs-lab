import java.util.*;

public class Level1
{
    public static String TheRabbitsFoot(String s, boolean encode)
      {
        String textWithoutSpaces = s.replace(" ", "");
        int textLength = textWithoutSpaces.length();

        int rowCount = (int) Math.floor(Math.sqrt(textLength));
        int columnCount = (int) Math.ceil(Math.sqrt(textLength));

        if (rowCount * columnCount < textLength) {
            rowCount++;
        }

        if (encode) {
            StringBuilder encodedText = new StringBuilder();

            for (int column = 0; column < columnCount; column++) {
                if (column > 0) {
                    encodedText.append(' ');
                }

                for (int row = 0; row < rowCount; row++) {
                    int index = row * columnCount + column;

                    if (index < textLength) {
                        encodedText.append(textWithoutSpaces.charAt(index));
                    }
                }
            }

            return encodedText.toString();
        } else {
            char[] decodedCharacters = new char[textLength];

            int index = 0;

            for (int column = 0; column < columnCount; column++) {
                for (int row = 0; row < rowCount; row++) {
                    int originalIndex = row * columnCount + column;

                    if (originalIndex < textLength) {
                        decodedCharacters[originalIndex] = textWithoutSpaces.charAt(index);
                        index++;
                    }
                }
            }

            String decodedText = new String(decodedCharacters);
            return decodedText;
        }
    }
}

