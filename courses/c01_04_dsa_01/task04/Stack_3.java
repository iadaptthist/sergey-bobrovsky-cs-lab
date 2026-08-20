import org.junit.jupiter.api.Test;

import static c01_04_dsa_01.task04.Stack_2.*;

import static org.junit.jupiter.api.Assertions.*;

public class Stack_3 {
    @Test
    void pushOneElement() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void pushSeveralElements() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    void pushAndPop() {
        Stack<Integer> stack = new Stack<>();
        assertEquals(0, stack.size());
        stack.push(5);
        assertEquals(1, stack.size());
        stack.push(7);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void isBalancedTask5EmptyString() {
        assertTrue(isBracketSequenceBalancedTask5(""));
    }

    @Test
    void isBalancedTask5SingleOpeningBracket() {
        assertFalse(isBracketSequenceBalancedTask5("("));
        assertFalse(isBracketSequenceBalancedTask5("{"));
        assertFalse(isBracketSequenceBalancedTask5("["));
    }

    @Test
    void isBalancedTask5BalancedSequences() {
        assertTrue(isBracketSequenceBalancedTask5("()"));
        assertTrue(isBracketSequenceBalancedTask5("{}"));
        assertTrue(isBracketSequenceBalancedTask5("[]"));
    }

    @Test
    void isBalancedTask5SeveralBalancedSequences() {
        assertTrue(isBracketSequenceBalancedTask5("({[]})"));
        assertTrue(isBracketSequenceBalancedTask5("[({})]"));
        assertTrue(isBracketSequenceBalancedTask5("(({{[[]]}}))"));
    }

    @Test
    void isBalancedTask5UnbalancedSequences() {
        assertFalse(isBracketSequenceBalancedTask5("("));
        assertFalse(isBracketSequenceBalancedTask5("(()"));
        assertFalse(isBracketSequenceBalancedTask5("())"));
        assertFalse(isBracketSequenceBalancedTask5("([)]"));
        assertFalse(isBracketSequenceBalancedTask5("({])"));
        assertFalse(isBracketSequenceBalancedTask5("(()}"));
    }

    @Test
    void stackWithMinPush1Element() {
        StackWithMin stack = new StackWithMin();
        stack.push(5);
        assertEquals(5, stack.peek());
        assertEquals(5, stack.getMin());
    }

    @Test
    void stackWithMinPushSeveralElements() {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(7);
        stack.push(2);
        stack.push(9);
        assertEquals(9, stack.peek());
        assertEquals(2, stack.getMin());
    }

    @Test
    void stackWithMinPushDuplicateMinimums() {
        StackWithMin stack = new StackWithMin();
        stack.push(5);
        stack.push(1);
        stack.push(1);
        stack.push(3);
        assertEquals(1, stack.getMin());
        assertEquals(3, stack.pop());
        assertEquals(1, stack.getMin());
        assertEquals(1, stack.pop());
        assertEquals(1, stack.getMin());
        assertEquals(1, stack.pop());
        assertEquals(5, stack.getMin());
    }

    @Test
    void stackWithMinPop() {
        StackWithMin stack = new StackWithMin();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void stackWithMinPopAndGetMin() {
        StackWithMin stack = new StackWithMin();
        stack.push(4);
        stack.push(2);
        stack.push(6);
        stack.push(1);
        assertEquals(1, stack.getMin());
        assertEquals(1, stack.pop());
        assertEquals(2, stack.getMin());
        assertEquals(6, stack.pop());
        assertEquals(2, stack.getMin());
        assertEquals(2, stack.pop());
        assertEquals(4, stack.getMin());
    }

    @Test
    void stackWithMinPeek() {
        StackWithMin stack = new StackWithMin();
        stack.push(8);
        stack.push(4);
        assertEquals(4, stack.peek());
        assertEquals(4, stack.peek());
        assertEquals(4, stack.getMin());
    }

    @Test
    void stackWithAvgPush1Element() {
        StackWithAvg stack = new StackWithAvg();
        stack.push(5);
        assertEquals(5, stack.peek());
        assertEquals(5, stack.getMin());
    }

    @Test
    void stackWithAvgPushSeveralElements() {
        StackWithAvg stack = new StackWithAvg();
        stack.push(3);
        stack.push(7);
        stack.push(2);
        stack.push(8);
        assertEquals(8, stack.peek());
        assertEquals(2, stack.getMin());
    }

    @Test
    void stackWithAvgPop() {
        StackWithAvg stack = new StackWithAvg();
        stack.push(4);
        stack.push(2);
        stack.push(6);
        stack.push(1);
        assertEquals(1, stack.getMin());
        assertEquals(3.25, stack.getAverage(), 0.000001);
        assertEquals(1, stack.pop());
        assertEquals(2, stack.getMin());
        assertEquals(4.0, stack.getAverage(), 0.000001);
        assertEquals(6, stack.pop());
        assertEquals(2, stack.getMin());
        assertEquals(3.0, stack.getAverage(), 0.000001);
    }

    @Test
    void stackWithAvgDuplicateMinimums() {
        StackWithAvg stack = new StackWithAvg();
        stack.push(5);
        stack.push(1);
        stack.push(1);
        stack.push(3);
        assertEquals(1, stack.getMin());
        assertEquals(2.5, stack.getAverage(), 0.000001);
        assertEquals(3, stack.pop());
        assertEquals(1, stack.getMin());
        assertEquals(2.333333, stack.getAverage(), 0.000001);
        assertEquals(1, stack.pop());
        assertEquals(1, stack.getMin());
        assertEquals(3.0, stack.getAverage(), 0.000001);
        assertEquals(1, stack.pop());
        assertEquals(5, stack.getMin());
        assertEquals(5.0, stack.getAverage(), 0.000001);
    }

    @Test
    void stackWithAvgPeek() {
        StackWithAvg stack = new StackWithAvg();
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(20, stack.peek());
        assertEquals(10, stack.getMin());
        assertEquals(15.0, stack.getAverage(), 0.000001);
    }

    @Test
    void stackWithAvgPushAndPop() {
        StackWithAvg stack = new StackWithAvg();
        stack.push(2);
        stack.push(4);
        stack.push(6);
        assertEquals(4.0, stack.getAverage(), 0.000001);
        stack.pop();
        assertEquals(3.0, stack.getAverage(), 0.000001);
        stack.push(10);
        assertEquals(5.333333, stack.getAverage(), 0.000001);
    }

    @Test
    void calculatePostfixAddition() {
        assertEquals(5, PostfixCalculator.calculatePostfix("2 3 + ="));
    }

    @Test
    void calculatePostfixMultiplication() {
        assertEquals(6, PostfixCalculator.calculatePostfix("2 3 * ="));
    }

    @Test
    void calculatePostfixComplexExpression() {
        assertEquals(14, PostfixCalculator.calculatePostfix("2 3 4 + * ="));
    }

    @Test
    void calculatePostfixWithSeveralOperations() {
        assertEquals(20, PostfixCalculator.calculatePostfix("2 3 + 4 * ="));
    }

    @Test
    void calculatePostfixWithZero() {
        assertEquals(0, PostfixCalculator.calculatePostfix("0 5 * ="));
    }

    @Test
    void calculatePostfixWithNegativeNumbers() {
        assertEquals(-1, PostfixCalculator.calculatePostfix("-2 1 + ="));
    }
}

