import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Deque_2 {
    // Задача 4.* Проверяет, является ли строка палиндромом (читается одинаково слева направо и справа налево).
    // сложность по времени O(N), по памяти O(N).
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            deque.addLast(s.charAt(i));
        }

        for (int i = 0; i < s.length() / 2; i++) {
            char left = deque.removeFirst();
            char right = deque.removeLast();

            if (left != right) {
                return false;
            }
        }

        return true;
    }
}

// 5.* метод, который возвращает минимальный элемент деки за O(1).
class DequeWithMin {
    private StackWithMin firstHalf = new StackWithMin();
    private StackWithMin secondHalf = new StackWithMin();

    public void addFirst(int value) {
        firstHalf.push(value);
    }

    public void addLast(int value) {
        secondHalf.push(value);
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        transferIfEmpty(secondHalf, firstHalf);
        return firstHalf.pop();
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        transferIfEmpty(firstHalf, secondHalf);
        return secondHalf.pop();
    }

    // Метод, который возвращает минимальный элемент деки за O(1).
    // сложность по времени O(1), по памяти O(1).
    public int getMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        if (firstHalf.isEmpty()) {
            return secondHalf.getMin();
        }
        if (secondHalf.isEmpty()) {
            return firstHalf.getMin();
        }
        return Math.min(firstHalf.getMin(), secondHalf.getMin());
    }

    public boolean isEmpty() {
        return firstHalf.isEmpty() && secondHalf.isEmpty();
    }

    private void transferIfEmpty(StackWithMin from, StackWithMin to) {
        if (!to.isEmpty()) { 
          return;
        }

        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }

    private static class StackWithMin {
        private Deque<Integer> values = new LinkedList<>();
        private Deque<Integer> minValues = new LinkedList<>();

        public void push(int value) {
            values.push(value);
            if (minValues.isEmpty()) {
                minValues.push(value);
            } else {
                minValues.push(Math.min(value, minValues.peek()));
            }
        }

        public int pop() {
            if (values.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            minValues.pop();
            return values.pop();
        }

        public int getMin() {
            if (minValues.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return minValues.peek();
        }

        public boolean isEmpty() {
            return values.isEmpty();
        }
    }
}

// 6.* двусторонняя очередь с помощью динамического массива.
class DynamicArrayDeque<T> {
    private Object[] elements;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    private static final int MIN_CAPACITY = 16;

    public DynamicArrayDeque() {
        this.capacity = MIN_CAPACITY;
        this.elements = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    // Амортизированная сложность: O(1)
    public void addFirst(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }

        head = (head - 1 + capacity) % capacity;
        elements[head] = item;
        size++;
    }

    // Амортизированная сложность: O(1)
    public void addLast(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        elements[tail] = item;
        tail = (tail + 1) % capacity;
        size++;
    }

    // Амортизированная сложность: O(1)
    @SuppressWarnings("unchecked")
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T item = (T) elements[head];
        elements[head] = null;
        head = (head + 1) % capacity;
        size--;

        if (size * 2 < capacity) {
            resize((int)(capacity / 1.5));
        }
        return item;
    }

    // Амортизированная сложность: O(1)
    @SuppressWarnings("unchecked")
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        tail = (tail - 1 + capacity) % capacity;
        T item = (T) elements[tail];
        elements[tail] = null;
        size--;

        if (size * 2 < capacity) {
            resize((int)(capacity / 1.5));
        }
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int newCapacity) {
        if (newCapacity < MIN_CAPACITY) {
            newCapacity = MIN_CAPACITY;
        }

        if (newCapacity == capacity) {
            return;
        }

        Object[] newElements = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(head + i) % capacity];
        }

        elements = newElements;
        head = 0;
        tail = size;
        capacity = newCapacity;
    }
}

/*
Рефлексия по задачам задания 4.
Задачи 4.*, 5.* Баланс открывающих и закрывающих.
Мое решение совпадает с эталонным:
Последовательно перебираем все символы строки и помещаем открывающие скобки (, {, [ в стек.
При обнаружении закрывающей скобки сначала проверяем, не пуст ли стек. Если стек пуст, значит, у закрывающей скобки
нет пары и последовательность несбалансирована. Затем извлекаем последнюю открывающую скобку и проверяем соответствие
ее типа закрывающей скобке. После обработки строки проверяем, остались ли в стеке незакрытые скобки.

Задача 6.* Текущий минимальный элемент в стеке за O(1).
Мое решение соответствует эталонному.
В моем решении было использовано два стека:
- основной стек mainStack - хранит все добавленные элементы;
- дополнительный стек stackWithMin - хранит текущие минимумы.
Дополнительный стек stackWithMin нужен для того, чтобы быстро получать минимальный элемент без перебора
всего основного стека. Минимальный элемент всегда находится на вершине stackWithMin,поэтому метод getMin() работает за O(1).

Задача 7.* Среднее значение всех элементов в стеке за O(1).
Мое решение соответствует рекомендации:
В класс добавлена приватная переменная sum, которая хранит сумму всех элементов стека. В методе push значение
прибавляется к сумме: sum += val. В методе pop значение вычитается из суммы: sum -= poppedValue. Метод getAverage
возвращает среднее значение.
Благодаря тому, что сумма и количество элементов поддерживаются актуальными при каждой операции,
среднее значение вычисляется за O(1), то есть без перебора всех элементов стека.

Задача 8.* Постфиксная запись выражения.
Отличие моего решения от рекомендации - я не использовал словарь с лямбда-функциями для операций.
Вместо этого операции обрабатываются через цепочку if. Для двух операций это допустимо и понятно, но если
бы операций было больше, такой код пришлось бы дублировать и расширять вручную.
Поэтому предложенный в рекомендации подход со словарем и функциями более гибкий и масштабируемый.
 */

