// Занятие 7. Упорядоченный список

import java.util.*;

class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }
    // Задача 2. Сравнение двух значений.
    // Задача 5.
    // -1 если v1 < v2
    // 0 если v1 == v2
    // +1 если v1 > v2
    public int compare(T v1, T v2)
    {
        if (v1 instanceof Integer && v2 instanceof Integer){
            if ((Integer) v1 < (Integer) v2) {
                return -1;
            }
            if ((Integer) v1 > (Integer) v2) {
                return 1;
            }
        }

        if (v1 instanceof String && v2 instanceof String){
            String str1 = ((String) v1).trim();
            String str2 = ((String) v2).trim();
            if (str1.compareTo(str2) > 0) {
                return 1;
            }
            if (str1.compareTo(str2) < 0) {
                return -1;
            }
        }
        return 0;
    }

    // Задача 3. Добавление нового элемента по значению.
    // сложность по времени O(N), по памяти O(1).
    public void add(T value)
    {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        for (Node<T> current = head; current != null; current = current.next) {
            int compResult = compare(current.value, value);
            boolean shouldInsertBefore = (_ascending && compResult >= 0) || (!_ascending && compResult <= 0);

            if (!shouldInsertBefore) {
                continue;
            }

            newNode.next = current;
            newNode.prev = current.prev;

            if (current.prev != null) {
                current.prev.next = newNode;
            }

            if (current == head) {
                head = newNode;
            }

            current.prev = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Задача 6. Поиск с учетом упорядоченности и ранним завершением.
    // сложность по времени O(N) - нет, не изменилась, по памяти O(1).
    public Node<T> find(T val)
    {
        for (Node<T> current = head; current != null; current = current.next)
        {
            int cmp = compare(current.value, val);

            if (cmp == 0)
                return current;

            if (_ascending && cmp > 0)
                return null;

            if (!_ascending && cmp < 0)
                return null;
        }

        return null;
    }

    // Задача 4. Удаление первого найденного элемента по значению.
    // сложность по времени O(N), по памяти O(1).
    public void delete(T val)
    {
        Node<T> node = find(val);

        if (node == null)
            return;

        if (node.prev == null)
            head = node.next;

        if (node.prev != null)
            node.prev.next = node.next;

        if (node.next == null)
            tail = node.prev;

        if (node.next != null)
            node.next.prev = node.prev;
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        head = null;
        tail = null;
    }

    public int count()
    {
        int count = 0;

        for (Node<T> node = head; node != null; node = node.next)
            count += 1;

        return count;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}

