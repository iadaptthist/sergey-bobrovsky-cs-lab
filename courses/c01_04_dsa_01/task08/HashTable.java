// Занятие 8. Хэширование.

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // хэш-функция, которая по входному значению вычисляет индекс слота.
    // сложность по времени O(N), по памяти O(1).
    public int hashFun(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += value.charAt(i);
        }
        return sum % size;
    }

    // функция поиска слота.
    // сложность по времени O(N+M), по памяти O(1).
    public int seekSlot(String value) {
        int startIndex = hashFun(value);
        int normalizedStep = step % size;

        int d = gcd(size, normalizedStep);
        int L = size / d;

        for (int i = 0; i < size; i++) {
            int cycleIndex = i / L;
            int stepIndex = i % L;
            int index = (startIndex + cycleIndex + stepIndex * normalizedStep) % size;
            if (slots[index] == null) {
                return index;
            }
        }
        return -1;
    }

    // функция помещает значение value в слот.
    // сложность по времени O(N+M), по памяти O(1).
    public int put(String value) {
        int index = seekSlot(value);
        if (index == -1) {
            return -1;
        }
        slots[index] = value;
        return index;
    }

    // функция проверяет, имеется ли в слотах указанное значение.
    // сложность по времени O(N+M), по памяти O(1).
    public int find(String value) {
        int startIndex = hashFun(value);
        int normalizedStep = step % size;
        int d = gcd(size, normalizedStep);
        int L = size / d;
        for (int i = 0; i < size; i++) {
            int cycleIndex = i / L;
            int stepIndex = i % L;
            int index = (startIndex + cycleIndex + stepIndex * normalizedStep) % size;
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

