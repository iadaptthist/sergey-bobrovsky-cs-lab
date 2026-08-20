import java.util.*;

// Задача 4.* функция, которая получает на вход строку, состоящую из открывающих и закрывающих скобок.
// сложность по времени O(n), по памяти O(n).
public class Stack_2 {
    public static boolean isBracketSequenceBalancedTask4(String s) {
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

    // Задача 5.* функция, которая получает на вход строку, состоящую из: (), {}, []
    // сложность по времени O(n), по памяти O(n).
    public static boolean isBracketSequenceBalancedTask5(String s) {
        if (s == null) {
            throw new IllegalArgumentException("The input string cannot be null.");
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (ch != ')' && ch != '}' && ch != ']') {
                throw new IllegalArgumentException("The input string can contain only brackets: (), {}, [].");
            }

            if (stack.isEmpty()) {
                return false;
            }

            char openingBracket = stack.pop();

            if (openingBracket == '(' && ch != ')') {
                return false;
            }

            if (openingBracket == '{' && ch != '}') {
                return false;
            }

            if (openingBracket == '[' && ch != ']') {
                return false;
            }
        }

        return stack.isEmpty();
    }

    // Задача 6.* добавить функцию, возвращающую текущий минимальный элемент в нём за O(1).
    // сложность по времени O(1), по памяти O(n).
    public static class StackWithMin {
        private Stack<Integer> mainStack;
        private Stack<Integer> stackWithMin;

        public StackWithMin() {
            mainStack = new Stack<>();
            stackWithMin = new Stack<>();
        }

        public void push(int val) {
            mainStack.push(val);

            if (stackWithMin.isEmpty() || val <= stackWithMin.peek()) {
                stackWithMin.push(val);
            }
        }

        public int pop() {
            if (mainStack.isEmpty()) {
                throw new EmptyStackException();
            }

            int poppedValue = mainStack.pop();

            if (poppedValue == stackWithMin.peek()) {
                stackWithMin.pop();
            }

            return poppedValue;
        }

        public int peek() {
            if (mainStack.isEmpty()) {
                throw new EmptyStackException();
            }

            return mainStack.peek();
        }

        public int getMin() {
            if (stackWithMin.isEmpty()) {
                throw new EmptyStackException();
            }

            return stackWithMin.peek();
        }
    }

    // Задача 7.* добавить функцию, которая возвращает среднее значение всех элементов в стеке.
    // сложность по времени O(1), по памяти O(n).
    public static class StackWithAvg {
        private Stack<Integer> mainStack;
        private Stack<Integer> stackWithMin;
        private long sum;

        public StackWithAvg() {
            mainStack = new Stack<>();
            stackWithMin = new Stack<>();
            sum = 0;
        }

        public void push(int val) {
            mainStack.push(val);
            sum += val;

            if (stackWithMin.isEmpty() || val <= stackWithMin.peek()) {
                stackWithMin.push(val);
            }
        }

        public int pop() {
            if (mainStack.isEmpty()) {
                throw new EmptyStackException();
            }

            int poppedValue = mainStack.pop();
            sum -= poppedValue;

            if (poppedValue == stackWithMin.peek()) {
                stackWithMin.pop();
            }

            return poppedValue;
        }

        public int peek() {
            if (mainStack.isEmpty()) {
                throw new EmptyStackException();
            }

            return mainStack.peek();
        }

        public int getMin() {
            if (stackWithMin.isEmpty()) {
                throw new EmptyStackException();
            }

            return stackWithMin.peek();
        }

        public double getAverage() {
            if (mainStack.isEmpty()) {
                throw new EmptyStackException();
            }

            return (double) sum / mainStack.size();
        }
    }

    // Задача 8.* постфиксная запись.
    // сложность по времени O(N), по памяти O(N).
    public static class PostfixCalculator {
        public static int calculatePostfix(String expression) {
            Stack<String> inputStack = new Stack<>();
            Stack<Integer> resultStack = new Stack<>();

            String[] elements = expression.split(" ");

            for (int i = elements.length - 1; i >= 0; i--) {
                inputStack.push(elements[i]);
            }

            int operationsCount = inputStack.size();

            for (int i = 0; i < operationsCount; i++) {
                String element = inputStack.pop();

                if (element.equals("=")) {
                    return resultStack.pop();
                }

                if (element.equals("+")) {
                    int b = resultStack.pop();
                    int a = resultStack.pop();
                    resultStack.push(a + b);
                    continue;
                }

                if (element.equals("*")) {
                    int b = resultStack.pop();
                    int a = resultStack.pop();
                    resultStack.push(a * b);
                    continue;
                }

                resultStack.push(Integer.parseInt(element));
            }

            throw new IllegalArgumentException("Некорректное выражение: отсутствует знак '='");
        }
    }
}

/*
Рефлексия по задачам задания 2.
Задача 9. Метод, который "переворачивает" связный список.
Ключевое понимание, которое пришло в процессе: «переворот» — это не перестановка данных, а изменение направления ссылок.
Каждый узел хранит next и prev, и нужно просто поменять их местами у каждого узла по очереди.

Задача 10. Проверка, имеются ли циклы внутри списка.
Решение указанное в рекомендации гораздо проще для чтения и проверки кода: если мы знаем точное количество элементов, то,
сделав соответствующее количество шагов по ссылкам next, мы должны оказаться ровно на узле tail. Если конечным узлом
не будет хвост, значит в списке есть цикл.
Главный вывод: перед тем как применять какой-либо алгоритм, стоит оглянуться на уже имеющиеся данные структуры — иногда
они делают задачу значительно проще.

Задача 11. Сортировка списка.
Размышляя над тем, почему именно сортировка пузырьком лучше подходит для связного списка, я пришел к следующим выводам:
1. Пузырьковая сортировка строится на сравнении соседних элементов. Это хорошо ложится на связной список, где доступ
к данным возможен только последовательно по ссылкам.
2. Сортировка выбором всегда будет делать строго фиксированное количество сравнений, даже если список уже отсортирован.
Сортировка пузырьком допускает раннее завершение — если за очередной проход не произошло ни одной перестановки, список
уже отсортирован и можно остановиться. На частично отсортированных списках пузырек отработает значительно быстрее.

Задача 12. Слияние списков.
Мое решение использует тот же основной принцип, что указан в рекомендации. Главный недостаток моей реализации — жесткая
привязка к двум параметрам: при добавлении новых списков, метод придется либо переписывать, либо вызывать попарно,
что неудобно и неэффективно.

Задача 13. Dummy.
Класс-наследник я сделал правильно, но пользы от него взял мало. В циклах я сравниваю узел с конкретными объектами
dummyHead и dummyTail, хотя достаточно было проверить, что это dummy-узел. Проверка по типу короче, не зависит от того,
сколько именно dummy-узлов в списке.
 */
