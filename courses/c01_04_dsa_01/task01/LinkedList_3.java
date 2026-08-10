import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedList_3 {
    LinkedList list = new LinkedList();

    @Test
    void removeEmptyList() {
        assertFalse(list.remove(23));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeListOf1elementTrue() {
        list.addInTail(new Node(34));
        assertTrue(list.remove(34));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeListOf1elementFalse() {
        list.addInTail(new Node(34));
        assertFalse(list.remove(56));
        assertNotNull(list.head);
        assertNotNull(list.tail);
        assertEquals(34, list.head.value);
        assertEquals(34, list.tail.value);
    }

    @Test
    void removeHeadListOf2elements() {
        Node first = new Node(1);
        Node second = new Node(2);
        list.addInTail(first);
        list.addInTail(second);
        assertTrue(list.remove(1));
        assertSame(second, list.head);
        assertSame(second, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void removeHeadTrue() {
        list.addInTail(new Node(11));
        list.addInTail(new Node(22));
        list.addInTail(new Node(33));
        assertTrue(list.remove(11));
        assertEquals(22, list.head.value);
        assertEquals(33, list.tail.value);
        assertEquals(33, list.head.next.value);
    }

    @Test
    void removeTailTrue() {
        list.addInTail(new Node(14));
        list.addInTail(new Node(29));
        list.addInTail(new Node(38));
        assertTrue(list.remove(38));
        assertEquals(14, list.head.value);
        assertEquals(29, list.tail.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeTailFromTwoElements() {
        Node first = new Node(11);
        Node second = new Node(22);
        list.addInTail(first);
        list.addInTail(second);
        assertTrue(list.remove(22));
        assertSame(first, list.head);
        assertSame(first, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void removeMiddleTrue() {
        list.addInTail(new Node(54));
        list.addInTail(new Node(23));
        list.addInTail(new Node(12));
        assertTrue(list.remove(23));
        assertEquals(54, list.head.value);
        assertEquals(12, list.tail.value);
        assertEquals(12, list.head.next.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeFalse() {
        list.addInTail(new Node(65));
        list.addInTail(new Node(76));
        list.addInTail(new Node(23));
        assertFalse(list.remove(99));
        assertEquals(3, list.count());
        assertEquals(65, list.head.value);
        assertEquals(76, list.head.next.value);
        assertEquals(23, list.head.next.next.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeOnlyFirst() {
        Node first = new Node(5);
        Node second = new Node(5);
        Node third = new Node(7);
        list.addInTail(first);
        list.addInTail(second);
        list.addInTail(third);
        assertTrue(list.remove(5));
        assertEquals(2, list.count());
        assertSame(second, list.head);
        assertSame(third, list.tail);
        assertSame(third, list.head.next);
        assertNull(list.tail.next);
    }

    @Test
    void removeAllEmptyList() {
        list.removeAll(5);
        assertEquals(0, list.count());
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAllListOf1elementAll() {
        list.addInTail(new Node(78));
        list.removeAll(78);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAllListOf1elementNotFound() {
        list.addInTail(new Node(78));
        list.removeAll(65);
        assertNotNull(list.head);
        assertNotNull(list.tail);
        assertEquals(78, list.head.value);
    }

    @Test
    void removeAll() {
        list.addInTail(new Node(45));
        list.addInTail(new Node(45));
        list.addInTail(new Node(45));

        list.removeAll(45);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAllTwiceHead() {
        list.addInTail(new Node(23));
        list.addInTail(new Node(23));
        list.addInTail(new Node(45));
        list.addInTail(new Node(63));
        list.removeAll(23);
        assertEquals(45, list.head.value);
        assertEquals(63, list.tail.value);
    }

    @Test
    void removeAllTwiceTail() {
        list.addInTail(new Node(12));
        list.addInTail(new Node(23));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));

        list.removeAll(1);
        assertEquals(12, list.head.value);
        assertEquals(23, list.tail.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeAllMiddle() {
        list.addInTail(new Node(23));
        list.addInTail(new Node(76));
        list.addInTail(new Node(76));
        list.addInTail(new Node(76));
        list.addInTail(new Node(89));

        list.removeAll(76);
        assertEquals(23, list.head.value);
        assertEquals(89, list.tail.value);
        assertEquals(89, list.head.next.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeAll3elements() {
        list.addInTail(new Node(32));
        list.addInTail(new Node(45));
        list.addInTail(new Node(32));
        list.addInTail(new Node(67));
        list.addInTail(new Node(32));

        list.removeAll(32);
        assertEquals(45, list.head.value);
        assertEquals(67, list.tail.value);
        assertEquals(67, list.head.next.value);
        assertNull(list.tail.next);
    }

    @Test
    void clearEmptyList() {
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void clearListOf1element() {
        list.addInTail(new Node(32));
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void clearListOf3elements() {
        list.addInTail(new Node(34));
        list.addInTail(new Node(45));
        list.addInTail(new Node(56));
        assertEquals(34, list.head.value);
        assertEquals(56, list.tail.value);
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void clearCanAddElementAfterClear() {
        list.addInTail(new Node(32));
        list.clear();
        list.addInTail(new Node(65));
        assertEquals(65, list.head.value);
        assertEquals(65, list.tail.value);
        assertNull(list.tail.next);
    }

    @Test
    void findAllEmptyList(){
        ArrayList<Node> nodes = new ArrayList<>();
        assertEquals(nodes, list.findAll(43));
    }

    @Test
    void findAllListOf1elementFound1() {
        list.addInTail(new Node(56));
        ArrayList<Node> result = list.findAll(56);
        assertEquals(1, result.size());
        assertEquals(56, result.get(0).value);
    }

    @Test
    void findAllListOf1elementFound0() {
        list.addInTail(new Node(48));
        ArrayList<Node> result = list.findAll(12);
        assertTrue(result.isEmpty());
    }

    @Test
    void findAllListOf3elementsFound0() {
        list.addInTail(new Node(48));
        list.addInTail(new Node(58));
        list.addInTail(new Node(78));
        ArrayList<Node> result = list.findAll(12);
        assertTrue(result.isEmpty());
    }

    @Test
    void findAllListOf5elementsFound3() {
        list.addInTail(new Node(52));
        list.addInTail(new Node(12));
        list.addInTail(new Node(52));
        list.addInTail(new Node(18));
        list.addInTail(new Node(52));
        ArrayList<Node> result = list.findAll(52);
        assertEquals(3, result.size());
        assertEquals(52, result.get(0).value);
        assertEquals(52, result.get(1).value);
        assertEquals(52, result.get(2).value);
    }

    @Test
    void findAllListOf3elementsFound2() {
        list.addInTail(new Node(87));
        list.addInTail(new Node(35));
        list.addInTail(new Node(87));

        ArrayList<Node> result = list.findAll(87);
        assertEquals(2, result.size());
        assertEquals(87, result.get(0).value);
        assertEquals(87, result.get(1).value);
    }

    @Test
    void countEmptyList() {
        assertEquals(0, list.count());
    }

    @Test
    void count1element() {
        list.addInTail(new Node(23));
        assertEquals(1, list.count());
    }

    @Test
    void countManyElements() {
        list.addInTail(new Node(34));
        list.addInTail(new Node(23));
        list.addInTail(new Node(54));
        assertEquals(3, list.count());
    }

    @Test
    void countAfterRemove() {
        list.addInTail(new Node(23));
        list.addInTail(new Node(43));
        list.addInTail(new Node(31));
        list.remove(43);
        assertEquals(2, list.count());
    }

    @Test
    void countAfterClear() {
        list.addInTail(new Node(34));
        list.addInTail(new Node(12));
        list.clear();
        assertEquals(0, list.count());
    }

    @Test
    void insertAfterHead() {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        list.addInTail(first);
        list.addInTail(second);
        list.addInTail(third);
        Node newNode = new Node(15);
        list.insertAfter(first, newNode);
        assertEquals(first, list.head);
        assertEquals(third, list.tail);
        assertEquals(10, list.head.value);
        assertEquals(15, list.head.next.value);
        assertEquals(20, list.head.next.next.value);
        assertNull(list.tail.next);
    }

    @Test
    void insertAfterMiddle() {
        Node first = new Node(129);
        Node second = new Node(220);
        Node third = new Node(343);
        list.addInTail(first);
        list.addInTail(second);
        list.addInTail(third);
        Node newNode = new Node(992);
        list.insertAfter(second, newNode);
        assertEquals(129, list.head.value);
        assertEquals(343, list.tail.value);
        assertEquals(992, second.next.value);
        assertEquals(343, second.next.next.value);
    }

    @Test
    void insertAfterTail() {
        list.addInTail(new Node(12));
        Node tailNode = new Node(22);
        list.addInTail(tailNode);
        Node newNode = new Node(32);
        list.insertAfter(tailNode, newNode);
        assertEquals(12, list.head.value);
        assertEquals(32, list.tail.value);
        assertNull(list.tail.next);
        assertEquals(32, list.head.next.next.value);
    }

    @Test
    void insertAfter1element() {
        Node node = new Node(100);
        list.addInTail(node);
        Node newNode = new Node(200);
        list.insertAfter(node, newNode);
        assertEquals(2, list.count());
        assertEquals(node, list.head);
        assertEquals(newNode, list.tail);
        assertEquals(100, list.head.value);
        assertEquals(200, list.head.next.value);
        assertNull(list.tail.next);
    }

    @Test
    void insertAfterNullNodeToInsert() {
        Node first = new Node(10);
        Node second = new Node(20);
        list.addInTail(first);
        list.addInTail(second);
        list.insertAfter(first, null);
        assertEquals(2, list.count());
        assertEquals(first, list.head);
        assertEquals(second, list.tail);
        assertEquals(second, first.next);
        assertNull(list.tail.next);
    }

    @Test
    void insertAfterSameNode() {
        Node first = new Node(10);
        Node second = new Node(20);
        list.addInTail(first);
        list.addInTail(second);
        list.insertAfter(first, first);
        assertEquals(2, list.count());
        assertEquals(first, list.head);
        assertEquals(second, list.tail);
        assertEquals(second, first.next);
        assertNull(list.tail.next);
    }

    @Test
    void insertAfterEmptyList() {
        Node newNode = new Node(10);
        list.insertAfter(null, newNode);
        assertSame(newNode, list.head);
        assertSame(newNode, list.tail);
        assertNull(newNode.next);
        assertEquals(1, list.count());
    }

    @Test
    void insertAfterNullInNotEmptyList() {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        list.addInTail(first);
        list.addInTail(second);
        list.addInTail(third);
        Node newNode = new Node(5);
        list.insertAfter(null, newNode);
        assertEquals(4, list.count());
        assertEquals(5, list.head.value);
        assertEquals(10, list.head.next.value);
        assertEquals(20, list.head.next.next.value);
        assertEquals(30, list.head.next.next.next.value);
        assertEquals(third, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void sumOfTwoEmptyLists() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList result = LinkedList_2.sumOfTwo(list1, list2);
        assertEquals(0, result.count());
        assertNull(result.head);
        assertNull(result.tail);
    }

    @Test
    void sumOfTwo1element() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.addInTail(new Node(36));
        list2.addInTail(new Node(4));
        LinkedList result = LinkedList_2.sumOfTwo(list1, list2);
        assertEquals(1, result.count());
        assertNotNull(result.head);
        assertNotNull(result.tail);
        assertEquals(40, result.head.value);
        assertNull(result.tail.next);
    }

    @Test
    void sumOfTwoManyElements() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.addInTail(new Node(1));
        list1.addInTail(new Node(2));
        list1.addInTail(new Node(3));
        list2.addInTail(new Node(10));
        list2.addInTail(new Node(20));
        list2.addInTail(new Node(30));
        LinkedList result = LinkedList_2.sumOfTwo(list1, list2);
        assertEquals(3, result.count());
        assertEquals(11, result.head.value);
        assertEquals(22, result.head.next.value);
        assertEquals(33, result.head.next.next.value);
        assertEquals(33, result.tail.value);
        assertNull(result.tail.next);
    }

    @Test
    void sumOfTwoTestFalse() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.addInTail(new Node(23));
        list1.addInTail(new Node(34));
        list1.addInTail(new Node(123));
        list2.addInTail(new Node(23));
        list2.addInTail(new Node(12));
        LinkedList result = LinkedList_2.sumOfTwo(list1, list2);
        assertEquals(0, result.count());
        assertNull(result.head);
        assertNull(result.tail);
    }

    @Test
    void sumOfTwoWithNegativeValues() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.addInTail(new Node(-1));
        list1.addInTail(new Node(-2));
        list1.addInTail(new Node(3));
        list2.addInTail(new Node(10));
        list2.addInTail(new Node(-20));
        list2.addInTail(new Node(-3));
        LinkedList result = LinkedList_2.sumOfTwo(list1, list2);
        assertEquals(3, result.count());
        assertEquals(9, result.head.value);
        assertEquals(-22, result.head.next.value);
        assertEquals(0, result.head.next.next.value);
        assertEquals(0, result.tail.value);
        assertNull(result.tail.next);
    }

    @Test
    void sumOfTwoWithZeros() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.addInTail(new Node(0));
        list1.addInTail(new Node(0));
        list1.addInTail(new Node(5));
        list2.addInTail(new Node(0));
        list2.addInTail(new Node(10));
        list2.addInTail(new Node(0));
        LinkedList result = LinkedList_2.sumOfTwo(list1, list2);
        assertEquals(3, result.count());
        assertEquals(0, result.head.value);
        assertEquals(10, result.head.next.value);
        assertEquals(5, result.head.next.next.value);
        assertEquals(5, result.tail.value);
        assertNull(result.tail.next);
    }
}

