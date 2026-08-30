import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderedList_3 {

    @Test
    void addAscending() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(5);
        assertEquals(5, list.count());
        ArrayList<Node<Integer>> nodes = list.getAll();
        assertEquals(1, nodes.get(0).value);
        assertEquals(2, nodes.get(1).value);
        assertEquals(5, nodes.get(2).value);
        assertEquals(5, nodes.get(3).value);
        assertEquals(8, nodes.get(4).value);
        assertSame(nodes.get(0), list.head);
        assertSame(nodes.get(4), list.tail);
    }

    @Test
    void addDescending() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(5);
        assertEquals(5, list.count());
        ArrayList<Node<Integer>> nodes = list.getAll();
        assertEquals(8, nodes.get(0).value);
        assertEquals(5, nodes.get(1).value);
        assertEquals(5, nodes.get(2).value);
        assertEquals(2, nodes.get(3).value);
        assertEquals(1, nodes.get(4).value);
        assertSame(nodes.get(0), list.head);
        assertSame(nodes.get(4), list.tail);
    }

    @Test
    void deleteAscending() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.delete(3);
        ArrayList<Node<Integer>> nodes = list.getAll();
        assertEquals(4, list.count());
        assertEquals(1, nodes.get(0).value);
        assertEquals(2, nodes.get(1).value);
        assertEquals(4, nodes.get(2).value);
        assertEquals(5, nodes.get(3).value);
        assertNull(nodes.get(0).prev);
        assertSame(nodes.get(0), nodes.get(1).prev);
        assertSame(nodes.get(1), nodes.get(2).prev);
        assertSame(nodes.get(2), nodes.get(3).prev);
        assertNull(nodes.get(3).next);
        list.delete(1);
        assertEquals(3, list.count());
        assertEquals(2, list.head.value);
        list.delete(5);
        assertEquals(2, list.count());
        assertEquals(4, list.tail.value);
    }

    @Test
    void deleteDescending() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.delete(3);
        ArrayList<Node<Integer>> nodes = list.getAll();
        assertEquals(4, list.count());
        assertEquals(5, nodes.get(0).value);
        assertEquals(4, nodes.get(1).value);
        assertEquals(2, nodes.get(2).value);
        assertEquals(1, nodes.get(3).value);
        assertNull(nodes.get(0).prev);
        assertSame(nodes.get(0), nodes.get(1).prev);
        assertSame(nodes.get(1), nodes.get(2).prev);
        assertSame(nodes.get(2), nodes.get(3).prev);
        assertNull(nodes.get(3).next);
        list.delete(5);
        assertEquals(3, list.count());
        assertEquals(4, list.head.value);
        list.delete(1);
        assertEquals(2, list.count());
        assertEquals(2, list.tail.value);
    }

    @Test
    void findAscending() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        Node<Integer> found = list.find(5);
        assertNotNull(found);
        assertEquals(5, found.value);
        assertNull(list.find(6));
        assertNull(list.find(10));
        assertNull(list.find(0));
    }

    @Test
    void findDescending() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(9);
        list.add(7);
        list.add(5);
        list.add(3);
        list.add(1);
        Node<Integer> found = list.find(5);
        assertNotNull(found);
        assertEquals(5, found.value);
        assertNull(list.find(6));
        assertNull(list.find(10));
        assertNull(list.find(0));
    }

    @Test
    void deleteFirstMatchingValue() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(1);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(10);
        list.delete(5);
        assertEquals(4, list.count());
        ArrayList<Node<Integer>> nodes = list.getAll();
        assertEquals(1, nodes.get(0).value);
        assertEquals(5, nodes.get(1).value);
        assertEquals(5, nodes.get(2).value);
        assertEquals(10, nodes.get(3).value);
    }

    @Test
    void deleteMissingValue() {
        OrderedList<Integer> list = new OrderedList<>(false);
        list.add(10);
        list.add(5);
        list.add(1);
        list.delete(7);
        assertEquals(3, list.count());
        assertEquals(10, list.head.value);
        assertEquals(1, list.tail.value);
    }

    @Test
    void removeDuplicatesAscending() {
        OrderedList_2<Integer> list = new OrderedList_2<>(true);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        list.removeDuplicates();
        ArrayList<Node_2<Integer>> nodes = list.getAll();
        assertEquals(4, list.count());
        assertEquals(1, nodes.get(0).value);
        assertEquals(2, nodes.get(1).value);
        assertEquals(3, nodes.get(2).value);
        assertEquals(4, nodes.get(3).value);
        assertSame(list.head, nodes.get(0));
        assertSame(list.tail, nodes.get(3));
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    void removeDuplicatesDescending() {
        OrderedList_2<Integer> list = new OrderedList_2<>(false);
        list.add(4);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(1);
        list.removeDuplicates();
        ArrayList<Node_2<Integer>> nodes = list.getAll();
        assertEquals(4, list.count());
        assertEquals(4, nodes.get(0).value);
        assertEquals(3, nodes.get(1).value);
        assertEquals(2, nodes.get(2).value);
        assertEquals(1, nodes.get(3).value);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    void removeDuplicatesWhenAllElementsAreEqual() {
        OrderedList_2<Integer> list = new OrderedList_2<>(true);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.removeDuplicates();
        assertEquals(1, list.count());
        assertEquals(5, list.head.value);
        assertSame(list.head, list.tail);
        assertNull(list.head.prev);
        assertNull(list.head.next);
    }

    @Test
    void removeDuplicatesEmptyList() {
        OrderedList_2<Integer> list = new OrderedList_2<>(true);
        list.removeDuplicates();
        assertEquals(0, list.count());
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void mergeAscendingLists() {
        OrderedList_2<Integer> first = new OrderedList_2<>(true);
        OrderedList_2<Integer> second = new OrderedList_2<>(true);
        first.add(1);
        first.add(3);
        first.add(5);
        first.add(7);
        second.add(2);
        second.add(4);
        second.add(6);
        second.add(8);
        OrderedList_2<Integer> result = first.merge(second);
        ArrayList<Node_2<Integer>> nodes = result.getAll();
        assertEquals(8, result.count());
        assertEquals(1, nodes.get(0).value);
        assertEquals(2, nodes.get(1).value);
        assertEquals(3, nodes.get(2).value);
        assertEquals(4, nodes.get(3).value);
        assertEquals(5, nodes.get(4).value);
        assertEquals(6, nodes.get(5).value);
        assertEquals(7, nodes.get(6).value);
        assertEquals(8, nodes.get(7).value);
        assertTrue(result._ascending);
        assertNull(result.head.prev);
        assertNull(result.tail.next);
    }

    @Test
    void mergeDescendingLists() {
        OrderedList_2<Integer> first = new OrderedList_2<>(false);
        OrderedList_2<Integer> second = new OrderedList_2<>(false);
        first.add(8);
        first.add(6);
        first.add(4);
        first.add(2);
        second.add(7);
        second.add(5);
        second.add(3);
        second.add(1);
        OrderedList_2<Integer> result = first.merge(second);
        ArrayList<Node_2<Integer>> nodes = result.getAll();
        assertEquals(8, result.count());
        assertEquals(8, nodes.get(0).value);
        assertEquals(7, nodes.get(1).value);
        assertEquals(6, nodes.get(2).value);
        assertEquals(5, nodes.get(3).value);
        assertEquals(4, nodes.get(4).value);
        assertEquals(3, nodes.get(5).value);
        assertEquals(2, nodes.get(6).value);
        assertEquals(1, nodes.get(7).value);
        assertFalse(result._ascending);
        assertNull(result.head.prev);
        assertNull(result.tail.next);
    }

    @Test
    void mergeAscendingListsWithDuplicates() {
        OrderedList_2<Integer> first = new OrderedList_2<>(true);
        OrderedList_2<Integer> second = new OrderedList_2<>(true);
        first.add(1);
        first.add(2);
        first.add(3);
        second.add(2);
        second.add(3);
        second.add(4);
        OrderedList_2<Integer> result = first.merge(second);
        ArrayList<Node_2<Integer>> nodes = result.getAll();
        assertEquals(6, result.count());
        assertEquals(1, nodes.get(0).value);
        assertEquals(2, nodes.get(1).value);
        assertEquals(2, nodes.get(2).value);
        assertEquals(3, nodes.get(3).value);
        assertEquals(3, nodes.get(4).value);
        assertEquals(4, nodes.get(5).value);
    }

    @Test
    void mergeWithEmptyList() {
        OrderedList_2<Integer> first = new OrderedList_2<>(true);
        OrderedList_2<Integer> second = new OrderedList_2<>(true);
        first.add(1);
        first.add(2);
        first.add(3);
        OrderedList_2<Integer> result = first.merge(second);
        assertEquals(3, result.count());
        ArrayList<Node_2<Integer>> nodes = result.getAll();
        assertEquals(1, nodes.get(0).value);
        assertEquals(2, nodes.get(1).value);
        assertEquals(3, nodes.get(2).value);
    }

    @Test
    void containsSublistAscending() {
        OrderedList_2<Integer> list = new OrderedList_2<>(true);
        OrderedList_2<Integer> sublist = new OrderedList_2<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        sublist.add(2);
        sublist.add(3);
        sublist.add(4);
        assertTrue(list.containsSublist(sublist));
    }

    @Test
    void containsSublistDescending() {
        OrderedList_2<Integer> list = new OrderedList_2<>(false);
        OrderedList_2<Integer> sublist = new OrderedList_2<>(false);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        sublist.add(4);
        sublist.add(3);
        sublist.add(2);
        assertTrue(list.containsSublist(sublist));
    }

    @Test
    void containsSublistAtBeginningAscending() {
        OrderedList_2<Integer> list = new OrderedList_2<>(true);
        OrderedList_2<Integer> sublist = new OrderedList_2<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        sublist.add(1);
        sublist.add(2);
        assertTrue(list.containsSublist(sublist));
    }

    @Test
    void containsSublistAtEndDescending() {
        OrderedList_2<Integer> list = new OrderedList_2<>(false);
        OrderedList_2<Integer> sublist = new OrderedList_2<>(false);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        sublist.add(2);
        sublist.add(1);
        assertTrue(list.containsSublist(sublist));
    }

    @Test
    void doesNotContainSublistAscending() {
        OrderedList_2<Integer> list = new OrderedList_2<>(true);
        OrderedList_2<Integer> sublist = new OrderedList_2<>(true);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        sublist.add(2);
        sublist.add(3);
        assertFalse(list.containsSublist(sublist));
    }

    @Test
    void findMostFrequentAscending() {
        OrderedList_2<Integer> list = new OrderedList_2<>(true);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        assertEquals(3, list.findMostFrequent());
    }

    @Test
    void findMostFrequentDescending() {
        OrderedList_2<Integer> list = new OrderedList_2<>(false);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        assertEquals(3, list.findMostFrequent());
    }

    @Test
    void findMostFrequentWhenAllValuesAreEqual() {
        OrderedList_2<Integer> list = new OrderedList_2<>(true);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        assertEquals(7, list.findMostFrequent());
    }

    @Test
    void findMostFrequentWhenAllValuesAreUnique() {
        OrderedList_2<Integer> list = new OrderedList_2<>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(1, list.findMostFrequent());
    }

    @Test
    void findMostFrequentEmptyList() {
        OrderedList_2<Integer> list = new OrderedList_2<>(true);
        assertNull(list.findMostFrequent());
    }
}

