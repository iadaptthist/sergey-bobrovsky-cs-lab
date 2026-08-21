// Занятие 5. Очереди.

import java.util.*;

// Задача 1. три метода:
// size() (количество элементов в очереди),
// enqueue(item) -- добавить элемент в хвост очереди,
// и dequeue(), которая возвращает элемент из головы очереди, удаляя его.
public class Queue<T>
{
    private LinkedList<T> qu;

    public Queue() {
        qu = new LinkedList<>();
    }

    // Задача 2. сложность по времени O(1), по памяти O(1)
    public void enqueue(T item) {
        qu.add(0, item);
    }

    // Задача 2. сложность по времени O(1), по памяти O(1)
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

