import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BloomFilter_3 {
    @Test
    void hash1() {
        BloomFilter filter = new BloomFilter(10);
        assertEquals(8, filter.hash1("abc"));
    }

    @Test
    void hash2() {
        BloomFilter filter = new BloomFilter(10);
        assertEquals(6, filter.hash2("abc"));
    }

    @Test
    void addValue() {
        BloomFilter filter = new BloomFilter(32);
        filter.add("hello");
        assertTrue(filter.isValue("hello"));
    }

    @Test
    void addSeveralValues() {
        BloomFilter filter = new BloomFilter(32);
        filter.add("java");
        filter.add("kotlin");
        filter.add("python");
        assertTrue(filter.isValue("java"));
        assertTrue(filter.isValue("kotlin"));
        assertTrue(filter.isValue("python"));
    }

    @Test
    void addSameValueSeveralTimes() {
        BloomFilter filter = new BloomFilter(32);
        filter.add("hello");
        filter.add("hello");
        filter.add("hello");
        assertTrue(filter.isValue("hello"));
    }

    @Test
    void mergeNullList() {
        BloomFilter_2 result = BloomFilter_2.merge(null);
        assertNotNull(result);
        assertEquals(0, result.bitArray);
    }

    @Test
    void mergeEmptyList() {
        BloomFilter_2 result = BloomFilter_2.merge(Collections.emptyList());
        assertEquals(0, result.bitArray);
    }

    @Test
    void mergeCombinesAllFilters() {
        BloomFilter_2 first = new BloomFilter_2();
        first.bitArray = 0b0001;
        BloomFilter_2 second = new BloomFilter_2();
        second.bitArray = 0b0100;
        BloomFilter_2 third = new BloomFilter_2();
        third.bitArray = 0b1000;
        BloomFilter_2 result = BloomFilter_2.merge(Arrays.asList(first, second, third));
        assertEquals(0b1101, result.bitArray);
    }

    @Test
    void mergeDoesNotModifySourceFilters() {
        BloomFilter_2 first = new BloomFilter_2();
        first.bitArray = 0b0011;
        BloomFilter_2 second = new BloomFilter_2();
        second.bitArray = 0b1100;
        BloomFilter_2.merge(Arrays.asList(first, second));
        assertEquals(0b0011, first.bitArray);
        assertEquals(0b1100, second.bitArray);
    }
}

class BloomFilterRemoveTest {

    @Test
    void addValue() {
        BloomFilterRemove filter = new BloomFilterRemove(10);
        filter.add("hello");
        assertTrue(filter.isValue("hello"));
    }

    @Test
    void removeValue() {
        BloomFilterRemove filter = new BloomFilterRemove(10);
        filter.add("hello");
        filter.remove("hello");
        assertFalse(filter.isValue("hello"));
    }

    @Test
    void removeAbsentValue() {
        BloomFilterRemove filter = new BloomFilterRemove(10);
        filter.add("hello");
        filter.remove("world");
        assertTrue(filter.isValue("hello"));
    }

    @Test
    void removeOneOfTwoValues() {
        BloomFilterRemove filter = new BloomFilterRemove(32);
        filter.add("hello");
        filter.add("world");
        filter.remove("hello");
        assertFalse(filter.isValue("hello"));
        assertTrue(filter.isValue("world"));
    }

    @Test
    void addSameValueTwice() {
        BloomFilterRemove filter = new BloomFilterRemove(32);
        filter.add("hello");
        filter.add("hello");
        filter.remove("hello");
        assertTrue(filter.isValue("hello"));
        filter.remove("hello");
        assertFalse(filter.isValue("hello"));
    }

    @Test
    void removeSameValueSeveralTimes() {
        BloomFilterRemove filter = new BloomFilterRemove(32);
        filter.add("hello");
        filter.remove("hello");
        filter.remove("hello");
        filter.remove("hello");
        assertFalse(filter.isValue("hello"));
    }

    @Test
    void hash() {
        BloomFilterRemove filter = new BloomFilterRemove(10);
        assertTrue(filter.hash1("hello") >= 0);
        assertTrue(filter.hash1("hello") < 10);
        assertTrue(filter.hash2("hello") >= 0);
        assertTrue(filter.hash2("hello") < 10);
    }
}

class BloomFilterRestorerTest {

    @Test
    void restoreValues() {
        BloomFilterRestorer filter = new BloomFilterRestorer(32);
        filter.add("java");
        filter.add("hello");
        List<String> result = filter.restorePossibleValues(Arrays.asList("java", "hello"));
        assertEquals(Arrays.asList("java", "hello"), result);
    }

    @Test
    void ignoresNullDictionaryValues() {
        BloomFilterRestorer filter = new BloomFilterRestorer(32);
        filter.add("java");
        List<String> result = filter.restorePossibleValues(Arrays.asList(null, "java", null));
        assertEquals(Collections.singletonList("java"), result);
    }

    @Test
    void removeDuplicates() {
        BloomFilterRestorer filter = new BloomFilterRestorer(32);
        filter.add("java");
        List<String> result = filter.restorePossibleValues(Arrays.asList("java", "java", "java"));
        assertEquals(Collections.singletonList("java"), result);
    }

    @Test
    void preservesDictionaryOrder() {
        BloomFilterRestorer filter = new BloomFilterRestorer(32);
        filter.add("third");
        filter.add("first");
        filter.add("second");
        List<String> result = filter.restorePossibleValues(Arrays.asList("first", "second", "third"));
        assertEquals(
                Arrays.asList("first", "second", "third"),
                result
        );
    }

    @Test
    void nullDictionary() {
        BloomFilterRestorer filter = new BloomFilterRestorer(32);
        assertThrows(IllegalArgumentException.class, () -> filter.restorePossibleValues(null));
    }

    @Test
    void emptyDictionary() {
        BloomFilterRestorer filter = new BloomFilterRestorer(32);
        assertTrue(filter.restorePossibleValues(Collections.emptyList()).isEmpty());
    }
}

