package c01_02_toolkit_and_workflow.lesson_11_workingwitharchives;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipManager {
    // Объявляем метод для добавления файлов в архив
    public static void addFilesToZip(String archiveName, String[] filesToAdd) throws IOException {
        // Проверяем, что путь к архиву не равен null
        if (archiveName == null) {
            // Выбрасываем исключение с понятным сообщением
            throw new IllegalArgumentException("Путь к архиву не может быть null");
        }
        // Проверяем, что массив файлов не равен null
        if (filesToAdd == null || filesToAdd.length == 0) {
            // Выбрасываем исключение с понятным сообщением
            throw new IllegalArgumentException("Массив файлов не может быть null или пустым");
        }

        // Создаем объект File для исходного архива
        File originalZip = new File(archiveName);

        // Проверяем, что архив существует
        if (!originalZip.exists()) {
            // Выбрасываем исключение, если архив не найден
            throw new IllegalArgumentException("Архив не найден: " + archiveName);
        }
        // Создаем объект File для временного архива
        File tempZip = new File(archiveName + ".tmp");
        // Создаем поток для чтения данных из исходного архива
        ZipInputStream originalZipInputStream = new ZipInputStream(new FileInputStream(originalZip));
        // Создаем поток для записи данных во временный архив
        ZipOutputStream tempZipOutputStream = new ZipOutputStream(new FileOutputStream(tempZip));
        // Получаем первую запись из исходного архива
        ZipEntry zipEntry = originalZipInputStream.getNextEntry();

        // Цикл по всем элементам исходного архива
        while (zipEntry != null) {
            // Добавляем запись во временный архив
            tempZipOutputStream.putNextEntry(new ZipEntry(zipEntry.getName()));

            // Проверяем, что текущая запись не является директорией
            if (!zipEntry.isDirectory()) {
                // Копируем содержимое файла из исходного архива во временный
                copyData(originalZipInputStream, tempZipOutputStream);
            }

            // Завершаем запись текущей записи
            tempZipOutputStream.closeEntry();

            // Переходим к следующей записи
            zipEntry = originalZipInputStream.getNextEntry();
        }

        // Закрываем поток чтения исходного архива
        originalZipInputStream.close();

        // Циклом обрабатываем каждый файл из массива filesToAdd
        for (String filePath : filesToAdd) {
            // Проверяем, что путь к файлу не равен null
            if (filePath == null) {
                // Выводим предупреждение и пропускаем этот файл
                System.out.println("Внимание: путь к файлу равен null");
                continue;
            }

            // Создаём объект File для добавляемого файла
            File fileToAdd = new File(filePath);

            // Проверяем, что файл существует и что это файл, а не директория
            if (!fileToAdd.exists() || !fileToAdd.isFile()) {
                // Выводим предупреждение и пропускаем этот файл
                System.out.println("Внимание: файл не найден или является директорией: " + filePath);
                continue;
            }

            // Создаем запись о файле в архиве
            tempZipOutputStream.putNextEntry(new ZipEntry(fileToAdd.getName()));

            // Копируем содержимое файла в архив
            FileInputStream fileInputStream = new FileInputStream(fileToAdd);
            copyData(fileInputStream, tempZipOutputStream);
            fileInputStream.close();

            // Завершаем запись текущей записи
            tempZipOutputStream.closeEntry();

            // Выводим сообщение об успешном добавлении файла
            System.out.println("Файл добавлен в архив: " + fileToAdd.getName());
        }

        // Закрываем поток записи временного архива
        tempZipOutputStream.close();

        // Удаляем исходный архив
        if (!originalZip.delete()) {
            // Выбрасываем исключение, если не удалось удалить исходный архив
            throw new IOException("Не удалось удалить исходный архив: " + archiveName);
        }
        // Переименовываем временный архив на место исходного
        if (!tempZip.renameTo(originalZip)) {
            // Выбрасываем исключение, если не удалось переименовать
            throw new IOException("Не удалось переименовать временный архив");
        }
        // Выводим сообщение об успешном завершении операции
        System.out.println("Файлы успешно добавлены в архив: " + archiveName);
    }

    // Метод для копирования данных из одного потока в другой.
    private static void copyData(InputStream inputStream, OutputStream outputStream) throws IOException {
        // Создаем буфер
        byte[] buffer = new byte[1024];
        // Переменная для хранения количества прочитанных байт
        int length;
        // Циклом читаем данные из inputStream в буфер
        while ((length = inputStream.read(buffer)) > 0) {
            // Записываем прочитанные данные в outputStream
            outputStream.write(buffer, 0, length);
        }
    }
}
