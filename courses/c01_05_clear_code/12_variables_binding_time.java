// Занятие 12. Время связывания переменных.
// Язык Java.

1) // Связывание во время написания кода.
// count = 0 задан прямо в коде, потому что новый динамический массив создается пустым.
// В нем еще нет элементов, поэтому счетчик элементов должен начинаться с нуля.
public class DynArray<T> {
    private T [] array;
    private int count;
    private int capacity;
    private Class clazz;

    public DynArray(Class clz) {
        clazz = clz;
        count = 0;
        ...
    }
}

2) // Связывание во время компиляции (MINIMUM_CAPACITY).
// Здесь связывание во время компиляции дает ту же жесткость и предсказуемость, как и в первом примере, но с возможностью
// изменить все значения в одной точке без поиска по всему коду.
public class DynArray<T> {
    private static final int MINIMUM_CAPACITY = 16;
    ...
  
    public DynArray(Class clz) {
        clazz = clz;
        ...
    }
}

3) // Связывание в процессе выполнения программы - при вызове конструктора (создании нового объекта класса).
// capacity связывается во время выполнения программы, потому что это обеспечивает необходимую гибкость,
// позволяя определять размер хранилища в зависимости от конкретных нужд приложения в момент создания объекта.
class CircularQueue<T> {
    private Object[] elements;
    private int capacity;
    ...

    public CircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }

        this.capacity = capacity;
        this.elements = new Object[capacity];
    }
}

  
