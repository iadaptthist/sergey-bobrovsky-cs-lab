package c01_02_toolkit_and_workflow.lesson_10_workingwithfilesdirectories.task03_deletedirectory;

import java.io.File;

public class DeleteDirectory {
    public static boolean deleteDirWithFiles(File dir) {
        // Проверяем, существует ли объект и является ли он каталогом
        if (!dir.exists() || !dir.isDirectory()) {
            return false;
        }
        // Получаем список всех элементов внутри каталога
        File[] contents = dir.listFiles();
        if (contents == null) {
            return false;
        }
        // Проверяем наличие подкаталогов
        for (File item : contents) {
            if (item.isDirectory()) {
                // Нашли подкаталог. По условию ничего удалять не надо.
                return false;
            }
        }
        // Удаляем все файлы внутри
        for (File item : contents) {
            if (!item.delete()) {
                // Если не удалось удалить хотя бы один файл, прерываем операцию
                return false;
            }
        }
        // Удаляем сам каталог (к этому моменту он уже пуст)
        return dir.delete();
    }
}
