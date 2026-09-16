class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public NativeCache(int sz, Class<T> clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, size);
        hits = new int[size];
    }

    public int hashFun(String key) {
        return Math.floorMod(key.hashCode(), size);
    }

    public boolean isKey(String key) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            if (slots[currentIndex] != null && slots[currentIndex].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, T value) {
        int index = hashFun(key);

        for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            if (slots[currentIndex] != null && slots[currentIndex].equals(key)) {
                values[currentIndex] = value;
                hits[currentIndex]++;
                return;
            }
        }

        for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            if (slots[currentIndex] == null) {
                slots[currentIndex] = key;
                values[currentIndex] = value;
                hits[currentIndex] = 0;
                return;
            }
        }

        int minHits = hits[0];
        int minIndex = 0;

        for (int i = 1; i < size; i++) {
            if (hits[i] < minHits) {
                minHits = hits[i];
                minIndex = i;
            }
        }

        slots[minIndex] = null;
        values[minIndex] = null;
        hits[minIndex] = 0;

        for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            if (slots[currentIndex] == null) {
                slots[currentIndex] = key;
                values[currentIndex] = value;
                hits[currentIndex] = 0;
                return;
            }
        }
    }

    public T get(String key) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            int currentIndex = (index + i) % size;
            if (slots[currentIndex] != null && slots[currentIndex].equals(key)) {
                hits[currentIndex]++;
                return values[currentIndex];
            }
        }
        return null;
    }
}

