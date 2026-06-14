package c01_02_toolkit_and_workflow.lesson_05_javapackages.task01_javapackages.calculator;

import c01_02_toolkit_and_workflow.lesson_05_javapackages.task01_javapackages.converter.ConvertCmToMeters;

public class AreaCalculator {
    // Функция для расчета площади. Принимает размеры в сантиметрах
    public static double calculateAreaSquareMeters(double lengthCm, double widthCm) {
        // Используем функцию из пакета converter
        double lengthMeters = ConvertCmToMeters.cmToMeters(lengthCm);
        double widthMeters = ConvertCmToMeters.cmToMeters(widthCm);

        return lengthMeters * widthMeters;
    }
}
