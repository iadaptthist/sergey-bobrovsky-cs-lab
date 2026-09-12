// Занятие 10. Множества.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerSet_2 {
    private final int capacity = 20000;
    private final List<String>[] slots;
    private int count;

    public PowerSet_2() {
        slots = new ArrayList[capacity];
        count = 0;
    }

    public int size() {
        return count;
    }

    private int hash(String value) {
        int h = value.hashCode() % capacity;
        if (h < 0) {
            h += capacity;
        }
        return h;
    }

    public void put(String value) {
        if (get(value)) {
            return;
        }

        int h = hash(value);
        if (slots[h] == null) {
            slots[h] = new ArrayList<>();
        }

        slots[h].add(value);
        count++;
    }

    public boolean get(String value) {
        int h = hash(value);
        if (slots[h] == null) {
            return false;
        }

        return slots[h].contains(value);
    }

    public boolean remove(String value) {
        int h = hash(value);
        if (slots[h] == null) {
            return false;
        }

        boolean removed = slots[h].remove(value);
        if (!removed) {
            return false;
        }

        count--;
        return true;
    }

    public List<String> getElements() {
        List<String> elements = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            if (slots[i] == null) {
                continue;
            }
            elements.addAll(slots[i]);
        }

        return elements;
    }

    public PowerSet_2 intersection(PowerSet_2 set2) {
        PowerSet_2 res = new PowerSet_2();

        for (String value : getElements()) {
            if (!set2.get(value)) {
                continue;
            }
            res.put(value);
        }

        return res;
    }

    public PowerSet_2 union(PowerSet_2 set2) {
        PowerSet_2 res = new PowerSet_2();

        for (String value : getElements()) {
            res.put(value);
        }

        for (String value : set2.getElements()) {
            res.put(value);
        }

        return res;
    }

    public PowerSet_2 difference(PowerSet_2 set2) {
        PowerSet_2 res = new PowerSet_2();

        for (String value : getElements()) {
            if (set2.get(value)) {
                continue;
            }
            res.put(value);
        }

        return res;
    }

    public boolean isSubset(PowerSet_2 set2) {
        for (String value : set2.getElements()) {
            if (!this.get(value)) {
                return false;
            }
        }

        return true;
    }

    public boolean equals(PowerSet_2 set2) {
        if (this.size() != set2.size()) {
            return false;
        }

        return this.isSubset(set2);
    }

    // Задача 4.* метод, реализующий декартово произведение множеств.
    // сложность по времени O(N*M), по памяти O(N*M).
    public PowerSet_2 cartesianProduct(PowerSet_2 set2) {
        PowerSet_2 res = new PowerSet_2();
        List<String> elements1 = this.getElements();
        List<String> elements2 = set2.getElements();

        int size1 = elements1.size();
        int size2 = elements2.size();

        if (size1 == 0 || size2 == 0) {
            return res;
        }

        int totalCombinations = size1 * size2;

        for (int i = 0; i < totalCombinations; i++) {
            int index1 = i / size2;
            int index2 = i % size2;

            String val1 = elements1.get(index1);
            String val2 = elements2.get(index2);

            res.put(val1 + ", " + val2 + ", ");
        }

        return res;
    }

    // Задача 5.* метод, который находит пересечение любых трёх и более множеств (принимает количество множеств >= 3
    // в качестве списка).
    // сложность по времени O(N*M), по памяти O(N).
    public PowerSet_2 multiIntersection(List<PowerSet_2> sets) {
        if (sets == null || sets.size() < 3) {
            throw new IllegalArgumentException("It is necessary to transmit at least three sets.");
        }

        PowerSet_2 res = sets.get(0);

        for (int i = 1; i < sets.size(); i++) {
            res = res.intersection(sets.get(i));

            if (res.size() == 0) {
                return res;
            }
        }

        return res;
    }
}

// Задача 6.* мульти-множество (Bag), в котором каждый элемент может присутствовать несколько раз.
class Bag<T> {
    private HashMap<T, Integer> elements = new HashMap<>();

    public static class ElementAndFrequency<T> {
        private T element;
        private int frequency;

        public ElementAndFrequency(T element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }

        public T getElement() {
            return element;
        }

        public int getFrequency() {
            return frequency;
        }
    }

    public void add(T element) {
        Integer count = elements.get(element);

        if (count == null) {
            elements.put(element, 1);
            return;
        }

        elements.put(element, count + 1);
    }

    public void remove(T element) {
        Integer count = elements.get(element);

        if (count == null) {
            return;
        }

        if (count == 1) {
            elements.remove(element);
            return;
        }

        elements.put(element, count - 1);
    }

    public List<ElementAndFrequency<T>> getElementsWithFrequencies() {
        List<ElementAndFrequency<T>> result = new ArrayList<>();
        for (Map.Entry<T, Integer> entry : elements.entrySet()) {
            T currentElement = entry.getKey();
            Integer currentFrequency = entry.getValue();
            ElementAndFrequency<T> frequencyInfo = new ElementAndFrequency<>(currentElement, currentFrequency);
            result.add(frequencyInfo);
        }

        return result;
    }
}

/*
Рефлексия по задачам задания 8.
Задачи 3.* динамическая хэш-таблица.
Главное отличие связано не с алгоритмом расширения, а с архитектурой. В решении хэш-таблица отвечает и за хэширование,
и за хранение массива, и за его расширение. В рекомендации эти обязанности разделены: динамический массив отвечает за
хранение и изменение размера буфера, хэш-таблица отвечает за хеширование и вычисление индексов.
Задачи 5.* ddos хэш-таблицы и соль.
В решении использовал статическую соль. Я усложнил подбор коллизий, но не устранил уязвимость полностью. Основной вывод:
защита от ddos-атак на хэш-таблицу строится на непредсказуемости, а не на сложности формулы.
 */

