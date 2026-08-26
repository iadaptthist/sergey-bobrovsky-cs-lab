import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Deque_3 {
    @Test
    void addFrontEmptyDeque()
    {
        Deque<Integer> deque = new Deque<>();
        assertEquals(0, deque.size());
        deque.addFront(10);
        assertEquals(1, deque.size());
        assertEquals(10, deque.removeFront());
        assertEquals(0, deque.size());
        assertNull(deque.removeFront());
    }

    @Test
    void addFrontAndAddTail()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(20);
        deque.addFront(10);
        assertEquals(2, deque.size());
        assertEquals(10, deque.removeFront());
        assertEquals(20, deque.removeFront());
        assertEquals(0, deque.size());
    }

    @Test
    void addFrontMultipleAdds()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(3, deque.size());
        assertEquals(3, deque.removeFront());
        assertEquals(2, deque.removeFront());
        assertEquals(1, deque.removeFront());
        assertEquals(0, deque.size());
    }

    @Test
    void addFrontAndAddTailTwice()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(5);
        deque.addTail(6);
        deque.addFront(4);
        assertEquals(3, deque.size());
        assertEquals(4, deque.removeFront());
        assertEquals(5, deque.removeFront());
        assertEquals(6, deque.removeFront());
        assertEquals(0, deque.size());
    }

    @Test
    void addTailEmptyDeque()
    {
        Deque<Integer> deque = new Deque<>();
        assertEquals(0, deque.size());
        deque.addTail(10);
        assertEquals(1, deque.size());
        assertEquals(10, deque.removeTail());
        assertEquals(0, deque.size());
        assertNull(deque.removeTail());
    }

    @Test
    void addTailAndAddFront()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(20);
        deque.addTail(30);
        assertEquals(2, deque.size());
        assertEquals(30, deque.removeTail());
        assertEquals(20, deque.removeTail());
        assertEquals(0, deque.size());
    }

    @Test
    void addTailMultipleAdds()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);
        assertEquals(3, deque.size());
        assertEquals(1, deque.removeFront());
        assertEquals(2, deque.removeFront());
        assertEquals(3, deque.removeFront());
        assertEquals(0, deque.size());
    }

    @Test
    void addTailAndAddFrontTwice()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(4);
        deque.addFront(3);
        deque.addTail(5);
        assertEquals(3, deque.size());
        assertEquals(3, deque.removeFront());
        assertEquals(4, deque.removeFront());
        assertEquals(5, deque.removeFront());
        assertEquals(0, deque.size());
    }

    @Test
    void removeFrontEmptyDeque()
    {
        Deque<Integer> deque = new Deque<>();
        assertNull(deque.removeFront());
        assertEquals(0, deque.size());
    }

    @Test
    void removeFront1Element()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(10);
        Integer removed = deque.removeFront();
        assertEquals(10, removed);
        assertEquals(0, deque.size());
        assertNull(deque.removeFront());
    }

    @Test
    void removeFrontMultipleElements()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);
        assertEquals(1, deque.removeFront());
        assertEquals(2, deque.size());
        assertEquals(2, deque.removeFront());
        assertEquals(1, deque.size());
        assertEquals(3, deque.removeFront());
        assertEquals(0, deque.size());
    }

    @Test
    void removeFrontMultipleRemove()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(3);
        deque.addFront(2);
        deque.addFront(1);
        assertEquals(1, deque.removeFront());
        assertEquals(2, deque.removeFront());
        assertEquals(3, deque.removeFront());
        assertNull(deque.removeFront());
    }
    @Test
    void removeTailEmptyDeque()
    {
        Deque<Integer> deque = new Deque<>();
        assertNull(deque.removeTail());
        assertEquals(0, deque.size());
    }

    @Test
    void removeTail1Element()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(10);
        Integer removed = deque.removeTail();
        assertEquals(10, removed);
        assertEquals(0, deque.size());
        assertNull(deque.removeTail());
    }

    @Test
    void removeTailMultipleElements()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(1, deque.removeTail());
        assertEquals(2, deque.size());
        assertEquals(2, deque.removeTail());
        assertEquals(1, deque.size());
        assertEquals(3, deque.removeTail());
        assertEquals(0, deque.size());
    }

    @Test
    void removeTailMultipleRemove()
    {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);
        assertEquals(3, deque.removeTail());
        assertEquals(2, deque.removeTail());
        assertEquals(1, deque.removeTail());
        assertNull(deque.removeTail());
    }

    @Test
    void isPalindromeNullString() {
        assertFalse(Deque_2.isPalindrome(null));
    }

    @Test
    void isPalindromeSingleCharacter() {
        assertTrue(Deque_2.isPalindrome("a"));
    }

    @Test
    void isPalindromeTrue() {
        assertTrue(Deque_2.isPalindrome("abba"));
    }

    @Test
    void isPalindromeFalse() {
        assertFalse(Deque_2.isPalindrome("abca"));
    }

    @Test
    void isPalindromeLongStringTrue() {
        assertTrue(Deque_2.isPalindrome("qwertyytrewq"));
    }

    @Test
    void getMinSingleElement() {
        DequeWithMin deque = new DequeWithMin();
        deque.addFirst(42);
        assertEquals(42, deque.getMin());
    }

    @Test
    void getMinFirstHalfIsUsed() {
        DequeWithMin deque = new DequeWithMin();
        deque.addFirst(10);
        deque.addFirst(3);
        deque.addFirst(7);
        assertEquals(3, deque.getMin());
    }

    @Test
    void getMinSecondHalfIsUsed() {
        DequeWithMin deque = new DequeWithMin();
        deque.addLast(10);
        deque.addLast(3);
        deque.addLast(7);
        assertEquals(3, deque.getMin());
    }

    @Test
    void getMinFirstHalfContainsMinimum() {
        DequeWithMin deque = new DequeWithMin();
        deque.addFirst(1);
        deque.addFirst(5);
        deque.addLast(10);
        deque.addLast(7);
        assertEquals(1, deque.getMin());
    }

    @Test
    void getMinSecondHalfContainsMinimum() {
        DequeWithMin deque = new DequeWithMin();
        deque.addFirst(10);
        deque.addFirst(5);
        deque.addLast(1);
        deque.addLast(7);
        assertEquals(1, deque.getMin());
    }

    @Test
    void getMinWhenMinimumsAreEqual() {
        DequeWithMin deque = new DequeWithMin();
        deque.addFirst(2);
        deque.addLast(2);
        deque.addFirst(5);
        deque.addLast(8);
        assertEquals(2, deque.getMin());
    }

    @Test
    void addFirstAddsElementToFront() {
        DynamicArrayDeque<Integer> deque = new DynamicArrayDeque<>();
        deque.addFirst(10);
        deque.addFirst(20);
        assertEquals(20, deque.removeFirst());
        assertEquals(10, deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    void addLastAddsElementToBack() {
        DynamicArrayDeque<Integer> deque = new DynamicArrayDeque<>();
        deque.addLast(10);
        deque.addLast(20);
        assertEquals(20, deque.removeLast());
        assertEquals(10, deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    void addFirstAndAddLast() {
        DynamicArrayDeque<Integer> deque = new DynamicArrayDeque<>();
        deque.addLast(2);
        deque.addFirst(1);
        deque.addLast(3);
        deque.addFirst(0);
        assertEquals(0, deque.removeFirst());
        assertEquals(1, deque.removeFirst());
        assertEquals(3, deque.removeLast());
        assertEquals(2, deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    void removeFirstRemovesElementFromFront() {
        DynamicArrayDeque<Integer> deque = new DynamicArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(1, deque.removeFirst());
        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.size());
    }

    @Test
    void removeLastRemovesElementFromBack() {
        DynamicArrayDeque<Integer> deque = new DynamicArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.removeLast());
        assertEquals(2, deque.removeLast());
        assertEquals(1, deque.size());
    }
}

