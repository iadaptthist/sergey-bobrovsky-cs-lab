// Задание 1. Связный (связанный) список;

import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    // Задача 4. поиск всех узлов по конкретному значению.
    // сложность по времени O(n), по памяти O(n).
    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node current = this.head;
        while (current != null) {
            if (current.value == _value) {
                nodes.add(current);
            }
            current = current.next;
        }
        return nodes;
    }

    // Задача 1. удаление одного узла по его значению.
    // сложность по времени O(n), по памяти O(1).
    public boolean remove(int _value)
    {
        if (this.head == null) {
            return false;
        }

        if (this.head.value == _value && this.head.next == null) {
            this.head = null;
            this.tail = null;
            return true;
        }

        if (this.head.value == _value) {
            this.head = this.head.next;
            return true;
        }

        Node current = this.head;
        while (current.next != null && current.next.value != _value) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        if (current.next.next == null) {
            current.next = null;
            this.tail = current;
            return true;
        }

        current.next = current.next.next;

        return true;
    }

    // Задача 2. удаление всех узлов по конкретному значению.
    // сложность по времени O(n), по памяти O(1).
    public void removeAll(int _value)
    {
        while (this.head != null && this.head.value == _value) {
            this.head = this.head.next;
        }

        if (this.head == null) {
            this.tail = null;
            return;
        }

        Node current = this.head;
        while (current.next != null) {
            if (current.next.value == _value) {
                current.next = current.next.next;
                continue;
            }

            current = current.next;
        }

        this.tail = current;
    }

    // Задача 3. очистка всего содержимого списка.
    // сложность по времени O(1), по памяти O(1).
    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    // Задача 5. подсчёт количества элементов в списке.
    // сложность по времени O(n), по памяти O(1).
    public int count()
    {
        int count = 0;
        Node current = this.head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Задача 6. вставка нового узла после заданного узла.
    // сложность по времени O(1), по памяти O(1).
    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeToInsert == null) {
            return;
        }

        if (_nodeAfter == _nodeToInsert) {
            return;
        }

        if (_nodeAfter == null && this.head == null) {
            _nodeToInsert.next = null;
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
            return;
        }

        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            return;
        }
        
        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;

        if (_nodeAfter == this.tail) {
            this.tail = _nodeToInsert;
        }
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
