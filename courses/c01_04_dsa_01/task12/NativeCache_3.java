import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NativeCache_3 {
    @Test
    void putWithCollisions() {
        NativeCache<Integer> cache = new NativeCache<>(3, Integer.class);
        cache.put("0", 10);
        cache.put("3", 30);
        cache.put("6", 60);
        assertEquals(10, cache.get("0"));
        assertEquals(30, cache.get("3"));
        assertEquals(60, cache.get("6"));
        assertTrue(cache.isKey("0"));
        assertTrue(cache.isKey("3"));
        assertTrue(cache.isKey("6"));
    }

    @Test
    void getIncreaseHitsCounter() {
        NativeCache<Integer> cache = new NativeCache<>(3, Integer.class);
        cache.put("0", 10);
        cache.put("3", 30);
        cache.put("6", 60);
        assertEquals(0, cache.hits[0]);
        assertEquals(0, cache.hits[1]);
        assertEquals(0, cache.hits[2]);
        cache.get("0");
        cache.get("0");
        cache.get("3");
        int index0 = findIndex(cache, "0");
        int index3 = findIndex(cache, "3");
        int index6 = findIndex(cache, "6");
        assertEquals(2, cache.hits[index0]);
        assertEquals(1, cache.hits[index3]);
        assertEquals(0, cache.hits[index6]);
    }

    @Test
    void putEvictsLowestHitsWhenFull() {
        NativeCache<Integer> cache = new NativeCache<>(3, Integer.class);
        cache.put("0", 10);
        cache.put("3", 30);
        cache.put("6", 60);
        cache.get("0");
        cache.get("0");
        cache.get("3");
        cache.put("9", 90);
        assertTrue(cache.isKey("0"));
        assertTrue(cache.isKey("3"));
        assertFalse(cache.isKey("6"));
        assertTrue(cache.isKey("9"));
        assertEquals(10, cache.get("0"));
        assertEquals(30, cache.get("3"));
        assertNull(cache.get("6"));
        assertEquals(90, cache.get("9"));
    }

    @Test
    void putReplacesEvictedKey() {
        NativeCache<Integer> cache = new NativeCache<>(3, Integer.class);
        cache.put("0", 10);
        cache.put("3", 30);
        cache.put("6", 60);
        cache.get("0");
        cache.get("3");
        cache.get("3");
        cache.put("9", 90);
        assertEquals(90, cache.get("9"));
        assertTrue(cache.isKey("9"));
        int index9 = findIndex(cache, "9");
        assertNotEquals(-1, index9);
        assertEquals("9", cache.slots[index9]);
        assertEquals(90, cache.values[index9]);
    }

    @Test
    void putUpdatesExistingValue() {
        NativeCache<Integer> cache = new NativeCache<>(3, Integer.class);
        cache.put("0", 10);
        cache.put("0", 100);
        assertEquals(100, cache.get("0"));
        int index0 = findIndex(cache, "0");
        assertEquals(2, cache.hits[index0]);
    }

    private static int findIndex(NativeCache<Integer> cache, String key) {
        for (int i = 0; i < cache.size; i++) {
            if (key.equals(cache.slots[i])) {
                return i;
            }
        }
        return -1;
    }
}

