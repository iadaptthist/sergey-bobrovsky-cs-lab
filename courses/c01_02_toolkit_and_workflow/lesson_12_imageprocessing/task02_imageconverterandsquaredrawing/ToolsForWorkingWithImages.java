package c01_02_toolkit_and_workflow.lesson_12_imageprocessing.task02_imageconverterandsquaredrawing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ToolsForWorkingWithImages {
    public static void convertImagesAndDrawingSquare(String originalExtension, String targetExtension) {
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

                        // Вызываем метод, который рисует квадрат с текстом
                        drawSquareWithText(image);

                        // Формируем новое имя файла, заменяя старое расширение на новое
                        int lastPeriodIndex = fileName.lastIndexOf('.'); // Ищем позицию последней точки
                        String nameWithoutExtension = fileName.substring(0, lastPeriodIndex); // Имя файла без расширения
                        String convertedFileName = nameWithoutExtension + "." + targetExtension;

                        // Сохраняем итоговое изображение в новом формате
                        ImageIO.write(image, targetExtension, new File(convertedFileName));
                    } catch (IOException e) {
                        System.err.println("Ошибка при обработке файла " + fileName + ": " + e.getMessage());
                    }
                }
            }
        }
    }

    // Метод для рисования незаполненного квадрата с текстом в центре изображения.
    private static void drawSquareWithText(BufferedImage img) {
        // Получаем холст
        Graphics2D canvas = img.createGraphics();

        // Задаем цвет для рисования
        canvas.setColor(Color.RED);

        // Рисуем незаполненный квадрат в центре изображения
        int squareSize = 200; // Размер стороны квадрата
        int x = (img.getWidth() - squareSize) / 2;
        int y = (img.getHeight() - squareSize) / 2;

        // Рисуем контур квадрата
        canvas.drawRect(x, y, squareSize, squareSize);

        // Строки текста внутри квадрата
        String line1 = "Hello,";
        String line2 = "World!";

        // Получаем параметры шрифта для расчета координат
        FontMetrics fontSettings = canvas.getFontMetrics();
        int lineWidth1 = fontSettings.stringWidth(line1);
        int lineWidth2 = fontSettings.stringWidth(line2);
        int textLineHeight = fontSettings.getHeight();
        int verticalTextOffset = fontSettings.getAscent();

        // Вычисляем координаты X для центрирования каждой строки по горизонтали внутри квадрата
        int textX1 = x + (squareSize - lineWidth1) / 2;
        int textX2 = x + (squareSize - lineWidth2) / 2;

        // Рассчитываем координату Y для линии первой строки, чтобы блок из двух строк был отцентрирован по вертикали внутри квадрата
        int totalTextHeight = textLineHeight * 2;
        int textY1 = y + (squareSize - totalTextHeight) / 2 + verticalTextOffset;
        // Координата Y для второй строки (первая строка + высота строки)
        int textY2 = textY1 + textLineHeight;

        // Выводим текст
        canvas.drawString(line1, textX1, textY1);
        canvas.drawString(line2, textX2, textY2);

        // Завершаем работу с холстом
        canvas.dispose();
    }
}
