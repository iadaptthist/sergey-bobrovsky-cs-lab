package c01_02_toolkit_and_workflow.lesson_09_workingwithfiles.task03_workingwithfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WorkingWithFile {
    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();
        BufferedReader br = null;

        try {
            File myFil = new File("C:/Users/Lenovo/projects/sergey-bobrovsky-cs-lab/courses/c01_02_toolkit_and_workflow/lesson_09_workingwithfiles/task03_workingwithfile/cats.txt");

            br = new BufferedReader(new FileReader(myFil));
            String line = br.readLine();
            int lineNumber = 1;
            while (line != null) {
                try {
                    String[] parts = line.split("\\s+");

                    if (parts.length != 3) {
                        throw new Exception("Ожидается 3 поля (имя, масса, частота), получено " + parts.length);
                    }

                    String name = parts[0];
                    double weight = Double.valueOf(parts[1]);
                    int purrFrequency = Integer.valueOf(parts[2]);

                    Cat cat = new Cat(name, weight, purrFrequency);
                    cats.add(cat);
                    System.out.println("Строка " + lineNumber + " обработана успешно");

                } catch (NumberFormatException e) {
                    System.out.println("Ошибка в строке " + lineNumber + ": некорректные числовые значения");
                } catch (Exception e) {
                    System.out.println("Ошибка в строке " + lineNumber + ": " + e.getMessage());
                }
                line = br.readLine();
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии файла");
                }
            }
        }

        System.out.println("Cписок котов:");
        for (int i = 0; i < cats.size(); i++) {
            Cat currentCat = cats.get(i);
            currentCat.printInfo();
        }
    }
}
