// Занятие 7. ООП и интерфейсы.
// Язык Java.

3.1
1)
public class LinkedList<T> {
    protected LinkedList() {
    }

    public static <T> LinkedList<T> createList() {
        return new LinkedList<>();
    }
}

class DummyLinkedList<T> extends LinkedList<T> {
    private DummyLinkedList() {
        super();
    }

    public static <T> DummyLinkedList<T> createDummyList() {
        return new DummyLinkedList<>();
    }
}

2)
public class DynArray<T> {
    private static final int MINIMUM_CAPACITY = 16;

    private int count;
    private int capacity;
    private T[] array;

    private DynArray() {
        this.count = 0;
        this.capacity = MINIMUM_CAPACITY;
        this.array = makeArray(this.capacity);
    }

    private DynArray(int customCapacity) {
        this.count = 0;
        this.capacity = Math.max(customCapacity, MINIMUM_CAPACITY);
        this.array = makeArray(this.capacity);
    }

    public static <T> DynArray<T> makeDefaultArray() {
        return new DynArray<>();
    }

    public static <T> DynArray<T> makeArrayWithCapacity(int capacity) {
        return new DynArray<>(capacity);
    }

    private T[] makeArray(int newCapacity) {
        return (T[]) new Object[newCapacity];
    }
}

3)
public class Node<T> {
    private T value;
    private Node<T> prev;
    private Node<T> next;

    private Node(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public static Node<Integer> createIntNode(int value) {
        return new Node<>(value);
    }

    public static Node<String> createStrNode(String value) {
        return new Node<>(value);
    }
}

3.2
// Интерфейсы и абстрактные классы еще не использовал.

  
