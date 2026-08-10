// Задание 1. Связный (связанный) список;
// Задача 8.* Вернуть список, каждый элемент которого равен сумме соответствующих элементов входных списков;
// Сложность по времени: O(n²);
// Сложность по памяти: O(n).

import java.util.*;

public class LinkedList_2 {
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

