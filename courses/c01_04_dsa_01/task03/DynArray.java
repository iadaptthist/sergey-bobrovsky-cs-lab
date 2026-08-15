// Занятие 3. Динамические массивы.

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    // Задача 1. формирование блока памяти заданного размера.
    // сложность по времени O(N), по памяти O(N).
    public void makeArray(int new_capacity)
    {
        if (new_capacity < 16) {
            new_capacity = 16;
        }

        if (new_capacity < count) {
            new_capacity = count;
        }

        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);

        if (this.array != null) {
            System.arraycopy(this.array, 0, newArray, 0, this.count);
        }

        this.array = newArray;
        this.capacity = new_capacity;
    }

    // Задача 1. получение объекта по его индексу.
    // сложность по времени O(1), по памяти O(1).
    public T getItem(int index)
    {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
        }
        return array[index];
    }

    // Задача 1. добавление нового элемента в конец массива.
    // сложность по времени O(N), по памяти O(N).
    public void append(T itm)
    {
        if (count == capacity) {
            makeArray(capacity * 2);
        }

        array[count] = itm;
        count++;
    }

    // Задача 2. Вставка по индексу.
    // сложность по времени O(N), по памяти O(N).
    public void insert(T itm, int index)
    {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
        }

        if (count == capacity) {
            makeArray(capacity * 2);
        }

        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = itm;
        count++;
    }

    // Задача 3. Удаление по индексу.
    // сложность по времени O(N), по памяти O(N).
    public void remove(int index)
    {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
        }

        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }

        count--;
        array[count] = null;

        if (capacity > 16 && count * 2 < capacity) {
            makeArray((int)(capacity / 1.5));
        }
    }
}

