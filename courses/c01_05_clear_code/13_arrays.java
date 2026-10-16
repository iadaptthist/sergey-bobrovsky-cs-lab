// Занятие 13. Массивы.
// Язык Java.

1) // Замена массива на ArrayDeque.
// Было:
class CircularQueue<T> {
    private Object[] elements;
    private int capacity;
    private int head = 0;
    private int tail = 0;
    private int countElements = 0;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }
    public void enqueue(T item) {
        if (countElements == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        elements[tail] = item;
        tail = (tail + 1) % capacity;
        countElements++;
    }
    public T dequeue() {
        if (countElements == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) elements[head];
        elements[head] = null; 
        head = (head + 1) % capacity;
        countElements--;
        return item;
    }
}
// Стало:
import java.util.ArrayDeque;

class CircularQueue<T> {
    private final ArrayDeque<T> queue;
    private final int capacity;
  
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayDeque<>(capacity);
    }

    public void enqueue(T item) {
        if (queue.size() == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        queue.addLast(item);
    }
    public T dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.removeFirst();
    }
}

2) // Замена LinkedList на ArrayDeque.
// Было:
import java.util.LinkedList;
import java.util.List;

public class Stack<T> {
    public List<T> stack;

    public Stack() {
        this.stack = new LinkedList<>();
    }
    public int size() {
        return stack.size();
    }
    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(0);
    }
    public void push(T val) {
        stack.add(0, val);
    }
    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.get(0);
    }
}
// Стало:
import java.util.ArrayDeque;
import java.util.Deque;

public class Stack<T> {
    private Deque<T> stack;

    public Stack() {
        this.stack = new ArrayDeque<>();
    }
    public int size() {
        return stack.size();
    }
    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.pop();
    }

    public void push(T val) {
        stack.push(val);
    }
    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }
}

3) // Список недавно открытых файлов. Можно использовать Deque, если нужно добавлять новые файлы в начало и удалять старые с конца. 
recentFiles = ["report.pdf", "notes.txt", "diagram.png"]

4) // Замена LinkedList на ArrayDeque.
// Было:
import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> qu;

    public Queue() {
        qu = new LinkedList<>();
    }
    public void enqueue(T item) {
        qu.add(0, item);
    }
    public T dequeue() {
        if (qu.isEmpty()) {
            return null;
        }
        return qu.remove(qu.size() - 1);
    }
    public int size() {
        return qu.size();
    }
}
// Стало:
import java.util.ArrayDeque;
import java.util.Deque;

public class Queue<T> {
    private Deque<T> qu;

    public Queue() {
        qu = new ArrayDeque<>();
    }
    public void enqueue(T item) {
        qu.addLast(item);
    }
    public T dequeue() {
        return qu.pollFirst();
    }
    public int size() {
        return qu.size();
    }
}

5) // Замена массива на HashMap
// Было:
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
        return Math.floorMod(key.hashCode(), size);
    }
    public boolean isKey(String key) {
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
    public void put(String key, T value) {
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
    public T get(String key) {
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
// Стало:
import java.util.HashMap;
import java.util.Map;

class NativeDictionaryOnMap<T> {
    private final int size;
    private final Map<String, T> map;

    public NativeDictionaryOnMap(int sz) {
        if (sz <= 0) {
            throw new IllegalArgumentException("size must be positive");
        }
        this.size = sz;
        this.map = new HashMap<>(sz);
    }
    public int hashFun(String key) {
        return Math.floorMod(key.hashCode(), size);
    }
    public boolean isKey(String key) {
        return map.containsKey(key);
    }
    public T get(String key) {
        return map.get(key);
    }
    public void put(String key, T value) {
        map.put(key, value);
    }
    public void remove(String key) {
        map.remove(key);
    }
    public int size() {
        return map.size();
    }
    public boolean isEmpty() {
        return map.isEmpty();
    }
}

