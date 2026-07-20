import java.util.*;

public class Level1
{
    static java.util.ArrayList<String> history = new java.util.ArrayList<>();
    static int currentIndex = 0;

    public static String BastShoe(String command) {

        if (history.isEmpty()) {
            history.add("");
            currentIndex = 0;
        }

        String currentText = history.get(currentIndex);

        if (command == null || command.length() == 0) {
            return currentText;
        }

        char operationCode = command.charAt(0);

        switch (operationCode) {

            case '1': {
                if (command.length() < 2 || command.charAt(1) != ' ') {
                    return currentText;
                }

                String textToAppend = command.substring(2);

                if (currentIndex < history.size() - 1) {
                    history.clear();
                    history.add(currentText);
                    currentIndex = 0;
                }

                currentText = currentText + textToAppend;
                history.add(currentText);
                currentIndex++;

                return currentText;
            }

            case '2': {
                if (command.length() < 2 || command.charAt(1) != ' ') {
                    return currentText;
                }

                int count;

                try {
                    count = Integer.parseInt(command.substring(2).trim());
                } catch (Exception e) {
                    return currentText;
                }

                if (count < 0) {
                    return currentText;
                }

                if (currentIndex < history.size() - 1) {
                    history.clear();
                    history.add(currentText);
                    currentIndex = 0;
                }

                if (count >= currentText.length()) {
                    currentText = "";
                } else {
                    currentText = currentText.substring(0, currentText.length() - count);
                }

                history.add(currentText);
                currentIndex++;

                return currentText;
            }

            case '3': {
                if (command.length() < 2 || command.charAt(1) != ' ') {
                    return currentText;
                }

                int index;

                try {
                    index = Integer.parseInt(command.substring(2).trim());
                } catch (Exception e) {
                    return currentText;
                }

                if (index < 0 || index >= currentText.length()) {
                    return "";
                }

                return String.valueOf(currentText.charAt(index));
            }

            case '4': {
                if (command.trim().length() != 1) {
                    return currentText;
                }

                if (currentIndex > 0) {
                    currentIndex--;
                }

                return history.get(currentIndex);
            }

            case '5': {
                if (command.trim().length() != 1) {
                    return currentText;
                }

                if (currentIndex < history.size() - 1) {
                    currentIndex++;
                }

                return history.get(currentIndex);
            }

            default:
                return currentText;
        }
    }
}

