package c01_02_toolkit_and_workflow.lesson_08_testing.task01_testdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AscendingSortTest {
    @Test
    @DisplayName("Сортировка неотсортированного массива.")
    void testUnsortedArray() {
        int[] unsorted = {27, 30, 31, 41, 10};
        int[] expected = {10, 27, 30, 31, 41};
        int[] sortedAscending = AscendingSort.mySort(unsorted);
        assertArrayEquals(expected, sortedAscending, "Массив должен быть отсортирован по возрастанию.");
    }

    @Test
    @DisplayName("Сортировка уже отсортированного массива.")
    void testAlreadySortedArray() {
        int[] sortedAscending = {10, 27, 30, 31, 41};
        int[] actual = AscendingSort.mySort(sortedAscending);
        assertArrayEquals(sortedAscending, actual, "Отсортированный массив должен остаться без изменений.");
    }

    @Test
    @DisplayName("Сортировка массива отсортированного в обратном порядке.")
    void testReverseOrderArray() {
        int[] sortedReverseAscending = {41, 31, 30, 27, 10};
        int[] expected = {10, 27, 30, 31, 41};
        int[] sortedAscending = AscendingSort.mySort(sortedReverseAscending);
        assertArrayEquals(expected, sortedAscending, "Массив должен быть отсортирован по возрастанию.");
    }

    @Test
    @DisplayName("Сортировка массива с дубликатами.")
    void testWithDuplicates() {
        int[] unsorted = {41, 10, 41, 10, 30};
        int[] expected = {10, 10, 30, 41, 41};
        int[] sortedAscending = AscendingSort.mySort(unsorted);
        assertArrayEquals(expected, sortedAscending, "Дубликаты должны быть сохранены и отсортированы.");
    }

    @Test
    @DisplayName("Сортировка массива с отрицательными, положительными числами, нулем.")
    void testNegPosZeroNumbers() {
        int[] unsorted = {-3, -1, -7, 0, 5};
        int[] expected = {-7, -3, -1, 0, 5};
        int[] sortedAscending = AscendingSort.mySort(unsorted);
        assertArrayEquals(expected, sortedAscending, "Массив должен быть отсортирован по возрастанию.");
    }

    @Test
    @DisplayName("Обрабатывает пустой массив.")
    void testEmptyArray() {
        int[] EmptyArray = {};
        int[] actual = AscendingSort.mySort(EmptyArray);
        assertEquals(0, actual.length);
        assertArrayEquals(EmptyArray, actual, "Пустой массив должен остаться пустым.");
    }

    @Test
    @DisplayName("Исходный массив не должен изменяться после сортировки.")
    void testOriginalArrayNotChanged() {
        int[] originalArray = {27, 30, 31, 41, 10};
        int[] copyArray = Arrays.copyOf(originalArray, originalArray.length);
        AscendingSort.mySort(originalArray);
        assertArrayEquals(copyArray, originalArray, "Исходный массив был изменен.");
    }

    @Test
    @DisplayName("Случайное тестирование (сравнение с Arrays.sort).")
    void testComparisonArraysSort() {
        Random rand = new Random();
        int iterations = 1000; // Проверяем тысячу случайных массивов

        for(int i = 0; i < iterations; i++) {
            // Генерируем массив случайной длины (от 0 до 50)
            int length = rand.nextInt(51);
            int[] randomArray = new int[length];

            // Заполняем случайными числами от -100 до 100
            for (int j = 0; j < length; j++) {
                randomArray[j] = rand.nextInt(201) - 100;
            }

            // Копируем массив и сортируем стандартным методом Arrays.sort
            int[] expected = Arrays.copyOf(randomArray, randomArray.length);
            Arrays.sort(expected);

            assertArrayEquals(expected, AscendingSort.mySort(randomArray));
        }
    }
}
