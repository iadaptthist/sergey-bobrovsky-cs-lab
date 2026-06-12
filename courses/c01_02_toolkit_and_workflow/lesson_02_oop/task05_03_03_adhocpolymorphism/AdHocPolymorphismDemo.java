package c01_02_toolkit_and_workflow.lesson_02_oop.task05_03_03_adhocpolymorphism;

class Calculator {
    // сложение двух целых чисел
    public int addition(int a, int b) {
        return a + b;
    }

    // сложение двух чисел с плавающей точкой
    public double addition(double a, double b) {
        return a + b;
    }

    // сложение трех целых чисел
    public int addition(int a, int b, int c) {
        return a + b + c;
    }

    // конкатенация двух строк
    public String addition(String a, String b) {
        return a + b;
    }

    // конкатенация строки и целого числа
    public String addition(String a, int b) {
        return a + b;
    }
}

public class AdHocPolymorphismDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Вызван addition(int, int): " + calculator.addition(5, 3));
        System.out.println("Вызван addition(double, double): " + calculator.addition(1.5, 2.5));
        System.out.println("Вызван addition(int, int, int): " + calculator.addition(5, 26, 52));
        System.out.println("Вызван addition(String, String): " + calculator.addition("Hello ", "World!"));
        System.out.println("Вызван addition(String, int): " + calculator.addition("Hello ", 8));
    }
}
