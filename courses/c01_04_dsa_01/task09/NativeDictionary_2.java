// Занятие 9. Ассоциативный массив

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

// Задача 5.* Словарь с использованием упорядоченного списка по ключу.
public class NativeDictionary_2<T> {
    public int count;
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary_2(int sz, Class<T> clazz) {
        size = sz;
        count = 0;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, size);
    }

    // сложность по времени O(log N), по памяти O(1).
    public int findIndex(String key) {
        int left = 0;
        int right = count - 1;

        for (; left <= right; ) {
            int mid = left + (right - left) / 2;
            int cmp = slots[mid].compareTo(key);

            if (cmp == 0) {
                return mid;
            }

            if (cmp < 0) {
                left = mid + 1;
            }
            if (cmp > 0) {
                right = mid - 1;
            }
        }

        return -1;
    }

    // сложность по времени O(log N), по памяти O(1).
    public int findInsertIndex(String key) {
        int left = 0;
        int right = count - 1;

        for (; left <= right; ) {
            int mid = left + (right - left) / 2;
            int cmp = slots[mid].compareTo(key);

            if (cmp < 0) {
                left = mid + 1;
            }
            if (cmp >= 0) {
                right = mid - 1;
            }
        }

        return left;
    }

    public boolean isKey(String key) {
        return findIndex(key) != -1;
    }

    public T get(String key) {
        int index = findIndex(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    // сложность по времени O(N), по памяти O(1).
    public void put(String key, T value) {
        int index = findIndex(key);

        if (index != -1) {
            values[index] = value;
            return;
        }

        if (count >= size) {
            throw new IllegalStateException("Dictionary is full, cannot add key: " + key);
        }

        int insertIdx = findInsertIndex(key);
        for (int i = count; i > insertIdx; i--) {
            slots[i] = slots[i - 1];
            values[i] = values[i - 1];
        }

        slots[insertIdx] = key;
        values[insertIdx] = value;
        count++;
    }

    // сложность по времени O(N), по памяти O(1).
    public void remove(String key) {
        int index = findIndex(key);
        if (index == -1) {
            return;
        }

        for (int i = index; i < count - 1; i++) {
            slots[i] = slots[i + 1];
            values[i] = values[i + 1];
        }

        slots[count - 1] = null;
        values[count - 1] = null;
        count--;
    }
}

// Задача 6.* Словарь, в котором ключи представлены битовыми строками фиксированной длины.
class BitStringDictionary<V> {
    public int bitWidth;
    public long keyMask;
    public Object[] values;
    public long[] occupiedSlots;

    public BitStringDictionary(int bitWidth) {
        if (bitWidth <= 0 || bitWidth > 30) {
            throw new IllegalArgumentException("bitWidth must be between 1 and 30");
        }

        this.bitWidth = bitWidth;
        this.keyMask = computeKeyMask(bitWidth);

        int nSlots = 1 << bitWidth;
        this.values = new Object[nSlots];
        this.occupiedSlots = new long[calcWordsForSlots(nSlots)];
    }

    private static long computeKeyMask(int bitWidth) {
        return (1L << bitWidth) - 1L;
    }

    private static int calcWordsForSlots(int nSlots) {
        return (nSlots + 63) / 64;
    }

    private int normalizeKey(long key) {
        return (int) (key & keyMask);
    }

    private boolean slotOccupied(int slot) {
        int wordIndex = slot >> 6;
        int bitIndex = slot & 63;
        return (occupiedSlots[wordIndex] & (1L << bitIndex)) != 0;
    }

    private void setOccupied(int slot) {
        int wordIndex = slot >> 6;
        int bitIndex = slot & 63;
        occupiedSlots[wordIndex] |= (1L << bitIndex);
    }

    private void clearOccupied(int slot) {
        int wordIndex = slot >> 6;
        int bitIndex = slot & 63;
        occupiedSlots[wordIndex] &= ~(1L << bitIndex);
    }

    public void put(long key, V value) {
        int idx = normalizeKey(key);
        values[idx] = value;
        setOccupied(idx);
    }

    public V get(long key) {
        int idx = normalizeKey(key);
        if (!slotOccupied(idx)) {
            throw new NoSuchElementException("Key not found: " + key);
        }
        return (V) values[idx];
    }

    public boolean isKey(long key) {
        return slotOccupied(normalizeKey(key));
    }

    public void delete(long key) {
        int idx = normalizeKey(key);
        if (!slotOccupied(idx)) {
            throw new NoSuchElementException("Key not found: " + key);
        }
        clearOccupied(idx);
        values[idx] = null;
    }
}

/*
Рефлексия по задачам задания 7.
Задача 9.* Слияние двух упорядоченных списков в один.
Решение соответствует рекомендации. В решении я использовал алгоритм слияния двух отсортированных последовательностей.
Два указателя n1 и n2 одновременно проходят по двум спискам. На каждом шаге сравниваются текущие элементы,
после чего в результирующий список добавляется меньший элемент для сортировки по возрастанию или больший — для сортировки
по убыванию. Когда один из списков заканчивается, оставшиеся элементы второго списка просто добавляются в результат.

Задача 10.* Проверка наличия заданного упорядоченного под-списка в текущем списке.
В решении использован линейный поиск(он указан в рекомендации в предлагаемых вариантах решений). Основное отличие
от рекомендации - не используется все возможности для досрочного завершения алгоритма:
- если оставшаяся часть основного списка короче подсписка — дальнейший поиск бессмыслен, нужно прервать;
- если при сравнении элемент подсписка меньше элемента основного списка (для ascending), то подсписок
уже не встретится дальше — можно сразу вернуть false.

Задача 11.* Добавьте метод, который находит наиболее часто встречающееся значение в списке.
Решение соответствует рекомендации: список проходится один раз, одинаковые элементы сравниваются с предыдущими,
а наиболее часто встречающееся значение и количество его повторений сохраняются во время прохода.

Задача 12.* Индекс заданного элемента в списке за O(log N).
Решение соответствует рекомендации: использован бинарный поиск и динамический массив для возможности обращаться к элементам по индексу.
 */

