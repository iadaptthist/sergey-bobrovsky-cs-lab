import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedList2_3 {
    LinkedList2 list = new LinkedList2();

    @Test
    void findInEmptyList() {
        Node result = list.find(58);
        assertNull(result);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void findIn1elementListFound() {
        Node node = new Node(74);
        list.addInTail(node);
        Node result = list.find(74);
        assertSame(node, result);
        assertSame(node, list.head);
        assertSame(node, list.tail);
        assertNull(node.next);
        assertNull(node.prev);
    }

    @Test
    void findIn1elementListNotFound() {
        Node node = new Node(42);
        list.addInTail(node);
        Node result = list.find(74);
        assertNull(result);
        assertSame(node, list.head);
        assertSame(node, list.tail);
        assertNull(node.next);
        assertNull(node.prev);
    }

    @Test
    void findInHeadFound() {
        Node node1 = new Node(85);
        Node node2 = new Node(26);
        Node node3 = new Node(95);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        Node result = list.find(85);
        assertSame(node1, result);
        assertSame(node1, list.head);
        assertSame(node3, list.tail);
        assertNull(node1.prev);
        assertSame(node2, node1.next);
        assertSame(node1, node2.prev);
        assertSame(node3, node2.next);
        assertSame(node2, node3.prev);
        assertNull(node3.next);
    }

    @Test
    void findInMiddleFound() {
        Node node1 = new Node(36);
        Node node2 = new Node(12);
        Node node3 = new Node(63);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        Node result = list.find(12);
        assertSame(node2, result);
        assertSame(node1, list.head);
        assertSame(node3, list.tail);
        assertNull(node1.prev);
        assertSame(node2, node1.next);
        assertSame(node1, node2.prev);
        assertSame(node3, node2.next);
        assertSame(node2, node3.prev);
        assertNull(node3.next);
    }

    @Test
    void findInTailFound() {
        Node node1 = new Node(65);
        Node node2 = new Node(89);
        Node node3 = new Node(78);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        Node result = list.find(78);
        assertSame(node3, result);
        assertSame(node1, list.head);
        assertSame(node3, list.tail);
        assertNull(node1.prev);
        assertSame(node2, node1.next);
        assertSame(node1, node2.prev);
        assertSame(node3, node2.next);
        assertSame(node2, node3.prev);
        assertNull(node3.next);
    }

    @Test
    void findInManyElementsListNotFound() {
        Node node1 = new Node(48);
        Node node2 = new Node(32);
        Node node3 = new Node(89);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        Node result = list.find(15);
        assertNull(result);
        assertSame(node1, list.head);
        assertSame(node3, list.tail);
        assertNull(node1.prev);
        assertSame(node2, node1.next);
        assertSame(node1, node2.prev);
        assertSame(node3, node2.next);
        assertSame(node2, node3.prev);
        assertNull(node3.next);
    }

    @Test
    void findInSomeIdenticalValues() {
        Node node1 = new Node(65);
        Node node2 = new Node(15);
        Node node3 = new Node(65);
        Node node4 = new Node(26);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        Node result = list.find(65);
        assertSame(node1, result);
        assertNotSame(node3, result);
        assertSame(node1, list.head);
        assertSame(node4, list.tail);
        assertNull(node1.prev);
        assertSame(node2, node1.next);
        assertSame(node1, node2.prev);
        assertSame(node3, node2.next);
        assertSame(node2, node3.prev);
        assertSame(node4, node3.next);
        assertSame(node3, node4.prev);
        assertNull(node4.next);
    }

    @Test
    void findAllInEmptyList() {
        ArrayList<Node> result = list.findAll(10);
        assertTrue(result.isEmpty());
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void findAllIn1elementListFound() {
        Node node = new Node(45);
        list.addInTail(node);
        ArrayList<Node> result = list.findAll(45);
        assertEquals(1, result.size());
        assertSame(node, result.get(0));
        assertSame(node, list.head);
        assertSame(node, list.tail);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    void findAllIn1elementListNotFound() {
        Node node = new Node(74);
        list.addInTail(node);
        ArrayList<Node> result = list.findAll(58);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        assertSame(node, list.head);
        assertSame(node, list.tail);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    void findAllInManyElementsFound() {
        Node node1 = new Node(56);
        Node node2 = new Node(72);
        Node node3 = new Node(78);
        Node node4 = new Node(45);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        ArrayList<Node> result = list.findAll(78);
        assertEquals(1, result.size());
        assertSame(node3, result.get(0));
        assertSame(node1, list.head);
        assertSame(node4, list.tail);
        assertNull(node1.prev);
        assertSame(node2, node1.next);
        assertSame(node1, node2.prev);
        assertSame(node3, node2.next);
        assertSame(node2, node3.prev);
        assertSame(node4, node3.next);
        assertSame(node3, node4.prev);
        assertNull(node4.next);
    }

    @Test
    void findAllInManyElementsFoundSome() {
        Node node1 = new Node(85);
        Node node2 = new Node(78);
        Node node3 = new Node(85);
        Node node4 = new Node(36);
        Node node5 = new Node(85);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);
        ArrayList<Node> result = list.findAll(85);
        assertEquals(3, result.size());
        assertSame(node1, result.get(0));
        assertSame(node3, result.get(1));
        assertSame(node5, result.get(2));
        assertSame(node1, list.head);
        assertSame(node5, list.tail);
        assertNull(node1.prev);
        assertSame(node2, node1.next);
        assertSame(node1, node2.prev);
        assertSame(node3, node2.next);
        assertSame(node2, node3.prev);
        assertSame(node4, node3.next);
        assertSame(node3, node4.prev);
        assertSame(node5, node4.next);
        assertSame(node4, node5.prev);
        assertNull(node5.next);
    }

    @Test
    void findAllInManyElementsNotFound() {
        Node node1 = new Node(74);
        Node node2 = new Node(25);
        Node node3 = new Node(45);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        ArrayList<Node> result = list.findAll(96);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        assertSame(node1, list.head);
        assertSame(node3, list.tail);
        assertNull(node1.prev);
        assertSame(node2, node1.next);
        assertSame(node1, node2.prev);
        assertSame(node3, node2.next);
        assertSame(node2, node3.prev);
        assertNull(node3.next);
    }

    @Test
    void findAllInIdenticalValuesListFound() {
        Node node1 = new Node(45);
        Node node2 = new Node(45);
        Node node3 = new Node(45);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        ArrayList<Node> result = list.findAll(45);
        assertEquals(3, result.size());
        assertSame(node1, result.get(0));
        assertSame(node2, result.get(1));
        assertSame(node3, result.get(2));
    }

    @Test
    void removeFromEmptyListFalse() {
        boolean result = list.remove(85);
        assertFalse(result);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void remove1elementListTrue() {
        list.addInTail(new Node(74));
        boolean result = list.remove(74);
        assertTrue(result);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeHeadTrue() {
        list.addInTail(new Node(96));
        list.addInTail(new Node(285));
        list.addInTail(new Node(23));
        boolean result = list.remove(96);
        assertTrue(result);
        assertEquals(285, list.head.value);
        assertEquals(23, list.tail.value);
        assertNull(list.head.prev);
        assertEquals(23, list.head.next.value);
        assertEquals(285, list.tail.prev.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeTailTrue() {
        list.addInTail(new Node(25));
        list.addInTail(new Node(45));
        list.addInTail(new Node(63));
        boolean result = list.remove(63);
        assertTrue(result);
        assertEquals(25, list.head.value);
        assertEquals(45, list.tail.value);
        assertNull(list.head.prev);
        assertEquals(45, list.head.next.value);
        assertEquals(25, list.tail.prev.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeMiddleTrue() {
        list.addInTail(new Node(78));
        list.addInTail(new Node(65));
        list.addInTail(new Node(36));
        list.addInTail(new Node(63));
        boolean result = list.remove(65);
        assertTrue(result);
        assertEquals(78, list.head.value);
        assertEquals(63, list.tail.value);
        assertEquals(36, list.head.next.value);
        assertEquals(78, list.head.next.prev.value);
        assertEquals(63, list.head.next.next.value);
        assertEquals(36, list.tail.prev.value);
    }

    @Test
    void removeFalse() {
        list.addInTail(new Node(96));
        list.addInTail(new Node(85));
        list.addInTail(new Node(74));
        boolean result = list.remove(23);
        assertFalse(result);
        assertEquals(96, list.head.value);
        assertEquals(74, list.tail.value);
        assertNull(list.head.prev);
        assertEquals(85, list.head.next.value);
        assertEquals(96, list.head.next.prev.value);
        assertEquals(74, list.head.next.next.value);
        assertEquals(85, list.tail.prev.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeFirstOfDuplicatesTrue() {
        list.addInTail(new Node(12));
        list.addInTail(new Node(52));
        list.addInTail(new Node(52));
        list.addInTail(new Node(41));
        boolean result = list.remove(52);
        assertTrue(result);
        assertEquals(12, list.head.value);
        assertEquals(41, list.tail.value);
        assertEquals(52, list.head.next.value);
        assertEquals(12, list.head.next.prev.value);
        assertEquals(41, list.head.next.next.value);
        assertEquals(52, list.tail.prev.value);
    }

    @Test
    void removeAllFromEmptyList() {
        list.removeAll(74);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAll1elementList() {
        list.addInTail(new Node(10));
        list.removeAll(10);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAll1elementListNotFound() {
        list.addInTail(new Node(10));
        list.removeAll(85);
        assertNotNull(list.head);
        assertNotNull(list.tail);
        assertSame(list.head, list.tail);
        assertEquals(10, list.head.value);
        assertNull(list.head.prev);
        assertNull(list.head.next);
    }

    @Test
    void removeAllTwiceHead() {
        list.addInTail(new Node(96));
        list.addInTail(new Node(96));
        list.addInTail(new Node(41));
        list.addInTail(new Node(52));
        list.addInTail(new Node(63));
        list.removeAll(96);
        assertEquals(41, list.head.value);
        assertNull(list.head.prev);
        assertEquals(63, list.tail.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeAllTwiceTail() {
        list.addInTail(new Node(12));
        list.addInTail(new Node(45));
        list.addInTail(new Node(85));
        list.addInTail(new Node(63));
        list.addInTail(new Node(63));
        list.removeAll(63);
        assertEquals(12, list.head.value);
        assertNull(list.head.prev);
        assertEquals(85, list.tail.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeAllTwiceFromMiddle() {
        list.addInTail(new Node(41));
        list.addInTail(new Node(12));
        list.addInTail(new Node(96));
        list.addInTail(new Node(96));
        list.addInTail(new Node(45));
        list.addInTail(new Node(74));
        list.removeAll(96);
        assertEquals(41, list.head.value);
        assertNull(list.head.prev);
        assertEquals(74, list.tail.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeAllFromDifferentPositions() {
        list.addInTail(new Node(78));
        list.addInTail(new Node(52));
        list.addInTail(new Node(78));
        list.addInTail(new Node(63));
        list.addInTail(new Node(78));
        list.addInTail(new Node(25));
        list.addInTail(new Node(78));
        list.removeAll(78);
        assertEquals(52, list.head.value);
        assertNull(list.head.prev);
        assertEquals(25, list.tail.value);
        assertNull(list.tail.next);
    }

    @Test
    void removeAll() {
        list.addInTail(new Node(36));
        list.addInTail(new Node(36));
        list.addInTail(new Node(36));
        list.addInTail(new Node(36));
        list.removeAll(36);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAllNotFound() {
        list.addInTail(new Node(14));
        list.addInTail(new Node(25));
        list.addInTail(new Node(36));
        list.addInTail(new Node(47));
        list.removeAll(56);
        assertEquals(14, list.head.value);
        assertNull(list.head.prev);
        assertEquals(47, list.tail.value);
        assertNull(list.tail.next);
    }

    @Test
    void insertAfterEmptyList() {
        Node node = new Node(10);
        list.insertAfter(null, node);
        assertSame(node, list.head);
        assertSame(node, list.tail);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    void insertAfterInsertToHead() {
        Node first = new Node(25);
        Node second = new Node(36);
        list.addInTail(first);
        list.addInTail(second);
        Node third = new Node(85);
        list.insertAfter(null, third);
        assertSame(third, list.head);
        assertSame(second, list.tail); 
    }

    @Test
    void insertAfterHead() {
        Node first = new Node(25);
        Node second = new Node(36);
        list.addInTail(first);
        list.addInTail(second);
        Node nodeAfter = list.head;
        Node nodeToInsert = new Node(74);
        list.insertAfter(nodeAfter, nodeToInsert);
        assertSame(nodeAfter, nodeToInsert.prev);
        assertSame(list.tail, nodeToInsert.next);
        assertSame(nodeToInsert, nodeAfter.next);
        assertSame(nodeToInsert, list.tail.prev);
    }

    @Test
    void insertAfterTail() {
        Node first = new Node(96);
        Node second = new Node(45);
        list.addInTail(first);
        list.addInTail(second);
        Node oldTail = list.tail;
        Node nodeToInsert = new Node(36);
        list.insertAfter(oldTail, nodeToInsert);
        assertSame(nodeToInsert, list.tail);
        assertSame(oldTail, nodeToInsert.prev);
        assertNull(nodeToInsert.next);
        assertSame(nodeToInsert, oldTail.next);
    }

    @Test
    void insertAfterInMiddle() {
        Node first = new Node(23);
        Node second = new Node(45);
        Node third = new Node(63);
        Node fourth = new Node(35);
        list.addInTail(first);
        list.addInTail(second);
        list.addInTail(third);
        list.addInTail(fourth);
        Node nodeAfter = list.find(45);
        Node nodeToInsert = new Node(75);
        list.insertAfter(nodeAfter, nodeToInsert);
        assertSame(nodeAfter, nodeToInsert.prev);
        assertEquals(63, nodeToInsert.next.value);
        assertSame(nodeToInsert, nodeAfter.next);
        assertSame(nodeToInsert, nodeToInsert.next.prev);
    }

    @Test
    void insertAfter1elementListAtBeginning() {
        Node first = new Node(53);
        list.addInTail(first);
        Node nodeToInsert = new Node(15);
        list.insertAfter(null, nodeToInsert);
        assertSame(nodeToInsert, list.head);
        assertEquals(53, list.tail.value);
        assertSame(list.tail, nodeToInsert.next);
        assertSame(nodeToInsert, list.tail.prev);
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
    void reverseEmptyList() {
        assertNull(list.head);
        assertNull(list.tail);
        list.reverse();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void reverse1elementList() {
        list.addInTail(new Node(53));
        Node originalHead = list.head;
        Node originalTail = list.tail;
        assertSame(originalHead, originalTail);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
        list.reverse();
        assertSame(originalHead, list.head);
        assertSame(originalTail, list.tail);
        assertSame(list.head, list.tail);
        assertEquals(53, list.head.value);
        assertNull(list.head.prev);
        assertNull(list.head.next);
    }

    @Test
    void reverseManyElements() {
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));
        list.addInTail(new Node(5));
        Node oldHead = list.head;
        Node oldTail = list.tail;
        assertEquals(1, oldHead.value);
        assertEquals(5, oldTail.value);
        list.reverse();
        assertSame(oldTail, list.head);
        assertSame(oldHead, list.tail);
        assertEquals(5, list.head.value);
        assertEquals(1, list.tail.value);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    void reverseTwice() {
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        Node originalHead = list.head;
        Node originalTail = list.tail;
        assertEquals(1, originalHead.value);
        assertEquals(3, originalTail.value);
        list.reverse();
        assertSame(originalTail, list.head);
        assertSame(originalHead, list.tail);
        assertEquals(3, list.head.value);
        assertEquals(1, list.tail.value);
        list.reverse();
        assertSame(originalHead, list.head);
        assertSame(originalTail, list.tail);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    void reverseEmptyListAfterReverse() {
        list.reverse();
        list.addInTail(new Node(100));
        assertNotNull(list.head);
        assertNotNull(list.tail);
        assertSame(list.head, list.tail);
        assertEquals(100, list.head.value);
        assertNull(list.head.prev);
        assertNull(list.head.next);
    }

    @Test
    void hasCycleEmptyListFalse() {
        assertFalse(list.hasCycle());
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void hasCycle1elementListFalse() {
        Node node = new Node(185);
        list.addInTail(node);
        assertFalse(list.hasCycle());
        assertSame(node, list.head);
        assertSame(node, list.tail);
        assertNull(list.head.next);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
        assertNull(list.tail.prev);
    }

    @Test
    void hasCycle1elementListTrue() {
        Node node = new Node(174);
        list.addInTail(node);
        node.next = node;
        assertTrue(list.hasCycle());
        assertSame(node, list.head);
        assertSame(node, list.tail);
        assertSame(node, node.next);
    }

    @Test
    void hasCycle2elementsListFalse() {
        Node node1 = new Node(87);
        Node node2 = new Node(23);
        list.addInTail(node1);
        list.addInTail(node2);
        assertFalse(list.hasCycle());
        assertSame(node1, list.head);
        assertSame(node2, list.tail);
        assertSame(node2, node1.next);
        assertNull(node1.prev);
        assertNull(node2.next);
        assertSame(node1, node2.prev);
    }

    @Test
    void hasCycleManyElementsTrue() {
        Node node1 = new Node(26);
        Node node2 = new Node(48);
        Node node3 = new Node(79);
        Node node4 = new Node(46);
        Node node5 = new Node(13);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);
        node5.next = node1;
        assertTrue(list.hasCycle());
        assertSame(node1, list.head);
        assertSame(node5, list.tail);
        assertSame(node1, node5.next);
    }

    @Test
    void sortInAscendingOrderEmptyList() {
        list.sortInAscendingOrder();
        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(0, list.count());
    }

    @Test
    void sortInAscendingOrder1elementList() {
        Node node = new Node(85);
        list.addInTail(node);
        list.sortInAscendingOrder();
        assertSame(node, list.head);
        assertSame(node, list.tail);
        assertEquals(85, node.value);
        assertNull(node.prev);
        assertNull(node.next);
        assertEquals(1, list.count());
    }

    @Test
    void sortInAscendingOrderManyElements() {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(1);
        Node node5 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);
        list.sortInAscendingOrder();
        assertSame(node1, list.head);
        assertSame(node5, list.tail);
        assertEquals(1, node1.value);
        assertEquals(2, node2.value);
        assertEquals(3, node3.value);
        assertEquals(4, node4.value);
        assertEquals(5, node5.value);
        assertSame(node2, node1.next);
        assertSame(node3, node2.next);
        assertSame(node4, node3.next);
        assertSame(node5, node4.next);
        assertNull(node5.next);
        assertNull(node1.prev);
        assertSame(node1, node2.prev);
        assertSame(node2, node3.prev);
        assertSame(node3, node4.prev);
        assertSame(node4, node5.prev);
        assertEquals(5, list.count());
    }

    @Test
    void sortInAscendingAlreadySortedListAscending() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.sortInAscendingOrder();
        assertSame(node1, list.head);
        assertSame(node4, list.tail);
        assertEquals(1, node1.value);
        assertEquals(2, node2.value);
        assertEquals(3, node3.value);
        assertEquals(4, node4.value);
        assertNull(node1.prev);
        assertSame(node2, node1.next);
        assertSame(node1, node2.prev);
        assertSame(node3, node2.next);
        assertSame(node2, node3.prev);
        assertSame(node4, node3.next);
        assertSame(node3, node4.prev);
        assertNull(node4.next);
    }

    @Test
    public void sortInAscendingOrderAlreadySortedListDescending() {
        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);
        list.sortInAscendingOrder();
        assertEquals(1, node1.value);
        assertEquals(2, node2.value);
        assertEquals(3, node3.value);
        assertEquals(4, node4.value);
        assertEquals(5, node5.value);
        assertSame(node1, list.head);
        assertSame(node5, list.tail);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void sortInAscendingOrderDuplicateValues() {
        Node node1 = new Node(3);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);
        list.sortInAscendingOrder();
        assertEquals(1, node1.value);
        assertEquals(1, node2.value);
        assertEquals(2, node3.value);
        assertEquals(3, node4.value);
        assertEquals(3, node5.value);
        assertSame(node1, list.head);
        assertSame(node5, list.tail);
        assertNull(node1.prev);
        assertSame(node1, node2.prev);
        assertSame(node2, node3.prev);
        assertSame(node3, node4.prev);
        assertSame(node4, node5.prev);
        assertNull(node5.next);
    }

    @Test
    void sortAndMergeListsEmptyListNull() {
        LinkedList2 result = LinkedList2.sortAndMergeLists(null, null);
        assertNotNull(result);
        assertNull(result.head);
        assertNull(result.tail);
    }

    @Test
    void sortAndMergeListsEmptyList() {
        LinkedList2 firstList = new LinkedList2();
        LinkedList2 secondList = new LinkedList2();
        LinkedList2 result = LinkedList2.sortAndMergeLists(firstList, secondList);
        assertNotNull(result);
        assertNull(result.head);
        assertNull(result.tail);
    }

   @Test
   void sortAndMergeLists1elementList() {
       Node node1 = new Node(2);
       Node node2 = new Node(1);
       LinkedList2 firstList = new LinkedList2();
       firstList.addInTail(node1);
       LinkedList2 secondList = new LinkedList2();
       secondList.addInTail(node2);
       LinkedList2 result = LinkedList2.sortAndMergeLists(firstList, secondList);
       assertNotNull(result);
       assertEquals(1, result.head.value);
       assertEquals(2, result.tail.value);
       assertSame(result.tail, result.head.next);
       assertSame(result.head, result.tail.prev);
       assertNull(result.head.prev);
       assertNull(result.tail.next);
    }

    @Test
    void sortAndMergeListsOneListIsEmpty() {
        LinkedList2 firstList = new LinkedList2();
        LinkedList2 secondList = new LinkedList2();
        secondList.addInTail(new Node(5));
        secondList.addInTail(new Node(1));
        secondList.addInTail(new Node(3));
        LinkedList2 result = LinkedList2.sortAndMergeLists(firstList, secondList);
        assertNotNull(result);
        assertEquals(1, result.head.value);
        assertEquals(3, result.head.next.value);
        assertEquals(5, result.tail.value);
        assertNull(result.head.prev);
        assertSame(result.head, result.head.next.prev);
        assertSame(result.head.next, result.tail.prev);
        assertNull(result.tail.next);
    }
}

