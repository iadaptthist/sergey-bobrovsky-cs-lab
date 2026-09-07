import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class NativeDictionary_3 {
    @Test
    void putNewKey() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        dictionary.put("one", 100);
        assertTrue(dictionary.isKey("one"));
        assertEquals(100, dictionary.get("one"));
    }

    @Test
    void putExistingKey() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        dictionary.put("one", 100);
        dictionary.put("one", 200);
        assertTrue(dictionary.isKey("one"));
        assertEquals(200, dictionary.get("one"));
    }

    @Test
    void isKeyTrueForExistingAndFalseForMissingKey() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        dictionary.put("one", 100);
        dictionary.put("two", 200);
        assertTrue(dictionary.isKey("one"));
        assertTrue(dictionary.isKey("two"));
        assertFalse(dictionary.isKey("three"));
    }

    @Test
    void getValueForExistingKeyAndNullForMissingKey() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        dictionary.put("one", 100);
        assertEquals(100, dictionary.get("one"));
        assertNull(dictionary.get("two"));
    }

    @Test
    void findIndexMinusOneForEmptyDictionary() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        assertEquals(-1, dictionary.findIndex("cat"));
    }

    @Test
    void findIndexExistingKey() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 1);
        dictionary.put("dog", 2);
        dictionary.put("mouse", 3);
        assertEquals(0, dictionary.findIndex("cat"));
        assertEquals(1, dictionary.findIndex("dog"));
        assertEquals(2, dictionary.findIndex("mouse"));
    }

    @Test
    void findIndexMinusOneForMissingKey() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 1);
        dictionary.put("dog", 2);
        dictionary.put("mouse", 3);
        assertEquals(-1, dictionary.findIndex("ant"));
        assertEquals(-1, dictionary.findIndex("cow"));
        assertEquals(-1, dictionary.findIndex("zebra"));
    }

    @Test
    void findInsertIndexEmptyDictionary() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        assertEquals(0, dictionary.findInsertIndex("cat"));
    }

    @Test
    void findInsertIndexCorrectPosition() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(10, Integer.class);
        dictionary.put("cat", 1);
        dictionary.put("dog", 2);
        dictionary.put("mouse", 3);
        assertEquals(0, dictionary.findInsertIndex("ant"));
        assertEquals(0, dictionary.findInsertIndex("cat"));
        assertEquals(1, dictionary.findInsertIndex("cow"));
        assertEquals(1, dictionary.findInsertIndex("dog"));
        assertEquals(3, dictionary.findInsertIndex("zebra"));
    }

    @Test
    void putKeepKeysSorted() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(10, Integer.class);
        dictionary.put("mouse", 3);
        dictionary.put("cat", 1);
        dictionary.put("zebra", 5);
        dictionary.put("dog", 2);
        dictionary.put("ant", 0);
        assertEquals(5, dictionary.count);
        assertArrayEquals(new String[]{"ant", "cat", "dog", "mouse", "zebra", null, null, null, null, null}, dictionary.slots);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 5, null, null, null, null, null}, dictionary.values);
    }

    @Test
    void putInsertIntoBeginning() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("dog", 2);
        dictionary.put("cat", 1);
        dictionary.put("ant", 0);
        assertArrayEquals(new String[]{"ant", "cat", "dog", null, null}, dictionary.slots);
        assertArrayEquals(new Integer[]{0, 1, 2, null, null}, dictionary.values);
    }

    @Test
    void putInsertIntoMiddle() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("ant", 1);
        dictionary.put("cat", 2);
        dictionary.put("mouse", 3);
        dictionary.put("dog", 4);
        assertArrayEquals(new String[]{"ant", "cat", "dog", "mouse", null}, dictionary.slots);
        assertArrayEquals(new Integer[]{1, 2, 4, 3, null}, dictionary.values);
    }

    @Test
    void putInsertIntoEnd() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("ant", 1);
        dictionary.put("cat", 2);
        dictionary.put("dog", 3);
        assertArrayEquals(new String[]{"ant", "cat", "dog", null, null}, dictionary.slots);
    }

    @Test
    void putUpdateValueForExistingKey() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 10);
        dictionary.put("dog", 20);
        dictionary.put("cat", 100);
        assertEquals(2, dictionary.count);
        assertEquals(100, dictionary.get("cat"));
        assertArrayEquals(new String[]{"cat", "dog", null, null, null}, dictionary.slots);
    }

    @Test
    void putUpdateValueWithoutChangingCount() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(3, Integer.class);
        dictionary.put("cat", 1);
        dictionary.put("dog", 2);
        assertEquals(2, dictionary.count);
        dictionary.put("cat", 42);
        assertEquals(2, dictionary.count);
        assertEquals(42, dictionary.get("cat"));
    }

    @Test
    void isKeyTrueForExistingKey() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 1);
        assertTrue(dictionary.isKey("cat"));
    }

    @Test
    void isKeyFalseForMissingKey() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 1);
        assertFalse(dictionary.isKey("dog"));
    }

    @Test
    void getValueForExistingKey() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 123);
        assertEquals(123, dictionary.get("cat"));
    }

    @Test
    void getNullForMissingKey() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 123);
        assertNull(dictionary.get("dog"));
    }

    @Test
    void removeExistingKey() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 1);
        dictionary.put("dog", 2);
        dictionary.put("mouse", 3);
        dictionary.remove("dog");
        assertEquals(2, dictionary.count);
        assertFalse(dictionary.isKey("dog"));
        assertNull(dictionary.get("dog"));
        assertArrayEquals(new String[]{"cat", "mouse", null, null, null}, dictionary.slots);
        assertArrayEquals(new Integer[]{1, 3, null, null, null}, dictionary.values);
    }

    @Test
    void removeFirstElement() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 1);
        dictionary.put("dog", 2);
        dictionary.put("mouse", 3);
        dictionary.remove("cat");
        assertEquals(2, dictionary.count);
        assertArrayEquals(new String[]{"dog", "mouse", null, null, null}, dictionary.slots);
        assertArrayEquals(new Integer[]{2, 3, null, null, null}, dictionary.values);
    }

    @Test
    void removeLastElement() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 1);
        dictionary.put("dog", 2);
        dictionary.put("mouse", 3);
        dictionary.remove("mouse");
        assertEquals(2, dictionary.count);
        assertArrayEquals(new String[]{"cat", "dog", null, null, null}, dictionary.slots);
        assertArrayEquals(new Integer[]{1, 2, null, null, null}, dictionary.values);
    }

    @Test
    void removeDoNothingForMissingKey() {
        NativeDictionary_2<Integer> dictionary = new NativeDictionary_2<>(5, Integer.class);
        dictionary.put("cat", 1);
        dictionary.put("dog", 2);
        dictionary.remove("mouse");
        assertEquals(2, dictionary.count);
        assertArrayEquals(new String[]{"cat", "dog", null, null, null}, dictionary.slots);
        assertArrayEquals(new Integer[]{1, 2, null, null, null}, dictionary.values);
    }

    @Test
    void putValue() {
        BitStringDictionary<String> dictionary = new BitStringDictionary<>(4);
        dictionary.put(5, "hello");
        assertTrue(dictionary.isKey(5));
        assertEquals("hello", dictionary.get(5));
    }

    @Test
    void isKeyFalseForMissKey() {
        BitStringDictionary<String> dictionary = new BitStringDictionary<>(4);
        assertFalse(dictionary.isKey(5));
    }

    @Test
    void getThrowForMissingKey() {
        BitStringDictionary<String> dictionary = new BitStringDictionary<>(4);
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> dictionary.get(5));
        assertEquals("Key not found: 5", exception.getMessage());
    }

    @Test
    void deleteExistingKey() {
        BitStringDictionary<String> dictionary = new BitStringDictionary<>(4);
        dictionary.put(5, "hello");
        assertTrue(dictionary.isKey(5));
        dictionary.delete(5);
        assertFalse(dictionary.isKey(5));
    }

    @Test
    void deleteThrowForMissingKey() {
        BitStringDictionary<String> dictionary = new BitStringDictionary<>(4);
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> dictionary.delete(5));
        assertEquals("Key not found: 5", exception.getMessage());
    }

    @Test
    void putOverwriteExistingValue() {
        BitStringDictionary<String> dictionary = new BitStringDictionary<>(4);
        dictionary.put(5, "first");
        dictionary.put(5, "second");
        assertTrue(dictionary.isKey(5));
        assertEquals("second", dictionary.get(5));
    }

    @Test
    void deleteClearValue() {
        BitStringDictionary<String> dictionary = new BitStringDictionary<>(4);
        dictionary.put(5, "hello");
        dictionary.delete(5);
        assertFalse(dictionary.isKey(5));
        assertThrows(NoSuchElementException.class, () -> dictionary.get(5));
    }
}

