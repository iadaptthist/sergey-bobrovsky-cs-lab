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
        if (!startDirectory.isDirectory()) {
            throw new IllegalArgumentException("The specified path is not a directory: " + directoryPath);
        }

        findAllFilesRecursive(startDirectory, foundFiles);

        return foundFiles;
    }

    private static void findAllFilesRecursive(File currentItem, List<File> foundFiles) {
        if (currentItem.isFile()) {
            foundFiles.add(currentItem);
            return;
        }

        File[] directoryItems = currentItem.listFiles();

        if (directoryItems == null) {
            return;
        }

        for (File item : directoryItems) {
            findAllFilesRecursive(item, foundFiles);
        }
    }
}

