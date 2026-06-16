package c01_02_toolkit_and_workflow.lesson_07_debugging_logging.task01_logging_assert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingAssertDemo {
    static Logger logger = Logger.getLogger(LoggingAssertDemo.class.getName());

    static boolean containsSecondString(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        // Лог вызова метода
        logger.log(Level.INFO, "Вызов метода containsSecondString. Параметры: s1 = " + s1 + ", s2 = " + s2);
        boolean result = false;
        for(int i = 0; i <= s1Length - s2Length; i++) {
            int j;
            for(j = 0; j < s2Length; j++) {
                assert (i + j) < s1Length : "Индекс i+j вышел за границы s1";
                // Лог внутри цикла
                logger.log(Level.FINE, "Итерация " + i + ". Сравнение s1[" + (i + j) + "] = " + s1.charAt(i + j) + " и s2[" + j + "] = " + s2.charAt(j));
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
            }
            if(j == s2Length) {
                result = true;
                // Лог успешного нахождения подстроки
                logger.log(Level.INFO, "Подстрока найдена! Индекс начала: " + i);
                break;
            }
        }
        // Лог завершения метода
        logger.log(Level.INFO, "Метод containsSecondString завершен. Результат: " + result);
        return result;
    }

    public static void main(String[] args) {
        logger.setLevel(Level.INFO);
        System.out.println("Результат 1: " + containsSecondString("12345", "234"));
        System.out.println("Результат 2: " + containsSecondString("12345", "235"));
    }
}

