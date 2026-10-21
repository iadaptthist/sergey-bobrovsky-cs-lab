// Занятие 16. Плохие комментарии.
// Язык Java.

1) Пункт 4. Шум.
Удалил комментарий "добавление в хвост".
Было:
// добавление в хвост
public void addTail(T item) {
    deque.addLast(item);
}

2) Пункт 4. Шум.
Удалил комментарий "добавляем в хвост новый узел с суммой значений двух узлов".
Было:
public class LinkedList_2 {
    public static LinkedList sumOfTwo(LinkedList list1, LinkedList list2) {
    ...
    // добавляем в хвост новый узел с суммой значений двух узлов
    result.addInTail(new Node(node1.value + node2.value));
    ...
    }
}

3) Пункт 4. Шум.
Удалил комментарий "размер очереди".
Было:
// размер очереди
public int size() {
    return deque.size();
}

4) Пункт 4. Шум.
Удалил комментарий "возвращает value для key".
Было:
// возвращает value для key
public T get(String key) {
    int index = hashFun(key);
    for (int i = 0; i < size; i++) {
         int currentIndex = (index + i) % size;
         if (slots[currentIndex] == null) {
             return null;
         }
         if (slots[currentIndex].equals(key)) {
             return values[currentIndex];
         }
    }
    return null;
}

5) Пункт 4. Шум.
Удалил комментарий "хэш-функция, которая по входному значению вычисляет индекс слота.".
Было:
// хэш-функция, которая по входному значению вычисляет индекс слота.
public int hashFun(String value) {
    int sum = 0;
    for (int i = 0; i < value.length(); i++) {
         sum += value.charAt(i);
    }
    return sum % size;
}

6) Пункт 12. Не используйте комментарии там, где можно использовать функцию или переменную.
Удалил комментарий "количество использований", изменил имя переменной.
Было:
class NativeCache<T> {
    ...
    public int[] hits; // количество использований
}
Стало:
class NativeCache<T> {
    ...
    public int[] usageCounts;
}

7) Пункт 8. Слишком много информации.
Удалил комментарий "сложность по времени O(N) - нет, не изменилась, по памяти O(1)". Изменил имя переменной.
Было:
// сложность по времени O(N) - нет, не изменилась, по памяти O(1).
public Node<T> find(T val) {
     for (Node<T> current = head; current != null; current = current.next) {
          int cmp = compare(current.value, val);
          if (cmp == 0)
              return current;
          if (_ascending && cmp > 0)
              return null;
          if (!_ascending && cmp < 0)
              return null;
      }
      return null;
}
Стало:
public Node<T> find(T val) {
     for (Node<T> current = head; current != null; current = current.next) {
          int currentVsVal = compare(current.value, val);
          if (currentVsVal == 0)
              return current;
          if (_ascending && currentVsVal > 0)
              return null;
          if (!_ascending && currentVsVal < 0)
              return null;
      }
      return null;
}

8) Пункт 7. Избыточные комментарии.
Удалил комментарий.
Было:
class Bag<T> {
// Получаем текущее количество вхождений элемента в мультимножество.
// Если элемента еще нет, кладем 1, иначе увеличиваем счетчик на 1.
    public void add(T element) {
        Integer count = elements.get(element);
        if (count == null) {
            elements.put(element, 1);
            return;
        }
        elements.put(element, count + 1);
    }
}
Стало:
class Bag<T> {
    public void add(T element) {
        Integer count = elements.get(element);
        if (count == null) {
            elements.put(element, 1);
            return;
        }
        elements.put(element, count + 1);
    }
}

9) Пункт 4. Шум.
Удалил комментарий "Декартово произведение множеств".
Было:
// Декартово произведение множеств
public PowerSet_2 cartesianProduct(PowerSet_2 set2) {
}

10) Пункт 12. Не используйте комментарии там, где можно использовать функцию или переменную
Удалил два комментария, изменил имена переменных.
Было:
public static class StackWithMin {
    private Stack<Integer> mainStack; // стек для всех элементов
    private Stack<Integer> stackWithMin; // стек для минимальных элементов
}
Стало:
public static class StackWithMin {
    private Stack<Integer> values;
    private Stack<Integer> minValues;
}

11) Пункт 2. Бормотание.
Удалил комментарий, изменил имя переменной.
Было:
public void removeAll(int _value) {
    for (Node node = head; node != null; ) {
         Node nextNode = node.next; // сохраняем чтобы не потерять

         if (node.value != _value) {
             node = nextNode;
             continue;
         }
         ...
     }
}
Стало:
public void removeAll(int _value) {
    for (Node current = head; current != null; ) {
         Node nextAfterCurrent = current.next;

         if (current.value != _value) {
             current = nextAfterCurrent;
             continue;
         }
         ...
     }
}

12) Пункт 7. Избыточные комментарии.
Удалил комментарий.
Было:
// Используем Math.floorMod вместо оператора %, так как key.hashCode() может вернуть
// отрицательное число, а индекс массива должен быть неотрицательным от 0 до size - 1
public int hashFun(String key) {
    return Math.floorMod(key.hashCode(), size);
}
Стало:
public int hashFun(String key) {
    return Math.floorMod(key.hashCode(), size);
}

13) Пункт 12. Не используйте комментарии там, где можно использовать функцию или переменную.
Удалил комментарий, добавил новую переменную-константу.
Было:
public void makeArray(int new_capacity) {
    // минимальная вместимость массива - 16
    if (new_capacity < 16) {
        new_capacity = 16;
    }
}
Стало:
private static final int MIN_CAPACITY = 16;
public void makeArray(int new_capacity) {
    if (new_capacity < MIN_CAPACITY) {
        new_capacity = MIN_CAPACITY;
    }
}

14) Пункт 4. Шум.
Удалил комментарий "удаление из хвоста".
Было:
// удаление из хвоста
public T removeTail() {
    if (deque.isEmpty())
        return null;

    return deque.removeLast();
}

15) Пункт 12. Не используйте комментарии там, где можно использовать функцию или переменную.
Удалил комментарий "Общее количество пар", изменил название переменной.
Было:
public PowerSet_2 cartesianProduct(PowerSet_2 set2) {
    ...
    // Общее количество пар
    int totalCombinations = size1 * size2;

    for (int i = 0; i < totalCombinations; i++) {
        ...
     }
     return res;
}
Стало:
public PowerSet_2 cartesianProduct(PowerSet_2 set2) {
    ...
    int totalPairCount = size1 * size2;

    for (int i = 0; i < totalPairCount; i++) {
         ...
     }
     return res;
}

