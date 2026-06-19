package c01_02_toolkit_and_workflow.lesson_10_workingwithfilesdirectories.task02_findfilesanddirectories;

import java.io.File;
import java.util.ArrayList;

public class FindFilesAndDirectories {
    public static ArrayList<ArrayList<String>> getFilesAndDirs(String path, String extension, boolean flag) {
        if (path == null || extension == null) {
            throw new IllegalArgumentException("Path и extension не могут быть null.");
        }

        File root = new File(path);
        if (!root.exists()) {
            throw new IllegalArgumentException("Указанный путь не найден.");
        }

        ArrayList<String> files = new ArrayList<>();
        ArrayList<String> dirs = new ArrayList<>();
        ArrayList<File> expand = new ArrayList<>();
        expand.add(root);

        int maxDepth = 0;
        if (flag) {
            maxDepth = 1;
        }

        for (int depth = 0; depth <= maxDepth; depth++) {
            // Копируем текущий уровень для обработки и очищаем список для следующего
            File[] expandCopy = expand.toArray(new File[expand.size()]);
            expand.clear();

            for (File file : expandCopy) {
                if (file.isDirectory()) {
                    File[] items = file.listFiles();
                    if (items != null) {
                        for (File item : items) {
                            if (item.isDirectory()) {
                                dirs.add(item.getName());
                            } else if (item.getName().endsWith(extension)) {
                                files.add(item.getName());
                            }
                            // Добавляем элемент в список для обработки на следующей итерации (если она будет)
                            expand.add(item);
                        }
                    }
                }
            }
        }
        // Формируем итоговый ArrayList из двух ArrayList
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        result.add(files);
        result.add(dirs);

        return result;
    }
}
