// Задача 13.* фиктивный/пустой(dummy) узел.

import java.util.*;

public class LinkedList2_2 {
    private final DummyNode dummyHead;
    private final DummyNode dummyTail;

    public LinkedList2_2()
    {
        dummyHead = new DummyNode(0);
        dummyTail = new DummyNode(0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public Node getHead()
    {
        if (dummyHead.next == dummyTail) {
            return null;
        }

        return dummyHead.next;
    }

    public Node getTail()
    {
        if (dummyTail.prev == dummyHead) {
            return null;
        }

        return dummyTail.prev;
    }

    public void addInTail(Node item)
    {
        if (item == null) {
            return;
        }

        insertBetween(item, dummyTail.prev, dummyTail);
    }

    public Node find(int value)
    {
        for (Node node = dummyHead.next; node != dummyTail; node = node.next) {

            if (node.value == value) {
                return node;
            }
        }

        return null;
    }

    public ArrayList<Node> findAll(int value)
    {
        ArrayList<Node> result = new ArrayList<Node>();

        for (Node node = dummyHead.next; node != dummyTail; node = node.next) {

            if (node.value == value) {
                result.add(node);
            }
        }

        return result;
    }

    public boolean remove(int value)
    {
        Node node = find(value);

        if (node == null) {
            return false;
        }

        removeNode(node);
        return true;
    }

    public void removeAll(int value)
    {
        for (Node node = dummyHead.next;
             node != dummyTail; ) {

            Node nextNode = node.next;

            if (node.value == value) {
                removeNode(node);
            }

            node = nextNode;
        }
    }

    public void clear()
    {
        for (Node node = dummyHead.next; node != dummyTail; ) {

            Node nextNode = node.next;

            node.next = null;
            node.prev = null;

            node = nextNode;
        }

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int count()
    {
        int count = 0;

        for (Node node = dummyHead.next; node != dummyTail; node = node.next) {

            count++;
        }

        return count;
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert)
    {
        if (nodeToInsert == null) {
            return;
        }

        if (nodeAfter == nodeToInsert) {
            return;
        }

        if (nodeAfter == null) {
            insertBetween(nodeToInsert, dummyHead, dummyHead.next);
            return;
        }

        if (!contains(nodeAfter)) {
            return;
        }

        insertBetween(nodeToInsert, nodeAfter, nodeAfter.next);
    }

    private void insertBetween(Node node, Node previous, Node next)
    {
        node.prev = previous;
        node.next = next;

        previous.next = node;
        next.prev = node;
    }

    private void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    private boolean contains(Node searchedNode)
    {
        for (Node node = dummyHead.next; node != dummyTail; node = node.next) {

            if (node == searchedNode) {
                return true;
            }
        }

        return false;
    }

    private static class DummyNode extends Node
    {
        public DummyNode(int value)
        {
            super(value);
        }
    }
}

