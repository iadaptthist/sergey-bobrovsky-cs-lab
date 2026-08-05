import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Level1 {
    public static List<File> findAllFiles(String directoryPath) {
        ArrayList<File> foundFiles = new ArrayList<>();
        File startDirectory = new File(directoryPath);

        if (!startDirectory.exists()) {
            throw new IllegalArgumentException("Directory does not exist: " + directoryPath);
        }

        if (startDirectory.isFile()) {
            foundFiles.add(startDirectory);
            return foundFiles;
        }

        File[] directoryItems = startDirectory.listFiles();

        if (directoryItems == null) {
            return foundFiles;
        }

        for (File item : directoryItems) {
            if (item.isFile()) {
                foundFiles.add(item);
            } else if (item.isDirectory()) {
                foundFiles.addAll(findAllFiles(item.getPath()));
            }
        }

        return foundFiles;
    }
}

