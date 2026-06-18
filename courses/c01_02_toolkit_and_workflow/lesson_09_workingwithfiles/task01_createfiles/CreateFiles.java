package c01_02_toolkit_and_workflow.lesson_09_workingwithfiles.task01_createfiles;

import java.io.*;
import java.util.Random;

public class CreateFiles {
    public static void main(String[] args) {
        int numberOfFiles = 10;
        int numbersPerFile = 3;

        Random random = new Random();

        String directoryPath = "C:/Users/Lenovo/projects/sergey-bobrovsky-cs-lab/courses/c01_02_toolkit_and_workflow/lesson_09_workingwithfiles/task01_createfiles";

        // Цикл для создания 10 файлов
        for (int i = 1; i <= numberOfFiles; i++) {
            String fileName = i + ".txt";
            File myfil = new File(directoryPath, fileName);
            assert i >= 1 && i <= numberOfFiles : "Номер файла должен быть от 1 до " + numberOfFiles;

            try {
                // Открываем файл на запись.
                BufferedWriter bw = new BufferedWriter(new FileWriter(myfil));

                // Записываем 3 случайных числа
                for (int j = 0; j < numbersPerFile; j++) {
                    int randomNumber = random.nextInt(100); // случайное число от 0 до 99

                    bw.write(String.valueOf(randomNumber));
                    bw.newLine();
                }

                // Закрываем файл
                bw.close();

                System.out.println("Файл " + fileName + " успешно создан и заполнен.");

            } catch (IOException e) {
                // Обработка возможной ошибки
                System.out.println("Ошибка при работе с файлом " + fileName + ": " + e.getMessage());
            }
        }
    }
}
