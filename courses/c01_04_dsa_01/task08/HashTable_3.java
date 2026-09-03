// Занятие 8. Хэширование.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTable_3 {
    @Test
    void hashFunIndexWithinTable() {
        HashTable table = new HashTable(10, 3);
        int index = table.hashFun("hello");
        assertTrue(index >= 0 && index < table.size);
    }

    @Test
    void hashFunSameIndexForSameValue() {
        HashTable table = new HashTable(10, 3);
        assertEquals(table.hashFun("hello"), table.hashFun("hello")
        );
    }

    @Test
    void seekSlotEmptySlot() {
        HashTable table = new HashTable(10, 3);
        int index = table.seekSlot("hello");
        assertTrue(index >= 0 && index < 10);
        assertNull(table.slots[index]);
    }

    @Test
    void putPlaceValueIntoTable() {
        HashTable table = new HashTable(10, 3);
        int index = table.put("hello");
        assertTrue(index >= 0);
        assertEquals("hello", table.slots[index]);
    }

    @Test
    void findValueIndex() {
        HashTable table = new HashTable(10, 1);
        int index = table.put("hello");
        assertEquals(index, table.find("hello"));
    }

    @Test
    void findMinusOneForMissingValue() {
        HashTable table = new HashTable(10, 1);
        table.put("hello");
        assertEquals(-1, table.find("world"));
    }

    @Test
    void findWorkAfterCollision() {
        HashTable table = new HashTable(10, 1);
        table.put("a");
        int secondIndex = table.put("k");
        assertEquals(secondIndex, table.find("k"));
    }

    @Test
    void findWorkWithStepGreaterThanOne() {
        HashTable table = new HashTable(10, 3);
        table.put("a");
        int index = table.put("k");
        assertEquals(index, table.find("k"));
    }

    @Test
    void seekSlotMinusOneWhenNoSlotAvailable() {
        HashTable table = new HashTable(5, 2);
        for (int i = 0; i < 5; i++) {
            assertNotEquals(-1, table.put("value" + i));
        }
        assertEquals(-1, table.seekSlot("another"));
    }

    @Test
    void findCorrectIndexForAllInsertedValues() {
        HashTable table = new HashTable(20, 3);
        String[] values = {"apple", "banana", "orange", "grape", "melon"};
        for (String value : values) {
            assertNotEquals(-1, table.put(value));
        }
        for (String value : values) {
            int index = table.find(value);
            assertNotEquals(-1, index);
            assertEquals(value, table.slots[index]);
        }
    }

    @Test
    void hashFunValidIndex() {
        HashTable_2 table = new HashTable_2(10, 1);
        int index = table.hashFun("hello");
        assertTrue(index >= 0 && index < table.size);
    }

    @Test
    void hashFunBeDeterministic() {
        HashTable_2 table = new HashTable_2(10, 1);
        assertEquals(table.hashFun("hello"), table.hashFun("hello"));
    }

    @Test
    void seekSlotHashTable2EmptySlot() {
        HashTable_2 table = new HashTable_2(10, 1);
        int index = table.seekSlot("hello");
        assertNotEquals(-1, index);
        assertNull(table.slots[index]);
    }

    @Test
    void putInsertValue() {
        HashTable_2 table = new HashTable_2(10, 1);
        int index = table.put("hello");
        assertNotEquals(-1, index);
        assertEquals("hello", table.slots[index]);
        assertEquals(1, table.count);
    }

    @Test
    void putHashTable2ResolveCollision() {
        HashTable_2 table = new HashTable_2(10, 1);
        int firstIndex = table.put("a");
        int secondIndex = table.put("k");
        assertEquals(7, firstIndex);
        assertEquals(8, secondIndex);
        assertEquals("a", table.slots[firstIndex]);
        assertEquals("k", table.slots[secondIndex]);
    }

    @Test
    void findInsertedValueIndex() {
        HashTable_2 table = new HashTable_2(10, 1);
        int index = table.put("hello");
        assertEquals(index, table.find("hello"));
    }

    @Test
    void findHashTable2MinusOneForMissingValue() {
        HashTable_2 table = new HashTable_2(10, 1);
        table.put("hello");
        assertEquals(-1, table.find("world"));
    }

    @Test
    void findHashTable2WorkAfterCollision() {
        HashTable_2 table = new HashTable_2(10, 1);
        table.put("a");
        int index = table.put("k");
        assertEquals(index, table.find("k"));
    }

    @Test
    void countIncreaseAfterPut() {
        HashTable_2 table = new HashTable_2(10, 1);
        assertEquals(0, table.count);
        table.put("one");
        assertEquals(1, table.count);
        table.put("two");
        assertEquals(2, table.count);
        table.put("three");
        assertEquals(3, table.count);
    }

    @Test
    void resizeIncreaseTableSize() {
        HashTable_2 table = new HashTable_2(10, 1);
        int oldSize = table.size;
        table.resize();
        assertEquals(oldSize * 2 + 1, table.size);
        assertEquals(oldSize * 2 + 1, table.slots.length);
    }

    @Test
    void hashFun1ValidIndex() {
        MultiHashTable table = new MultiHashTable(10);
        int index = table.hashFun1("hello");
        assertTrue(index >= 0 && index < table.size);
    }

    @Test
    void hashFun1BeDeterministic() {
        MultiHashTable table = new MultiHashTable(10);
        assertEquals(table.hashFun1("hello"), table.hashFun1("hello"));
    }

    @Test
    void hashFun2ValidStep() {
        MultiHashTable table = new MultiHashTable(10);
        int step = table.hashFun2("hello");
        assertTrue(step >= 1 && step < table.size);
    }

    @Test
    void hashFun2BeDeterministic() {
        MultiHashTable table = new MultiHashTable(10);
        assertEquals(table.hashFun2("hello"), table.hashFun2("hello"));
    }

    @Test
    void seekSlotMultiHashTableEmptySlot() {
        MultiHashTable table = new MultiHashTable(10);
        int index = table.seekSlot("hello");
        assertNotEquals(-1, index);
        assertNull(table.slots[index]);
    }

    @Test
    void putMultiHashTableInsertValue() {
        MultiHashTable table = new MultiHashTable(10);
        int index = table.put("hello");
        assertNotEquals(-1, index);
        assertEquals("hello", table.slots[index]);
    }

    @Test
    void findMultiHashTableInsertedValueIndex() {
        MultiHashTable table = new MultiHashTable(10);
        int index = table.put("hello");
        assertEquals(index, table.find("hello"));
    }

    @Test
    void findMultiHashTableMinusOneForMissingValue() {
        MultiHashTable table = new MultiHashTable(10);
        table.put("hello");
        assertEquals(-1, table.find("world"));
    }

    @Test
    void findMultiHashTableWorkAfterCollision() {
        MultiHashTable table = new MultiHashTable(10);
        table.put("a");
        int index = table.put("k");
        assertEquals(index, table.find("k"));
    }

    @Test
    void putMultiHashTableMinusOneWhenTableIsFull() {
        MultiHashTable table = new MultiHashTable(3);
        assertNotEquals(-1, table.put("one"));
        assertNotEquals(-1, table.put("two"));
        assertNotEquals(-1, table.put("three"));
        assertEquals(-1, table.put("four"));
    }

    @Test
    void findAllInsertedValues() {
        MultiHashTable table = new MultiHashTable(20);
        String[] values = {"apple","banana","orange","grape","melon"};
        for (String value : values) {
            assertNotEquals(-1, table.put(value));
        }
        for (String value : values) {
            assertNotEquals(-1, table.find(value));
        }
    }

    @Test
    void hashFunSaltedHashTableValidIndex() {
        SaltedHashTable table = new SaltedHashTable(10, 3);
        int index = table.hashFun("hello");
        assertTrue(index >= 0 && index < table.size);
    }

    @Test
    void hashFunSaltedHashTableBeDeterministic() {
        SaltedHashTable table = new SaltedHashTable(10, 3);
        assertEquals(table.hashFun("hello"),table.hashFun("hello"));
    }

    @Test
    void seekSlotSaltedHashTableEmptySlot() {
        SaltedHashTable table = new SaltedHashTable(10, 3);
        int index = table.seekSlot("hello");
        assertNotEquals(-1, index);
        assertNull(table.slots[index]);
    }

    @Test
    void putSaltedHashTableInsertValue() {
        SaltedHashTable table = new SaltedHashTable(10, 3);
        int index = table.put("hello");
        assertNotEquals(-1, index);
        assertEquals("hello", table.slots[index]);
    }

    @Test
    void findSaltedHashTableInsertedValueIndex() {
        SaltedHashTable table = new SaltedHashTable(10, 3);
        int index = table.put("hello");
        assertEquals(index, table.find("hello"));
    }

    @Test
    void findSaltedHashTableWorkAfterCollision() {
        SaltedHashTable table = new SaltedHashTable(10, 3);
        table.put("hello");
        int index = table.put("world");
        assertEquals(index, table.find("world"));
    }

    @Test
    void putSaltedHashTableMinusOneWhenTableIsFull() {
        SaltedHashTable table = new SaltedHashTable(5, 1);
        for (int i = 0; i < 5; i++) {
            assertNotEquals(-1, table.put("value" + i));
        }
        assertEquals(-1, table.put("another"));
    }

    @Test
    void findSaltedHashTableAllInsertedValues() {
        SaltedHashTable table = new SaltedHashTable(20, 3);
        String[] values = {"apple","banana","orange","grape", "melon"};
        for (String value : values) {
            assertNotEquals(-1, table.put(value));
        }
        for (String value : values) {
            assertNotEquals(-1, table.find(value));
        }
    }
}

