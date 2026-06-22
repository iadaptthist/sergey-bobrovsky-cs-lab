package c01_02_toolkit_and_workflow.lesson_13_hashmap.task01_addrandompairs;

import java.util.HashMap;
import java.util.Random;

public class AddRandomPairsInDictionary {
    public static void main(String[] args) {
        // Создаем HashMap dictionary(словарь для быстрого поиска значения String по ключу Integer)
        HashMap<Integer, String> dictionary = new HashMap<>();
        // Создаем генератор случайных чисел
        Random rand = new Random();
        int n = 100;
        int[] keys = new int[n];
        int count = 0; // счетчик добавленных неповторяющихся чисел
        while (count < n) {
            // сгенерировали случайное число
            int randomNumber = rand.nextInt(1000);
            // проверяем, есть ли уже такое число в заполненной части массива
            boolean badRandom = false;
            for(int i = 0; i < count; i ++)
                if(keys[i] == randomNumber) {
                    badRandom = true;
                    break;
                }
            // если встречалось, нужно повторить
            if(badRandom) {
                continue;
            }

            // нашлось оригинальное
            keys[count] = randomNumber;
            count ++;
        }

        // добавляем пары в словарь
        for (int key : keys) {
            String value = "RandomString_" + rand.nextInt(1000);
            dictionary.put(key, value);
        }

        // считываем и выводим
        for (int key : keys) {
            System.out.println("Ключ: " + key + ". Значение: " + dictionary.get(key));
        }

        // удаляем все пары из словаря
        dictionary.clear();
        System.out.println("Словарь очищен. Размер: " + dictionary.size());
    }
}
