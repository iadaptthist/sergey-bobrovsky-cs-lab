// Занятие 4. Стек.

import java.util.*;

public class Stack<T>
{
    public LinkedList<T> stack;

    public Stack()
    {
        this.stack = new LinkedList<>();
    }

    // Задача 2.
    // сложность по времени O(1), по памяти O(1).
    public int size()
    {
        return stack.size();
    }

    // Задача 2.
    // сложность по времени O(1), по памяти O(1).
    public T pop()
    {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.remove(0);
    }

    // Задача 2.
    // сложность по времени O(1), по памяти O(1).
    public void push(T val)
    {
        stack.add(0, val);
    }

    // Задача 2.
    // сложность по времени O(1), по памяти O(1).
    public T peek()
    {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.get(0);
    }
}

/*
Задача 3.
Так как фигурных скобок нет, в тело цикла входит только первый stack.pop().
Второй stack.pop() выполняется после завершения цикла один раз.

while (stack.size() > 0) {
    stack.pop();
}
stack.pop();

Стек не пустой.
Как отработает цикл:
1. Цикл while будет вызывать первый stack.pop() до тех пор, пока стек не опустеет - size() не станет равен 0.
2. Как только стек станет пустым, цикл завершится.
3. После завершения цикла выполнится второй stack.pop().
4. Так как стек к этому моменту уже пуст, вызов stack.pop() вернет null и ничего не удалит.

Стек пустой.
Как отработает цикл:
1. Цикл не выполнится ни разу.
2. На пустом стеке, вызов stack.pop() вернет null и ничего не удалит.
*/
