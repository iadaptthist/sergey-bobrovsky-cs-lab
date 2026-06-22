package c01_02_toolkit_and_workflow.lesson_13_hashmap.task02_findrepeats;

import java.util.*;

public class FindRepeats {
    // Функция возвращает список значений повторяющихся не менее n раз.
    public static ArrayList<Integer> getValuesRepeatedNOrMoreTimes(ArrayList<Integer> list, int n) {
        // Словарь, где ключ - число, значение - количество его повторений.
        HashMap<Integer, Integer> countRepetitionsNumber = countRepetitions(list);
        // Список для результата
        ArrayList<Integer> result = new ArrayList<>();
        // Проходим по ключам словаря и отбираем те, у которых значение >= n
        for (int key : countRepetitionsNumber.keySet()) {
            if (countRepetitionsNumber.get(key) >= n) {
                result.add(key);
            }
        }
        return result;
    }

     // Метод для подсчета количества повторений каждого элемента списка.
     // Возвращает словарь, где ключ - число, значение - количество его повторений.
    public static HashMap<Integer, Integer> countRepetitions(ArrayList<Integer> list) {
        HashMap<Integer, Integer> countHashMap = new HashMap<>();
        // Заполняем словарь
        for (int num : list) {
            if (countHashMap.containsKey(num)) {
                countHashMap.put(num, countHashMap.get(num) + 1);
            } else {
                countHashMap.put(num, 1);
            }
        }
        return countHashMap;
    }

    // Метод для генерации списка случайных чисел.
    public static ArrayList<Integer> generateListRandNumbers(int size, int min, int max) {
        ArrayList<Integer> list = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(max - min + 1) + min);
        }
        return list;
    }

    public static void main(String[] args) {
        // Генерируем список из 100 значений в диапазоне от 1 до 10
        ArrayList<Integer> numbers = generateListRandNumbers(100, 1, 10);
        int n = 10;
        System.out.println("Сгенерированный список (100 чисел от 1 до 10):");
        System.out.println(numbers);
        // Вызываем функцию для поиска чисел, повторяющихся не менее n раз
        ArrayList<Integer> result = getValuesRepeatedNOrMoreTimes(numbers, n);
        System.out.println("Числа, которые повторяются не менее " + n + " раз:");
        System.out.println(result);
        // Выводим статистику повторений чисел
        HashMap<Integer, Integer> countRepetitionsEachNumber = countRepetitions(numbers);
        System.out.println("Количество повторений каждого числа:");
        System.out.println(countRepetitionsEachNumber);
    }
}


