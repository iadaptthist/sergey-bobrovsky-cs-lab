// Занятие 9. Ассоциативный массив

import java.lang.reflect.Array;

// Задача 2. Реализуйте класс NativeDictionary.
// Задача 3. Добавьте в этот класс три метода: put(key, value), is_key(key), get(key).
class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        // Всегда возвращает корректный индекс слота.
        return Math.floorMod(key.hashCode(), size);
    }

    // сложность по времени O(N), по памяти O(1).
    public boolean isKey(String key) {
        // возвращает true если ключ имеется,
        // иначе false
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            if (slots[currentIndex] == null) {
                return false;
            }
            if (slots[currentIndex].equals(key)) {
                return true;
            }
        }
        return false;
    }

    // сложность по времени O(N), по памяти O(1).
    public void put(String key, T value) {
        // гарантированно записываем
        // значение value по ключу key
        int index = hashFun(key);

        for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            if (slots[currentIndex] != null && slots[currentIndex].equals(key)) {
                values[currentIndex] = value;
                return;
            }
        }

        for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            if (slots[currentIndex] == null) {
                slots[currentIndex] = key;
                values[currentIndex] = value;
                return;
            }
        }

        throw new IllegalStateException("Dictionary is full, cannot add key: " + key);
    }

    // сложность по времени O(N), по памяти O(1).
    public T get(String key) {
        // возвращает value для key,
        // или null если ключ не найден
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
}

