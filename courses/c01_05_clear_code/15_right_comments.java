// Занятие 15. Правильные комментарии.
// Язык Java.

1) Пункт 3. Прояснение.
public class LinkedList {
    // Метод удаляет только первое найденное значение.
    public boolean remove(int _value) {
        // ... код метода
        return true;
    }
}

2) Пункт 4. Предупреждения о последствиях
public class LinkedList2 {
    // Не вызывайте для списка с циклом.
    // Обход завершается только при node == null, поэтому цикл в списке приведет к бесконечному выполнению метода.
    public void reverse() {
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
}

3) Пункт 1. Информативный комментарий.
public boolean hasCycle() {
    if (head == null) {
        return false;
    }
    // Реализация алгоритма Флойда («черепаха и заяц»).
    for (Node slow = head, fast = head.next; fast != null && fast.next != null; slow = slow.next, fast = fast.next.next) {
         if (slow == fast) {
             return true;
         }
    }
    return false;
}

4) Пункт 2. Представление намерений.
public class Stack_2 {
    // Допускаются только символы '(' и ')'.
    // Любой другой символ (включая пробел) считается ошибкой по условию задачи.
    public static boolean isBracketSequenceBalanced(String s) {
        if (s == null) {
            throw new IllegalArgumentException("The input string cannot be null.");
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                continue;
            }
            if (ch != ')') {
                return false;
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
   }
}

5) Пункт 2. Представление намерений
public static class PostfixCalculator {
    public static int calculatePostfix(String expression) {
        // ...
        // Читаем массив с конца, чтобы при заполнении стека элементы извлекались в правильном порядке слева направо.
        for (int i = elements.length - 1; i >= 0; i--) {
             inputStack.push(elements[i]);
        }
        // ...
        return 0;
     }
}

6) Пункт 5. Усиление.
class CircularQueue<T> {
    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        // Использование оператора % критически важно для "зацикливания" индекса tail, предотвращая выход за пределы выделенного массива.
        elements[tail] = item;
        tail = (tail + 1) % capacity;
        countElements++;
    }
}

7) Пункт 6. TODO.
public class Deque_2 {
    // На данный момент функция чувствительна к регистру и пробелам.
    // TODO: В версии 2.0 добавить нормализацию строки (toLowerCase и удаление не букв).
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

8) Пункт 3. Прояснение.
public class OrderedList<T> {
    // Возвращает -1 (меньше), 0 (равно) или 1 (больше).
    public int compare(T v1, T v2) {
        if (v1 instanceof Integer && v2 instanceof Integer){
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
}

9) Пункт 2. Представление намерений.
public class PowerSet {
    public void put(String value) {
        // В множестве не может быть дубликатов, поэтому перед вставкой мы проверяем наличие элемента методом get().
        if (get(value)) {
            return;
        }
        int h = hash(value);
        if (slots[h] == null) {
            slots[h] = new ArrayList<>();
        }
        slots[h].add(value);
        count++;
    }
}

10) Пункт 2. Представление намерений.
public class LinkedList_2 {
    // По условиям задачи мы складываем только равные по длине списки.
    // Если размеры не совпадают, намеренно возвращаем пустой список, а не выполняем частичное сложение.
    public static LinkedList sumOfTwo(LinkedList list1, LinkedList list2) {
        LinkedList result = new LinkedList();
        if (list1.count() != list2.count()) {
            return result;
        }
        Node node1 = list1.head;
        Node node2 = list2.head;
        while (node1 != null) {
            result.addInTail(new Node(node1.value + node2.value));
            node1 = node1.next;
            node2 = node2.next;
        }
        return result;
    }
}

11) Пункт 1. Информативный комментарий.
// Множители 17 и 223 — простые числа.
// Использование взаимно простых множителей обеспечивает равномерное рассеивание битов по фильтру.
public int hash1(String str1) {
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = result * 17 + code;
        }
        return Math.floorMod(result, filter_len);
    }

public int hash2(String str1) {
    int result = 0;
    for (int i = 0; i < str1.length(); i++) {
         int code = (int) str1.charAt(i);
         result = result * 223 + code;
        }
    return Math.floorMod(result, filter_len);
}

12) Пункт 2. Представление намерений.
public class Queue_2<T> {
    public void reverse() {
        if (size() <= 1) {
            return;
        }
        // Используем свойство стека LIFO (последним пришел - первым ушел),
        // чтобы естественно инвертировать порядок элементов нашей FIFO очереди.
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

