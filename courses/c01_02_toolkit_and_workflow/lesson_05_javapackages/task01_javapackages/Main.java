package c01_02_toolkit_and_workflow.lesson_05_javapackages.task01_javapackages;

import c01_02_toolkit_and_workflow.lesson_05_javapackages.task01_javapackages.calculator.AreaCalculator;
import c01_02_toolkit_and_workflow.lesson_05_javapackages.task01_javapackages.converter.ConvertCmToMeters;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Введите длину комнаты в сантиметрах(для дробных чисел используйте запятую): ");
        double lengthCm = keyboard.nextDouble();
        System.out.print("Введите ширину комнаты в сантиметрах(для дробных чисел используйте запятую): ");
        double widthCm = keyboard.nextDouble();

        // Используем функцию из пакета calculator
        double areaRoomSquareMeters = AreaCalculator.calculateAreaSquareMeters(lengthCm, widthCm);

        // Используем функцию из пакета converter
        double lengthRoomMeters = ConvertCmToMeters.cmToMeters(lengthCm);

        System.out.println("Длина комнаты: " + lengthRoomMeters + " м.");
        System.out.println("Площадь комнаты: " + areaRoomSquareMeters + " кв.м.");
    }
}
