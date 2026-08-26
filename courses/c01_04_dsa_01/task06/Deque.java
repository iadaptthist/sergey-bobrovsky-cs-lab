import java.util.*;

// Задача 1. Класс Deque.
public class Deque<T>
{
    private LinkedList<T> deque;

    public Deque()
    {
        // инициализация внутреннего хранилища
        deque = new LinkedList<>();
    }

    // добавление в голову
    // сложность по времени O(1), по памяти O(1).
    public void addFront(T item)
    {
        deque.addFirst(item);
    }

    // добавление в хвост
    // сложность по времени O(1), по памяти O(1).
    public void addTail(T item)
    {
        deque.addLast(item);
    }

    // удаление из головы
    // сложность по времени O(1), по памяти O(1).
    public T removeFront()
    {
        if (deque.isEmpty())
            return null;

        return deque.removeFirst();
    }

    // удаление из хвоста
    // сложность по времени O(1), по памяти O(1).
    public T removeTail()
    {
        if (deque.isEmpty())
            return null;

        return deque.removeLast();
    }

    // размер очереди
    public int size()
    {
        return deque.size();
    }
}

/*
Задача 2. Как можно понизить (выровнять) сложность addHead/removeHead и addTail/removeTail.
С помощью двунаправленного связного списка. Наличие ссылок head и tail, а также prev и next в каждом узле позволяет
выполнять addHead/removeHead и addTail/removeTail за O(1).
 */

