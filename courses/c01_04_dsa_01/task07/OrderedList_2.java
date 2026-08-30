// Занятие 7. Упорядоченный список

import java.util.ArrayList;

class Node_2<T>
{
    public T value;
    public Node_2<T> next, prev;

    public Node_2(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList_2<T> {
    public Node_2<T> head, tail;
    public boolean _ascending;
    private ArrayList<Node_2<T>> indexArray;

    public OrderedList_2(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
        indexArray = new ArrayList<>();
    }

    public int compare(T v1, T v2) {
        if (v1 instanceof Integer && v2 instanceof Integer) {
            if ((Integer) v1 < (Integer) v2) {
                return -1;
            }
            if ((Integer) v1 > (Integer) v2) {
                return 1;
            }
        }

        if (v1 instanceof String && v2 instanceof String) {
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

    public void add(T value) {
        Node_2<T> newNode = new Node_2<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
            indexArray.add(newNode);
            return;
        }

        int index = 0;
        for (Node_2<T> current = head; current != null; current = current.next) {
            int compResult = compare(current.value, value);
            boolean shouldInsertBefore = (_ascending && compResult >= 0) || (!_ascending && compResult <= 0);

            if (!shouldInsertBefore) {
                index++;
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
            indexArray.add(index, newNode);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        indexArray.add(newNode);
    }

    public Node_2<T> find(T val) {
        for (Node_2<T> current = head; current != null; current = current.next) {
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

    public void delete(T val) {
        Node_2<T> node = find(val);

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
        indexArray.remove(node);
    }

    public void clear(boolean asc) {
        _ascending = asc;
        head = null;
        tail = null;
        indexArray.clear();
    }

    public int count() {
        int count = 0;

        for (Node_2<T> node = head; node != null; node = node.next)
            count += 1;

        return count;
    }

    ArrayList<Node_2<T>> getAll() {
        ArrayList<Node_2<T>> r = new ArrayList<Node_2<T>>();
        Node_2<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    // Задача 8 *. Удаление всех дубликатов из упорядоченного списка.
    // Сложность по времени O(N*N), по памяти O(1).
    public void removeDuplicates() {
        if (head == null)
            return;

        for (Node_2<T> current = head; current.next != null; ) {
            if (compare(current.value, current.next.value) != 0) {
                current = current.next;
                continue;
            }

            Node_2<T> duplicate = current.next;
            current.next = duplicate.next;

            if (duplicate.next != null)
                duplicate.next.prev = current;

            if (duplicate.next == null)
                tail = current;

            indexArray.remove(duplicate);
        }
    }

    // Задача 9 *. Слияние двух упорядоченных списков.
    // Сложность по времени O(N + M), по памяти O(1).
    public void appendInTail(T val) {
        Node_2<T> newNode = new Node_2<>(val);

        if (head == null) {
            head = newNode;
            tail = newNode;
            indexArray.add(newNode);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        indexArray.add(newNode);
    }

    public OrderedList_2<T> merge(OrderedList_2<T> other) {
        OrderedList_2<T> result = new OrderedList_2<>(this._ascending);

        for (Node_2<T> n1 = this.head, n2 = other.head; n1 != null || n2 != null; ) {
            if (n1 == null) {
                result.appendInTail(n2.value);
                n2 = n2.next;
                continue;
            }

            if (n2 == null) {
                result.appendInTail(n1.value);
                n1 = n1.next;
                continue;
            }

            int cmp = compare(n1.value, n2.value);
            boolean takeFirst = (_ascending && cmp <= 0) || (!_ascending && cmp >= 0);

            if (takeFirst) {
                result.appendInTail(n1.value);
                n1 = n1.next;
                continue;
            }

            result.appendInTail(n2.value);
            n2 = n2.next;
        }

        return result;
    }

    // Задача 10*. Проверка наличия заданного упорядоченного подсписка.
    // Сложность по времени O(N * M), по памяти O(1).
    public boolean containsSublist(OrderedList_2<T> sublist) {
        if (sublist.head == null)
            return true;

        if (head == null)
            return false;

        if (this._ascending != sublist._ascending) {
            return false;
        }

        for (Node_2<T> current = head; current != null; current = current.next) {
            int cmpHead = compare(current.value, sublist.head.value);

            boolean passedStart = (_ascending && cmpHead > 0) || (!_ascending && cmpHead < 0);

            if (passedStart)
                return false;

            if (cmpHead != 0)
                continue;

            Node_2<T> mainNode = current;
            Node_2<T> subNode = sublist.head;

            for (; mainNode != null && subNode != null && compare(mainNode.value, subNode.value) == 0; mainNode = mainNode.next, subNode = subNode.next) {
                if (subNode.next == null)
                    return true;
            }
        }

        return false;
    }

    // Задача 11 *. Поиск наиболее часто встречающегося значения в списке.
    // Сложность по времени O(N), по памяти O(1).
    public T findMostFrequent()
    {
        if (head == null)
            return null;

        T mostFrequent = head.value;
        int maxCount = 1;
        int currentCount = 1;

        for (Node_2<T> current = head.next; current != null; current = current.next)
        {
            if (compare(current.value, current.prev.value) != 0)
            {
                currentCount = 1;
                continue;
            }

            currentCount += 1;

            if (currentCount > maxCount)
            {
                maxCount = currentCount;
                mostFrequent = current.value;
            }
        }

        return mostFrequent;
    }

    // Задача 12 *. Поиск индекса элемента за O(log N).
    // Сложность по времени O(log N), по памяти O(1).
    public int indexOf(T val) {
        int left = 0;
        int right = indexArray.size() - 1;

        for (; left <= right; ) {
            int mid = (left + right) / 2;
            int cmp = compare(indexArray.get(mid).value, val);

            if (cmp == 0) {
                return mid;
            }

            boolean goRight = (_ascending && cmp < 0) || (!_ascending && cmp > 0);

            if (goRight) {
                left = mid + 1;
                continue;
            }

            right = mid - 1;
        }

        return -1;
    }
}

/*
Рефлексия по задачам задания 5.
Задача 3.* Вращение очереди по кругу на N элементов.
Решение соответствует рекомендации: беру элемент с одного конца очереди и помещаю его в другой конец,
повторяя это нужное число раз.

Задача 4.* Очередь с помощью двух стеков.
Решение соответствует рекомендации: элементы всегда добавляются в один стек, извлечение выполняется из другого стека,
перенос элементов происходит только тогда, когда стек для извлечения пуст.

Задача 5.* Обращение всех элементов в очереди в обратном порядке.
Решение совпадает с рекомендацией: первый цикл передает элементы из очереди в стек (первый элемент очереди оказывается
на дне), второй цикл возвращает их обратно — и последний элемент очереди становится первым.

Задача 6.* Циклическая буферную очередь на базе статического массива фиксированного размера.
Основное отличие моего решения от описанного в рекомендации в способе определения того, пуста очередь или заполнена.
Я использую дополнительную переменную countElements(фактическое количество элементов в очереди).
При этом очередь:
 - пуста, если countElements == 0;
 - заполнена, если countElements == capacity.
 */

