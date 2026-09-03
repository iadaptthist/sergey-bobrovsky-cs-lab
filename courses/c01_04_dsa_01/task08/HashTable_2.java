// Занятие 8. Хэширование.

// Задача 3.* динамическая хэш-таблица, которая автоматически увеличивает свой размер, если места перестает хватать.
public class HashTable_2 {
    public int size;
    public int step;
    public String[] slots;
    public int count;

    public HashTable_2(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        count = 0;
    }

    public int hashFun(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += value.charAt(i);
        }
        return sum % size;
    }

    public int seekSlot(String value) {
        int startIndex = hashFun(value);
        for (int i = 0; i < size; i++) {
            int currentIndex = (startIndex + i * step) % size;
            if (slots[currentIndex] == null) {
                return currentIndex;
            }
        }
        return -1;
    }

    public int put(String value) {
        if (count * 10 >= size * 7) {
            resize();
        }
        int index = seekSlot(value);
        for (; index == -1; index = seekSlot(value)) {
            resize();
        }
        slots[index] = value;
        count++;
        return index;
    }

    public int find(String value) {
        int startIndex = hashFun(value);
        for (int i = 0; i < size; i++) {
            int index = (startIndex + i * step) % size;
            if (slots[index] == null) {
                return -1;
            }
            if (slots[index].equals(value)) {
                return index;
            }
        }

        return -1;
    }

    public void resize() {
        String[] oldSlots = slots;
        size = size * 2 + 1;
        slots = new String[size];
        count = 0;

        for (String slot : oldSlots) {
            if (slot == null) {
                continue;
            }
            put(slot);
        }
    }
}

// Задача 4.* хэш-таблица, которая использует несколько хэш-функций для каждой операции вставки, чтобы уменьшить вероятность коллизий.
class MultiHashTable {
    public int size;
    public String[] slots;

    public MultiHashTable(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("The table size must be greater than 0.");
        }
        this.size = size;
        this.slots = new String[size];
    }

    public int hashFun1(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += value.charAt(i);
        }
        return sum % size;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int hashFun2(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += value.charAt(i) * (i + 1);
        }
        if (size <= 1) {
            return 1;
        }
        int step = 1 + sum % (size - 1);
        for (int i = 0; i < size; i++) {
            if (gcd(step, size) == 1) {
                return step;
            }
            step++;
            if (step >= size) {
                step = 1;
            }
        }
        return 1;
    }

    public int seekSlot(String value) {
        int startIndex = hashFun1(value);
        int stepValue = hashFun2(value);
        for (int i = 0; i < size; i++) {
            int currentIndex = (startIndex + i * stepValue) % size;
            if (slots[currentIndex] == null) {
                return currentIndex;
            }
        }
        return -1;
    }

    public int put(String value) {
        int index = seekSlot(value);
        if (index == -1) {
            return -1;
        }
        slots[index] = value;
        return index;
    }

    public int find(String value) {
        int startIndex = hashFun1(value);
        int stepValue = hashFun2(value);
        for (int i = 0; i < size; i++) {
            int index = (startIndex + i * stepValue) % size;
            if (slots[index] == null) {
                return -1;
            }
            if (slots[index].equals(value)) {
                return index;
            }
        }
        return -1;
    }
}

// Задача 5.* защищенная хэш-таблица с солью для защиты от DDoS-атак
class SaltedHashTable {
    public int size;
    public int step;
    public String[] slots;

    public SaltedHashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) {
            slots[i] = null;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int hashFun(String value) {
        int dynamicSalt = (value.length() * 31) ^ value.charAt(0) ^ value.charAt(value.length() - 1);
        long hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash += ((long) value.charAt(i) * (i + 1)) ^ dynamicSalt;
        }
        return (int) hash % size;
    }

    public int seekSlot(String value) {
        int startIndex = hashFun(value);
        int normalizedStep = step % size;
        int d = gcd(size, normalizedStep);
        int L = size / d;

        for (int i = 0; i < size; i++) {
            int index = (startIndex + (i / L) + (i % L) * normalizedStep) % size;
            if (slots[index] == null) {
                return index;
            }
        }
        return -1;
    }

    public int put(String value) {
        int index = seekSlot(value);
        if (index == -1) {
            return -1;
        }
        slots[index] = value;
        return index;
    }

    public int find(String value) {
        int startIndex = hashFun(value);
        int normalizedStep = step % size;
        int d = gcd(size, normalizedStep);
        int L = size / d;
        for (int i = 0; i < size; i++) {
            int index = (startIndex + (i / L) + (i % L) * normalizedStep) % size;
            if (slots[index] == null) {
                return -1;
            }
            if (slots[index].equals(value)) {
                return index;
            }
        }
        return -1;
    }
}

/*
Рефлексия по задачам задания 6.
Задачи 4.* Проверка строки на палиндром.
Решение соответствует рекомендации. строка записывается в деку посимвольно, после чего элементы извлекаются с обоих
концов поочередно и сравниваются.

Задачи 5.* Минимальный элемент деки за O(1).
Недостатки моего решения по сравнении с решением указанным в рекомендации:
- сложнее по структуре: вместо одной дополнительной деки используются два стека с отдельным хранением минимумов;
- для remove может потребоваться перенос всех элементов из одного стека в другой, что занимает O(N) времени;
- сложнее для понимания.

Задачи 6.* Двусторонняя очередь на базе динамического массива.
Совершил указанную в рекомендации ошибку - смешивал в одном классе логику двух разных структур данных. Из за этого
код получился сложнее для понимания, тестирования и изменения. Динамический массив нельзя удобно переиспользовать отдельно от дека.
*/
