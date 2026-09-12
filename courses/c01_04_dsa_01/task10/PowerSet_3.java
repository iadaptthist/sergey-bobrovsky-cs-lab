import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PowerSet_3 {
    @Test
    void putDoesNotDuplicateExistingElement() {
        PowerSet set = new PowerSet();
        set.put("apple");
        assertTrue(set.get("apple"));
        assertEquals(1, set.size());
        set.put("apple");
        assertTrue(set.get("apple"));
        assertEquals(1, set.size());
        set.put("table");
        assertTrue(set.get("table"));
        assertEquals(2, set.size());
    }

    @Test
    void remove() {
        PowerSet set = new PowerSet();
        set.put("apple");
        set.put("table");
        assertTrue(set.remove("apple"));
        assertFalse(set.get("apple"));
        assertEquals(1, set.size());
        assertFalse(set.remove("apple"));
        assertFalse(set.remove("cat"));
        assertEquals(1, set.size());
    }

    @Test
    void intersectionCanBeNonEmpty() {
        PowerSet first = setOf(new String[]{"apple", "table", "cat"});
        PowerSet second = setOf(new String[]{"table", "cat", "dog"});
        PowerSet result = first.intersection(second);
        assertEquals(2, result.size());
        assertTrue(result.get("table"));
        assertTrue(result.get("cat"));
        assertFalse(result.get("apple"));
        assertFalse(result.get("dog"));
    }

    @Test
    void intersectionCanBeEmpty() {
        PowerSet first = setOf(new String[]{"apple", "table"});
        PowerSet second = setOf(new String[]{"cat", "dog"});
        PowerSet result = first.intersection(second);
        assertEquals(0, result.size());
    }

    @Test
    void unionAllUniqueElements() {
        PowerSet first = setOf(new String[]{"apple", "table"});
        PowerSet second = setOf(new String[]{"cat", "dog"});
        PowerSet result = first.union(second);
        assertEquals(4, result.size());
        assertTrue(result.get("apple"));
        assertTrue(result.get("table"));
        assertTrue(result.get("cat"));
        assertTrue(result.get("dog"));
    }

    @Test
    void unionWithEmptySet() {
        PowerSet nonEmpty = setOf(new String[]{"apple", "table"});
        PowerSet empty = new PowerSet();
        PowerSet result1 = nonEmpty.union(empty);
        PowerSet result2 = empty.union(nonEmpty);
        assertEquals(2, result1.size());
        assertEquals(2, result2.size());
        assertTrue(result1.get("apple"));
        assertTrue(result1.get("table"));
        assertTrue(result2.get("apple"));
        assertTrue(result2.get("table"));
    }

    @Test
    void differenceCanBeNonEmpty() {
        PowerSet first = setOf(new String[]{"apple", "table", "cat"});
        PowerSet second = setOf(new String[]{"table"});
        PowerSet result = first.difference(second);
        assertEquals(2, result.size());
        assertTrue(result.get("apple"));
        assertTrue(result.get("cat"));
        assertFalse(result.get("table"));
    }

    @Test
    void differenceCanBeEmpty() {
        PowerSet first = setOf(new String[]{"apple", "table"});
        PowerSet second = setOf(new String[]{"apple", "table", "cat"});
        PowerSet result = first.difference(second);
        assertEquals(0, result.size());
    }

    @Test
    void isSubsetAllParameterElementsAreInCurrentSet() {
        PowerSet current = setOf(new String[]{"apple", "table", "cat"});
        PowerSet parameter = setOf(new String[]{"apple", "table"});
        assertTrue(current.isSubset(parameter));
    }

    @Test
    void isSubsetAllElementsAreInParameter() {
        PowerSet current = setOf(new String[]{"apple", "table"});
        PowerSet parameter = setOf(new String[]{"apple", "table", "cat"});
        assertFalse(current.isSubset(parameter));
    }

    @Test
    void isSubsetSomeParameterElementsAreMissingInCurrentSet() {
        PowerSet current = setOf(new String[]{"apple", "table"});
        PowerSet parameter = setOf(new String[]{"apple", "cat"});
        assertFalse(current.isSubset(parameter));
    }

    @Test
    void equals() {
        PowerSet first = setOf(new String[]{"apple", "table", "cat"});
        PowerSet second = setOf(new String[]{"cat", "apple", "table"});
        PowerSet different = setOf(new String[]{"apple", "table"});
        assertTrue(first.equals(second));
        assertFalse(first.equals(different));
    }

    @Test
    void operationsMultiElements() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            PowerSet first = new PowerSet();
            PowerSet second = new PowerSet();
            for (int i = 0; i < 15_000; i++) {
                first.put("first-" + i);
            }
            for (int i = 10_000; i < 25_000; i++) {
                second.put("second-" + i);
            }
            assertEquals(15_000, first.size());
            assertEquals(15_000, second.size());
            PowerSet union = first.union(second);
            assertEquals(30_000, union.size());
            PowerSet intersection = first.intersection(second);
            assertEquals(0, intersection.size());
            PowerSet difference = first.difference(second);
            assertEquals(15_000, difference.size());
        });
    }

    private static PowerSet setOf(String[] values) {
        PowerSet set = new PowerSet();

        for (String value : values) {
            set.put(value);
        }

        return set;
    }

    @Test
    void cartesianAllPairs() {
        PowerSet_2 first = setOfSet_2(new String[]{"A", "B"});
        PowerSet_2 second = setOfSet_2(new String[]{"1", "2", "3"});
        PowerSet_2 result = first.cartesianProduct(second);
        assertEquals(6, result.size());
        assertTrue(result.get("A, 1, "));
        assertTrue(result.get("A, 2, "));
        assertTrue(result.get("A, 3, "));
        assertTrue(result.get("B, 1, "));
        assertTrue(result.get("B, 2, "));
        assertTrue(result.get("B, 3, "));
    }

    @Test
    void cartesianEmptySet() {
        PowerSet_2 first = setOfSet_2(new String[]{"A", "B"});
        PowerSet_2 second = new PowerSet_2();
        PowerSet_2 result = first.cartesianProduct(second);
        assertEquals(0, result.size());
    }

    @Test
    void multiIntersectionElements() {
        PowerSet_2 first = setOfSet_2(new String[]{"A", "B", "C"});
        PowerSet_2 second = setOfSet_2(new String[]{"B", "C", "D"});
        PowerSet_2 third = setOfSet_2(new String[]{"C", "D", "E"});
        PowerSet_2 result = first.multiIntersection(
                Arrays.asList(first, second, third)
        );
        assertEquals(1, result.size());
        assertTrue(result.get("C"));
    }

    @Test
    void multiIntersectionEmptySet() {
        PowerSet_2 first = setOfSet_2(new String[]{"A", "B"});
        PowerSet_2 second = setOfSet_2(new String[]{"B", "C"});
        PowerSet_2 third = setOfSet_2(new String[]{"C", "D"});
        PowerSet_2 result = first.multiIntersection(
                Arrays.asList(first, second, third)
        );
        assertEquals(0, result.size());
    }

    @Test
    void multiIntersectionLeastThreeSets() {
        PowerSet_2 first = setOfSet_2(new String[]{"A", "B"});
        PowerSet_2 second = setOfSet_2(new String[]{"B", "C"});
        assertThrows(
                IllegalArgumentException.class,
                () -> first.multiIntersection(Arrays.asList(first, second))
        );
    }

    @Test
    void multiIntersectionNotAcceptNull() {
        PowerSet_2 set = new PowerSet_2();
        assertThrows(
                IllegalArgumentException.class,
                () -> set.multiIntersection(null)
        );
    }

    @Test
    void bagAdd() {
        Bag<String> bag = new Bag<>();
        bag.add("apple");
        bag.add("apple");
        bag.add("banana");
        List<Bag.ElementAndFrequency<String>> elements = bag.getElementsWithFrequencies();
        assertEquals(2, elements.size());
    }

    @Test
    void bagRemoveDecreasesFrequency() {
        Bag<String> bag = new Bag<>();
        bag.add("apple");
        bag.add("apple");
        bag.remove("apple");
        List<Bag.ElementAndFrequency<String>> elements =
                bag.getElementsWithFrequencies();
        assertEquals(1, elements.size());
    }

    @Test
    void bagRemoveDeletesElement() {
        Bag<String> bag = new Bag<>();
        bag.add("apple");
        bag.remove("apple");
        assertTrue(bag.getElementsWithFrequencies().isEmpty());
    }

    @Test
    void bagRemoveMissingElement() {
        Bag<String> bag = new Bag<>();
        bag.add("apple");
        bag.remove("banana");
        List<Bag.ElementAndFrequency<String>> elements =
                bag.getElementsWithFrequencies();
        assertEquals(1, elements.size());
    }

    private static PowerSet_2 setOfSet_2(String[] values) {
        PowerSet_2 set = new PowerSet_2();

        for (String value : values) {
            set.put(value);
        }

        return set;
    }
}

