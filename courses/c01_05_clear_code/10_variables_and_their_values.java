// Занятие 10. Переменные и их значения.
// Язык Java.

1) // Добавил проверку.
   // Для завершения работы с переменной добавил строку array[count] = null.
    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
        }

        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }

        count--;
        array[count] = null;

        if (count * 2 < capacity) {
            makeArray(capacity * 2 / 3);
        }
    }

2) // Добавил final в параметры метода.
public Node find(final int value) {
    Node node = this.head;
    ...
}

3) // Добавил проверку.
public void put(String key, T value) {
    if (key == null) {
        throw new IllegalArgumentException("Key must not be null");
    }
    int index = hashFun(key);
    ...
}

4) // Переменная-счетчик в заголовке цикла. Для этого заменил while на for.
// Было:
public Node find(final int value) {
    Node node = this.head;
    while (node != null) {
           if (node.value == value)
           return node;
           node = node.next;
    }
return null;
}

// Стало:
public Node find(final int value) {
    for (Node node = this.head; node != null; node = node.next) {
         if (node.value == value) {
         return node;
    }
}
return null;
}

5) // Для завершения работы с переменной добавил строку elements[head] = null.
   public T dequeue() {
       if (isEmpty()) {
           throw new IllegalStateException("Queue is empty");
       }

       T item = (T) elements[head];
       elements[head] = null;

       head = (head + 1) % capacity;
       countElements--;

       return item;
  }

6)  // Добавил проверку.
    public void append(T itm) {
        if (count < 0 || count > capacity) {
        throw new IllegalStateException("count must be between 0 and capacity: count = " + count + ", capacity = " + capacity);
        }
        if (count == capacity) {
            makeArray(capacity * 2);
        }

        array[count] = itm;
        count++;
    }

7) // Для завершения работы с переменной добавил строки slots[minIndex] = null, values[minIndex] = null.
    public void put(String key, T value) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }
        int index = hashFun(key);
        ...

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
        ...
    }

8) // Добавил проверки.
public int compare(T v1, T v2) {
    if (v1 == null) {
    throw new IllegalArgumentException("v1 must not be null");
    }
    if (v2 == null) {
    throw new IllegalArgumentException("v2 must not be null");
    ...
}

9) // Добавил проверку.
public void addInTail(final Node item) {
    if (item == null) {
        throw new IllegalArgumentException("Item must not be null");
    }
    ...
}

10) // Для завершения работы с переменной добавил строки slots[count - 1] = null, values[count - 1] = null.
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

11) // Добавил проверки.
public int hashFun(String key) {
    if (key == null) {
        throw new IllegalArgumentException("key must not be null");
    }
    if (size <= 0) {
        throw new IllegalStateException("Size must be greater than zero");
    }
    return Math.floorMod(key.hashCode(), size);
}

12) // Добавил проверку.
    public BloomFilter(int f_len) {
        if (filter_len < 1 || filter_len > Integer.SIZE) {
            throw new IllegalArgumentException("filter_len must be between 1 and 32");
        }
        filter_len = f_len;
        bitArray = 0;
    }

13) // Для завершения работы с переменной добавил строку values[idx] = null.
    public void delete(long key) {
        int idx = normalizeKey(key);
        if (!slotOccupied(idx)) {
            throw new NoSuchElementException("Key not found: " + key);
        }
        clearOccupied(idx);
        values[idx] = null;
    }

14) // Добавил final в поля класса.
public class HashTable {
    private final int size;
    private final int step;
    ...
}

15) // Добавил проверки.
public static LinkedList sumOfTwo(LinkedList list1, LinkedList list2) {
    if (list1 == null) {
        throw new IllegalArgumentException("list1 must not be null");
    }

    if (list2 == null) {
        throw new IllegalArgumentException("list2 must not be null");
    }
}

