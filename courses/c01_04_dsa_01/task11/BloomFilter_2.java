// Занятие 11. Фильтр Блюма.

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// Задача 2.* слияние нескольких фильтров Блюма.
// Вероятность ложного срабатывания увеличивается.
public class BloomFilter_2 {
    public int bitArray;

    public BloomFilter_2() {
        this.bitArray = 0;
    }

    public static BloomFilter_2 merge(List<BloomFilter_2> filters) {
        if (filters == null || filters.isEmpty()) {
            return new BloomFilter_2();
        }

        BloomFilter_2 merged = new BloomFilter_2();

        for (BloomFilter_2 bf : filters) {
            merged.bitArray = merged.bitArray | bf.bitArray;
        }

        return merged;
    }
}

// Задача 3.* Фильтр Блюма, предусматривающий удаление элементов.
class BloomFilterRemove {
    private int filterLen;
    private int[] counters;

    public BloomFilterRemove(int fLen) {
        if (fLen < 1) {
            throw new IllegalArgumentException("filterLen must be positive");
        }
        filterLen = fLen;
        counters = new int[fLen];
    }

    public int hash1(String str1) {
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = result * 17 + code;
        }
        return Math.floorMod(result, filterLen);
    }

    public int hash2(String str1) {
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = result * 223 + code;
        }
        return Math.floorMod(result, filterLen);
    }

    public void add(String str1) {
        counters[hash1(str1)]++;
        counters[hash2(str1)]++;
    }

    public void remove(String str1) {
        if (!isValue(str1)) {
            return;
        }

        int h1 = hash1(str1);
        int h2 = hash2(str1);

        if (counters[h1] > 0) {
            counters[h1]--;
        }

        if (counters[h2] > 0) {
            counters[h2]--;
        }
    }

    public boolean isValue(String str1) {
        return counters[hash1(str1)] > 0 && counters[hash2(str1)] > 0;
    }
}

// Задача 4.* алгоритм, который анализирует конфигурацию фильтра Блюма и пытается, насколько возможно, восстановить исходное множество.
class BloomFilterRestorer {
    private int filterLen;
    private int bitArray;

    public BloomFilterRestorer(int fLen) {
        if (fLen < 1 || fLen > Integer.SIZE) {
            throw new IllegalArgumentException("filter_len must be between 1 and 32");
        }

        filterLen = fLen;
        bitArray = 0;
    }

    public int hash1(String str1) {
        int result = 0;

        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            result = result * 17 + code;
        }

        return Math.floorMod(result, filterLen);
    }

    public int hash2(String str1) {
        int result = 0;

        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            result = result * 223 + code;
        }

        return Math.floorMod(result, filterLen);
    }

    public void add(String str1) {
        bitArray = bitArray | (1 << hash1(str1));
        bitArray = bitArray | (1 << hash2(str1));
    }

    public boolean isValue(String str1) {
        boolean firstBitSet = (bitArray & (1 << hash1(str1))) != 0;
        boolean secondBitSet = (bitArray & (1 << hash2(str1))) != 0;

        return firstBitSet && secondBitSet;
    }

    public List<String> restorePossibleValues(List<String> dictionary) {
        if (dictionary == null) {
            throw new IllegalArgumentException("dictionary must not be null");
        }

        Set<String> result = new LinkedHashSet<>();

        for (int i = 0; i < dictionary.size(); i++) {
            String value = dictionary.get(i);

            if (value == null || !isValue(value)) {
                continue;
            }

            result.add(value);
        }

        return new ArrayList<>(result);
    }
}

/*
Рефлексия по задачам задания 9.
Задача 5.* Словарь с использованием упорядоченного списка по ключу.
В решении словарь реализован на основе двух упорядоченных массивов одинаковой длины: в массиве slots хранятся ключи,
в массиве values — соответствующие им значения. Главное отличие от указанного в рекомендации - бинарный поиск осуществляется
два раза: для ключей и для значений.
*/

