// Задача 6.* Динамический массив на основе банковского метода.
public class DynArray_2<T> {
    private static final int MIN_CAPACITY = 16;
    private static final int REAL_OPERATION_COST = 1;
    private static final int AMORTIZED_OPERATION_PRICE = 3;

    public T[] array;
    public int count;
    public int capacity;
    public int bank;
    Class<T> clazz;

    public DynArray_2(Class<T> clz) {
        clazz = clz;
        count = 0;
        bank = 0;
        makeArray(MIN_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public void makeArray(int new_capacity) {
        if (new_capacity < MIN_CAPACITY) {
            new_capacity = MIN_CAPACITY;
        }

        if (new_capacity < count) {
            new_capacity = count;
        }

        T[] newArray = (T[]) Array.newInstance(clazz, new_capacity);

        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
            bank -= REAL_OPERATION_COST;
        }

        array = newArray;
        capacity = new_capacity;
    }

    public T getItem(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
        }

        return array[index];
    }

    public void append(T item) {
        if (count == capacity) {
            makeArray(capacity * 2);
        }

        array[count] = item;
        count++;
        bank += AMORTIZED_OPERATION_PRICE - REAL_OPERATION_COST;
    }

    public void insert(T item, int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
        }

        if (count == capacity) {
            makeArray(capacity * 2);
        }

        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = item;
        count++;
        bank += AMORTIZED_OPERATION_PRICE - REAL_OPERATION_COST;
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
        }

        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }

        count--;
        array[count] = null;

        bank += (AMORTIZED_OPERATION_PRICE - REAL_OPERATION_COST); 

        if (count * 2 < capacity) {
            makeArray((int)(capacity / 1.5));
        }
    }

    public int getBank() {
        return bank;
    }
}

// Задача 7.* Многомерный динамический массив.
public class DynArray_4<T> {
    private static class DynArray<E> {
        private Object[] array;
        private int count;
        private int capacity;

        public DynArray(int initialCapacity) {
            this.capacity = Math.max(initialCapacity, 16);
            this.array = new Object[this.capacity];
            this.count = 0;
        }

        public void add(E item) {
            if (count == capacity) {
                resize(capacity * 2);
            }

            array[count] = item;
            count++;
        }

        public void set(int index, E item) {
            if (index < 0) {
                throw new IndexOutOfBoundsException("Index cannot be negative");
            }

            ensureIndexInBounds(index);

            array[index] = item;

            if (index >= count) {
                count = index + 1;
            }
        }

        @SuppressWarnings("unchecked")
        public E getOrNull(int index) {
            if (index < 0) {
                throw new IndexOutOfBoundsException("Index cannot be negative");
            }

            if (index >= count) {
                return null;
            }

            return (E) array[index];
        }

        public void removeAt(int index) {
            if (index < 0 || index >= count) {
                throw new IndexOutOfBoundsException(
                        "Index " + index + " out of bounds for length " + count
                );
            }

            for (int i = index; i < count - 1; i++) {
                array[i] = array[i + 1];
            }

            count--;
            array[count] = null;

            if (count * 2 < capacity) {
                resize((int) (capacity / 1.5));
            }
        }

        private void ensureIndexInBounds(int index) {
            if (index < capacity) {
                return;
            }

            int newCapacity = capacity;

            for (int cap = capacity; cap <= index; cap *= 2) {
                newCapacity = cap * 2;
            }

            resize(newCapacity);
        }

        private void resize(int newSize) {
            if (newSize < 16) {
                newSize = 16;
            }

            if (newSize < count) {
                newSize = count;
            }

            if (newSize == capacity) {
                return;
            }

            Object[] newArray = new Object[newSize];

            System.arraycopy(array, 0, newArray, 0, count);

            array = newArray;
            capacity = newSize;
        }

        public int getCount() {
            return count;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    private final DynArray<Object> rootArray;
    private final int[] initialSizes;
    private final int dimensionCount;

    public DynArray_4(int... dimensions) {
        if (dimensions == null || dimensions.length == 0) {
            throw new IllegalArgumentException("Array must have at least one dimension.");
        }

        for (int dimension : dimensions) {
            if (dimension <= 0) {
                throw new IllegalArgumentException("Dimension size must be positive.");
            }
        }

        this.dimensionCount = dimensions.length;
        this.initialSizes = dimensions.clone();
        this.rootArray = new DynArray<>(dimensions[0]);
    }

    public void set(T value, int... indices) {
        validateIndices(indices);

        DynArray<Object> currentLevel = rootArray;

        for (int i = 0; i < dimensionCount - 1; i++) {
            int index = indices[i];

            Object nextLevelObj = currentLevel.getOrNull(index);

            if (nextLevelObj == null) {
                nextLevelObj = new DynArray<>(initialSizes[i + 1]);
                currentLevel.set(index, nextLevelObj);
            }

            @SuppressWarnings("unchecked")
            DynArray<Object> nextLevel = (DynArray<Object>) nextLevelObj;

            currentLevel = nextLevel;
        }

        currentLevel.set(indices[dimensionCount - 1], value);
    }

    @SuppressWarnings("unchecked")
    public T get(int... indices) {
        validateIndices(indices);

        DynArray<Object> currentLevel = rootArray;

        for (int i = 0; i < dimensionCount - 1; i++) {
            Object nextLevelObj = currentLevel.getOrNull(indices[i]);

            if (nextLevelObj == null) {
                return null;
            }

            currentLevel = (DynArray<Object>) nextLevelObj;
        }

        return (T) currentLevel.getOrNull(indices[dimensionCount - 1]);
    }

    private void validateIndices(int[] indices) {
        if (indices == null) {
            throw new IllegalArgumentException("Indices cannot be null.");
        }

        if (indices.length != dimensionCount) {
            throw new IllegalArgumentException(
                    "Expected " + dimensionCount + " indices, but got " + indices.length
            );
        }

        for (int index : indices) {
            if (index < 0) {
                throw new IndexOutOfBoundsException("Indices cannot be negative.");
            }
        }
    }
}

/*
Рефлексия:
Задача 8.*. Функция суммирования двух связанных списков.
Алгоритм моего решения соответствует рекомендации: предварительная проверка длин, минимальное условие в заголовке цикла, 
один синхронный проход по спискам, сумма каждой пары элементов добавляется в хвост нового списка.
Что можно улучшить:
1. В случае неравенства длин списков явно сообщить о проблеме, например выбросить исключение IllegalArgumentException. 
Возврат пустого списка скрывает ошибку, потому что вызывающий код не сможет однозначно понять, действительно ли результат 
должен быть пустым или произошла ошибка из-за разных длин списков. Исключение сразу сигнализирует о том, что входные 
данные некорректны, что упрощает поиск ошибок.
2. Заменить while на for:
for (Node node1 = list1.head, node2 = list2.head; node1 != null; node1 = node1.next, node2 = node2.next) {
*/

