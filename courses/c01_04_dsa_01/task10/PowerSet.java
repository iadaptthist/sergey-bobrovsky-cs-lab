// Занятие 10. Множества

// Задача 1. Создайте реализующий множество класс PowerSet.
public class PowerSet {
    private int capacity = 20000;
    private List<String>[] slots;
    private int count;

    public PowerSet() {
        slots = new ArrayList[capacity];
        count = 0;
    }

    public int size() {
        return count;
    }

    public int hash(String value) {
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

    // Задача 2. метод удаления элемента из множества.
    // сложность по времени O(N), по памяти O(1).
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

    // Задача 2. метод возвращает множество, в котором есть только те элементы, которые имеются в каждом из множеств.
    // сложность по времени O(N), по памяти O(N).
    public PowerSet intersection(PowerSet set2) {
        PowerSet res = new PowerSet();

        for (String value : getElements()) {
            if (!set2.get(value)) {
                continue;
            }
            res.put(value);
        }

        return res;
    }

    // Задача 2. метод возвращает множество, в котором есть все элементы из каждого множества
    // сложность по времени O(N+M), по памяти O(N+M).
    public PowerSet union(PowerSet set2) {
        PowerSet res = new PowerSet();

        for (String value : getElements()) {
            res.put(value);
        }

        for (String value : set2.getElements()) {
            res.put(value);
        }

        return res;
    }

    // Задача 2. метод возвращает подмножество текущего множества из таких элементов, которые не входят в множество-параметр.
    // сложность по времени O(N), по памяти O(N).
    public PowerSet difference(PowerSet set2) {
        PowerSet res = new PowerSet();

        for (String value : getElements()) {
            if (set2.get(value)) {
                continue;
            }
            res.put(value);
        }

        return res;
    }

    // Задача 2. метод проверяет будет ли множество-параметр подмножеством текущего множества.
    // сложность по времени O(N), по памяти O(1).
    public boolean isSubset(PowerSet set2) {
        for (String value : set2.getElements()) {
            if (!this.get(value)) {
                return false;
            }
        }

        return true;
    }

    // Задача 2. метод проверяет равно ли текущее множество параметру.
    // сложность по времени O(N), по памяти O(1).
    public boolean equals(PowerSet set2) {
        if (this.size() != set2.size()) {
            return false;
        }

        return this.isSubset(set2);
    }
}


