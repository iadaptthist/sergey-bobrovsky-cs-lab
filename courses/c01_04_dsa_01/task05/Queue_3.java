import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Queue_3 {
    @Test
    void queueEnqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        assertEquals(1, queue.size());
    }

    @Test
    void queueDequeueSingleElement() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        assertEquals(10, queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void queueDequeueSeveralElements() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
    }

    @Test
    void queueDequeueEmptyQueue() {
        Queue<Integer> queue = new Queue<>();
        assertNull(queue.dequeue());
    }

    @Test
    void queueDequeueDecreaseSize() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    void queueMixedOperations() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        queue.enqueue(3);
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void rotateEmptyQueue() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.rotate(3);
        assertEquals(0, queue.size());
        assertNull(queue.dequeue());
    }

    @Test
    void rotateSingleElementQueue() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(10);
        queue.rotate(3);
        assertEquals(10, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void rotateWithZero() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.rotate(0);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void rotateMoveOneElement() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.rotate(1);
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void rotateMoveTwoElements() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.rotate(2);
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void rotateMoveSizeElements() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.rotate(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void rotateMoveMoreThanSize() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.rotate(4);
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void queueFromStacksEnqueue() {
        QueueFromStacks<Integer> queue = new QueueFromStacks<>();
        queue.enqueue(10);
        assertEquals(1, queue.size());
    }

    @Test
    void queueFromStacksDequeueSingleElement() {
        QueueFromStacks<Integer> queue = new QueueFromStacks<>();
        queue.enqueue(10);
        assertEquals(10, queue.dequeue());
        assertEquals(0, queue.size());
        assertNull(queue.dequeue());
    }

    @Test
    void queueFromStacksDequeue() {
        QueueFromStacks<Integer> queue = new QueueFromStacks<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void queueFromStacksDequeueEmptyQueue() {
        QueueFromStacks<Integer> queue = new QueueFromStacks<>();
        assertNull(queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void queueFromStacksSize() {
        QueueFromStacks<Integer> queue = new QueueFromStacks<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    void reverseEmptyQueue() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.reverse();
        assertEquals(0, queue.size());
        assertNull(queue.dequeue());
    }

    @Test
    void reverseSingleElementQueue() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(10);
        queue.reverse();
        assertEquals(10, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void reverseTwoElements() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.reverse();
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void reverseThreeElements() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.reverse();
        assertEquals(3, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void reverseFourElements() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.reverse();
        assertEquals(4, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void reverseMixedOperations() {
        Queue_2<Integer> queue = new Queue_2<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        queue.reverse();
        assertEquals(5, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void circularQueueEnqueue() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(1, queue.getCountElements());
    }

    @Test
    void circularQueueDequeue() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.enqueue(10);
        assertEquals(10, queue.dequeue());
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getCountElements());
    }

    @Test
    void circularQueueDequeueEmptyQueue() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        assertThrows(IllegalStateException.class, queue::dequeue);
    }
    @Test
    void circularQueueEnqueueWhenQueueIsFull() {
        CircularQueue<Integer> queue = new CircularQueue<>(2);
        queue.enqueue(10);
        queue.enqueue(20);
        assertTrue(queue.isFull());
        assertThrows(IllegalStateException.class, () -> queue.enqueue(30));
    }

    @Test
    void circularQueueQueueSeveralElements() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void circularQueueMixedOperations() {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(4);
        assertTrue(queue.isFull());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}

