// Занятие 11. Фильтр Блюма

// Задача 1. классический фильтр Блюма для строк на основе битового массива.
public class BloomFilter {
    public int filter_len;
    public int bitArray;

    public BloomFilter(int f_len) {
        if (f_len < 1 || f_len > Integer.SIZE) {
            throw new IllegalArgumentException("filter_len must be between 1 and 32");
        }
        filter_len = f_len;
        bitArray = 0;
    }

    public int hash1(String str1) {
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = result * 17 + code;
        }
        return Math.floorMod(result, filter_len);
    }

    public int hash2(String str1) {
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = result * 223 + code;
        }
        return Math.floorMod(result, filter_len);
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
}

