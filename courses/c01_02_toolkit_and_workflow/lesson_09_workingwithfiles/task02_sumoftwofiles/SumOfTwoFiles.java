package c01_02_toolkit_and_workflow.lesson_09_workingwithfiles.task02_sumoftwofiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class SumOfTwoFiles {
    private static final int MIN_FILE_NUM = 1;
    private static final int MAX_FILE_NUM = 10;
    // Возвращает сумму чисел из двух файлов
    public static String sumOfTwoFiles(int num1, int num2, String folderPath) {
        assert num1 >= MIN_FILE_NUM && num1 <= MAX_FILE_NUM : "Первый файл должен иметь имя-число от " + MIN_FILE_NUM + " до " + MAX_FILE_NUM;
        assert num2 >= MIN_FILE_NUM && num2 <= MAX_FILE_NUM : "Второй файл должен иметь имя-число от " + MIN_FILE_NUM + " до " + MAX_FILE_NUM;
        assert folderPath != null : "Путь к папке не может быть пустым";

        try {
            String path1 = folderPath + "/" + num1 + ".txt";
            String path2 = folderPath + "/" + num2 + ".txt";

            // Считаем сумму чисел из файлов
            int sum1 = readSumFromFile(path1);
            int sum2 = readSumFromFile(path2);

            return "Сумма шести чисел: " + (sum1 + sum2);
        } catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    // Метод читает файл и суммирует три числа
    private static int readSumFromFile(String filePath) throws Exception {
        assert filePath != null : "Путь к файлу не может быть пустым";

        File myFil = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(myFil));

        int sum = 0;
        int count = 0;

        String st;
        while ((st = br.readLine()) != null) {
            if (st.length() > 0) {
                String[] parts = st.split("\\s+");

                for (int i = 0; i < parts.length; i++) {
                    try {
                        sum += Integer.valueOf(parts[i]);
                        count++;
                    } catch (NumberFormatException e) {
                        br.close();
                        throw new Exception("В файле " + myFil.getName() + ": элемент " + parts[i] + " не является числом.");
                    }
                }
            }
        }
        br.close();

        if (count != 3) {
            throw new Exception("Некорректное содержимое файла " + myFil.getName() + ": ожидалось 3 числа, но найдено " + count + ".");
        }
        assert sum >= 0 : "Сумма не может быть отрицательной";
        return sum;
    }

    public static void main(String[] args) {
        String folderPath = "C:/Users/Lenovo/projects/sergey-bobrovsky-cs-lab/courses/c01_02_toolkit_and_workflow/lesson_09_workingwithfiles/task01_createfiles";

        Random random = new Random();
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;

        System.out.println("Выпавшие случайные числа: " + num1 + " и " + num2);
        System.out.println("Открываем файлы: " + num1 + ".txt и " + num2 + ".txt");

        String result = sumOfTwoFiles(num1, num2, folderPath);
        System.out.println(result);
    }
}
