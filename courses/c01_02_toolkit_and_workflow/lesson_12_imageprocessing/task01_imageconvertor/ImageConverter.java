package c01_02_toolkit_and_workflow.lesson_12_imageprocessing.task01_imageconvertor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConverter {
    public static void convertImages(String originalExtension, String targetExtension) {
        assert originalExtension != null : "Исходное расширение null";
        assert targetExtension != null : "Целевое расширение null";
        // Получаем текущий каталог
        File currentDirectory = new File(".");
        // Получаем список всех файлов и папок в текущем каталоге
        File[] files = currentDirectory.listFiles();

        // Проходим по всем файлам в каталоге
        for (File file : files) {
            // Нас интересуют только файлы, а не директории
            if (file.isFile()) {
                String fileName = file.getName();
                // Проверяем, заканчивается ли имя файла на нужное расширение.
                if (fileName.endsWith("." + originalExtension)) {
                    try {
                        // Загружаем изображение в буфер
                        BufferedImage image = ImageIO.read(file);

                        // Формируем новое имя файла, заменяя старое расширение на новое
                        int lastPeriodIndex = fileName.lastIndexOf('.'); // Ищем позицию последней точки
                        String nameWithoutExtension = fileName.substring(0, lastPeriodIndex); // Имя файла без расширения
                        String convertedFileName = nameWithoutExtension + "." + targetExtension;

                        // Сохраняем изображение в новом формате
                        ImageIO.write(image, targetExtension, new File(convertedFileName));
                    } catch (IOException e) {
                        System.err.println("Ошибка при обработке файла " + fileName + ": " + e.getMessage());
                    }
                }
            }
        }
    }
}
