// Занятие 2. Двунаправленный связанный список.

import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    // Задача 1. поиск первого узла по его значению.
    // сложность по времени O(n), по памяти O(1).
    public Node find(int _value)
    {
        for (Node node = head; node != null; node = node.next)
            if (node.value == _value)
                return node;

        return null;
    }

    // Задача 2. поиск всех узлов по конкретному значению.
    // сложность по времени O(n), по памяти O(n).
    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (Node node = head; node != null; node = node.next) {
            if (node.value == _value) {
                nodes.add(node);
            }
        }
        return nodes;
    }

    // Задача 3. удаление одного узла по его значению.
    // сложность по времени O(n), по памяти O(1).
    public boolean remove(int _value)
    {
        for (Node node = head; node != null; node = node.next) {
            if (node.value != _value) {
                continue;
            }

            if (node.prev != null) {
                node.prev.next = node.next;
            }

            if (node.prev == null) {
                head = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            }

            if (node.next == null) {
                tail = node.prev;
            }

            node.next = null;
            node.prev = null;

            return true;
        }

        return false;
    }

    // Задача 4. удаления всех узлов по конкретному значению.
    // сложность по времени O(n), по памяти O(1).
    public void removeAll(int _value)
    {
        for (Node node = head; node != null; ) {
            Node nextNode = node.next;

            if (node.value != _value) {
                node = nextNode;
                continue;
            }

            if (node.prev != null) {
                node.prev.next = node.next;
            }

            if (node.prev == null) {
                head = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            }

            if (node.next == null) {
                tail = node.prev;
            }

            node.next = null;
            node.prev = null;

            node = nextNode;
        }
    }

    // Задача 7. очистка всего списка.
    // сложность по времени O(1), по памяти O(1).
    public void clear()
    {
        head = null;
        tail = null;
    }

    // сложность по времени O(n), по памяти O(1).
    public int count()
    {
        int count = 0;

        for (Node node = head; node != null; node = node.next) {
            count++;
        }

        return count;
    }

    // Задача 5-6. вставка узла после заданного узла.
    // сложность по времени O(1), по памяти O(1).
    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeToInsert == null) {
            return;
        }

        if (_nodeAfter == _nodeToInsert) {
            return;
        }

        if (_nodeAfter == null && this.head == null) {
            _nodeToInsert.next = null;
            _nodeToInsert.prev = null;
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
            return;
        }

        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            _nodeToInsert.prev = null;
            head.prev = _nodeToInsert;
            head = _nodeToInsert;
            return;
        }

        _nodeToInsert.prev = _nodeAfter;
        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;

        if (_nodeToInsert.next != null) {
            _nodeToInsert.next.prev = _nodeToInsert;
        }

        if (tail == _nodeAfter) {
            tail = _nodeToInsert;
        }
    }


    // Задача 9*. переворот списка.
    // сложность по времени O(n), по памяти O(1).
    public void reverse()
    {
        Node oldHead = head;

        for (Node node = head; node != null; ) {
            Node nextNode = node.next;

            node.next = node.prev;
            node.prev = nextNode;

            node = nextNode;
        }

        head = tail;
        tail = oldHead;
    }

    // Задача 10.*. проверка наличия цикла в списке.
    // сложность по времени O(n), по памяти O(1).
    public boolean hasCycle()
    {
        if (head == null) {
            return false;
        }

        for (Node slow = head, fast = head.next; fast != null && fast.next != null; slow = slow.next, fast = fast.next.next) {
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // Задача 11.*. Сортировка по возрастанию.
    // сложность по времени O(n^2), по памяти O(1).
    public void sortInAscendingOrder()
    {
        for (Node current = head; current != null; current = current.next) {
            Node minNode = current;

            for (Node node = current.next; node != null; node = node.next) {
                if (node.value < minNode.value) {
                    minNode = node;
                }
            }

            if (minNode == current) {
                continue;
            }

            int temp = current.value;
            current.value = minNode.value;
            minNode.value = temp;
        }
    }

    // Задача 12*. объединение двух списков в третий.
    // сложность по времени O(n^2+m^2), по памяти O(n+m).
    public static LinkedList2 sortAndMergeLists(LinkedList2 firstList, LinkedList2 secondList)
    {
        LinkedList2 firstListCopy = new LinkedList2();
        Node startFirstList = null;

        if (firstList != null) {
            startFirstList = firstList.head;
        }

        for (Node current = startFirstList; current != null; current = current.next) {
            firstListCopy.addInTail(new Node(current.value));
        }

        LinkedList2 secondListCopy = new LinkedList2();
        Node startSecondList = null;

        if (secondList != null) {
            startSecondList = secondList.head;
        }

        for (Node current = startSecondList; current != null; current = current.next) {
            secondListCopy.addInTail(new Node(current.value));
        }

        if (firstListCopy.head != null) {
            firstListCopy.sortInAscendingOrder();
        }

        if (secondListCopy.head != null) {
            secondListCopy.sortInAscendingOrder();
        }

        LinkedList2 result = new LinkedList2();
        Node nodeFromFirstList = firstListCopy.head;
        Node nodeFromSecondList = secondListCopy.head;

        for (; nodeFromFirstList != null && nodeFromSecondList != null; ) {
            if (nodeFromFirstList.value <= nodeFromSecondList.value) {
                result.addInTail(new Node(nodeFromFirstList.value));
                nodeFromFirstList = nodeFromFirstList.next;
                continue;
            }

            result.addInTail(new Node(nodeFromSecondList.value));
            nodeFromSecondList = nodeFromSecondList.next;
        }

        for (; nodeFromFirstList != null; nodeFromFirstList = nodeFromFirstList.next) {
            result.addInTail(new Node(nodeFromFirstList.value));
        }

        for (; nodeFromSecondList != null; nodeFromSecondList = nodeFromSecondList.next) {
            result.addInTail(new Node(nodeFromSecondList.value));
        }

        return result;
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

