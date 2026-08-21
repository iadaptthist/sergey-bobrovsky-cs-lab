// Занятие 5. Очереди.

import java.util.LinkedList;
import java.util.Stack;

public class Queue_2<T> {
    private LinkedList<T> qu;

    public Queue_2() {
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

    // Задача 3*. Вращает очередь по кругу на n элементов
    // сложность по времени O(N), по памяти O(1).
    public void rotate(int n) {
        if (size() <= 1) {
            return;
        }

        if (n <= 0) {
            return;
        }

        int steps = n % size();

        if (steps == 0) {
            return;
        }

        for (int i = 0; i < steps; i++) {
            enqueue(dequeue());
        }
    }

    // Задача 5*. все элементы в очереди в обратном порядке.
    // сложность по времени O(N), по памяти O(N).
    public void reverse() {
        if (size() <= 1) {
            return;
        }

        Stack<T> stack = new Stack<>();

        int currentSize = size();

        for (int i = 0; i < currentSize; i++) {
            stack.push(dequeue());
        }

        for (int i = 0; i < currentSize; i++) {
            enqueue(stack.pop());
        }
    }
}
    // Задача 4*. Очередь с помощью двух стеков.
    class QueueFromStacks<T> {
        private Stack<T> inputStack;
        private Stack<T> outputStack;

        public QueueFromStacks() {
            inputStack = new Stack<>();
            outputStack = new Stack<>();
        }

        public void enqueue(T item) {
            inputStack.push(item);
        }

        public T dequeue() {

            moveInputToOutput();

            if (outputStack.isEmpty()) {
                return null;
            }

            return outputStack.pop();
        }

        public int size() {
            return inputStack.size() + outputStack.size();
        }

        private void moveInputToOutput() {
            if (!outputStack.isEmpty()) {
                return;
            }

            int itemsToMove = inputStack.size();
            for (int i = 0; i < itemsToMove; i++) {
                outputStack.push(inputStack.pop());
            }
        }
    }

// Задача 6*. Круговая очередь.
class CircularQueue<T> {
    private Object[] elements;
    private int capacity;
    private int head = 0;
    private int tail = 0;
    private int countElements = 0;

    public CircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }

        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    public boolean isFull() {
        return countElements == capacity;
    }

    public boolean isEmpty() {
        return countElements == 0;
    }

    public int getCountElements() {
        return countElements;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        elements[tail] = item;
        tail = (tail + 1) % capacity;
        countElements++;
    }

    @SuppressWarnings("unchecked")
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
}

/*
Рефлексия по задачам задания 3.
Задача 6.* Реализуйте динамический массив на основе банковского метода.
Что сделал правильно:
 - при добавлении элемента амортизационные 3 (1 реальные расходы + 2 кладем в банк);
 - при реаллокации (добавляем N элементов) - из банка списывается N;
 - расширение выполняется, когда массив полностью заполнен.
Где ошибся:
 - при удалении использую неправильную амортизационную цену - 3 (1 реальные расходы + 2 кладем в банк);
 - при уменьшении массива на N элементов - из банка списывается N.
Основная ошибка — я использовал одну универсальную амортизационную цену для всех операций.

Задача 7.* Реализуйте многомерный динамический массив.
В своем решении я пошел прямолинейным путем: начал строить структуру из вложенных динамических массивов,
фактически массив массивов массивов. Это работает, но за это приходится платить памятью (много объектов вместо
одного блока), и скоростью доступа (переход по ссылкам на каждом уровне вместо одного вычисления индекса).
 */

