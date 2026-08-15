import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynArray_3 {

    @Test
    void makeArrayEmptyArray() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        dynArray.makeArray(32);
        assertEquals(32, dynArray.capacity);
        assertNotNull(dynArray.array);
        assertEquals(32, dynArray.array.length);
    }

    @Test
    void makeArrayNotCreateArraySmallerThan16() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        dynArray.makeArray(5);
        assertEquals(16, dynArray.capacity);
        assertNotNull(dynArray.array);
        assertEquals(16, dynArray.array.length);
    }

    @Test
    void makeArrayManyElements() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        dynArray.append(10);
        dynArray.append(20);
        dynArray.append(30);
        dynArray.makeArray(32);
        assertEquals(3, dynArray.count);
        assertEquals(32, dynArray.capacity);
        assertEquals(10, dynArray.getItem(0));
        assertEquals(20, dynArray.getItem(1));
        assertEquals(30, dynArray.getItem(2));
    }

    @Test
    void getItem1element() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        dynArray.append(100);
        assertEquals(100, dynArray.getItem(0));
    }

    @Test
    void getItemManyElements() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        dynArray.append(10);
        dynArray.append(20);
        dynArray.append(30);
        dynArray.append(40);
        assertEquals(10, dynArray.getItem(0));
        assertEquals(20, dynArray.getItem(1));
        assertEquals(30, dynArray.getItem(2));
        assertEquals(40, dynArray.getItem(3));
    }

    @Test
    void getItemThrowExceptionWhenArrayIsEmpty() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dynArray.getItem(0);
        });
    }

    @Test
    void getItemThrowExceptionForNegativeIndex() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        dynArray.append(10);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dynArray.getItem(-1);
        });
    }

    @Test
    void getItemThrowExceptionForIndexEqualToCount() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        dynArray.append(10);
        dynArray.append(20);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dynArray.getItem(2);
        });
    }

    @Test
    void getItemThrowExceptionForIndexGreaterThanCount() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        dynArray.append(10);
        dynArray.append(20);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dynArray.getItem(100);
        });
    }

    @Test
    void appendEmptyArray() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        dynArray.append(10);
        assertEquals(1, dynArray.count);
        assertEquals(16, dynArray.capacity);
        assertEquals(10, dynArray.getItem(0));
    }

    @Test
    void appendSeveralItems() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        dynArray.append(10);
        dynArray.append(20);
        dynArray.append(30);
        assertEquals(3, dynArray.count);
        assertEquals(16, dynArray.capacity);
        assertEquals(10, dynArray.getItem(0));
        assertEquals(20, dynArray.getItem(1));
        assertEquals(30, dynArray.getItem(2));
    }

    @Test
    void append16thElement() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            dynArray.append(i);
        }
        assertEquals(16, dynArray.count);
        assertEquals(16, dynArray.capacity);
        assertEquals(16, dynArray.array.length);
        for (int i = 0; i < 16; i++) {
            assertEquals(i, dynArray.getItem(i));
        }
    }

    @Test
    void append17thElement() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        for (int i = 0; i < 17; i++) {
            dynArray.append(i);
        }
        assertEquals(17, dynArray.count);
        assertEquals(32, dynArray.capacity);
        assertEquals(32, dynArray.array.length);
        for (int i = 0; i < 17; i++) {
            assertEquals(i, dynArray.getItem(i));
        }
    }

    @Test
    void appendIncreaseCapacitySeveralTimes() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        for (int i = 0; i < 33; i++) {
            dynArray.append(i);
        }
        assertEquals(33, dynArray.count);
        assertEquals(64, dynArray.capacity);
        assertEquals(64, dynArray.array.length);
        for (int i = 0; i < 33; i++) {
            assertEquals(i, dynArray.getItem(i));
        }
    }

    @Test
    void insertAdd1element()
    {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(10);
        array.append(20);
        array.append(30);
        assertEquals(3, array.count);
        assertEquals(16, array.capacity);
        array.insert(40, 1);
        assertEquals(4, array.count);
        assertEquals(16, array.capacity);
        assertEquals(10, array.getItem(0));
        assertEquals(40, array.getItem(1));
        assertEquals(20, array.getItem(2));
        assertEquals(30, array.getItem(3));
    }

    @Test
    void insertAdd1elementWithCapacityIncrease()
    {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            array.append(i);
        }
        assertEquals(16, array.count);
        assertEquals(16, array.capacity);
        array.insert(100, 8);
        assertEquals(17, array.count);
        assertEquals(32, array.capacity);
        assertEquals(0, array.getItem(0));
        assertEquals(7, array.getItem(7));
        assertEquals(100, array.getItem(8));
        assertEquals(8, array.getItem(9));
        assertEquals(15, array.getItem(16));
    }

    @Test
    void insertThrowExceptionWhenIndexIsNegative()
    {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(10);
        array.append(20);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.insert(100, -1);
        });
    }

    @Test
    void insertThrowExceptionWhenIndexIsGreaterThanCount()
    {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(10);
        array.append(20);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.insert(78, 3);
        });
    }

    @Test
    void remove1element()
    {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(10);
        array.append(20);
        array.append(30);
        array.append(40);
        assertEquals(4, array.count);
        assertEquals(16, array.capacity);
        array.remove(1);
        assertEquals(3, array.count);
        assertEquals(16, array.capacity);
        assertEquals(10, array.getItem(0));
        assertEquals(30, array.getItem(1));
        assertEquals(40, array.getItem(2));
    }

    @Test
    void remove2elementsWithCapacityDecrease()
    {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        for (int i = 0; i < 17; i++) {
            array.append(i);
        }
        assertEquals(17, array.count);
        assertEquals(32, array.capacity);
        array.remove(0);
        array.remove(0);
        assertEquals(15, array.count);
        assertEquals(21, array.capacity);
        assertEquals(2, array.getItem(0));
        assertEquals(3, array.getItem(1));
        assertEquals(16, array.getItem(14));
    }

    @Test
    void removeThrowExceptionWhenIndexIsNegative()
    {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(10);
        array.append(20);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.remove(-1);
        });
    }

    @Test
    void removeThrowExceptionWhenIndexIsEqualToCount()
    {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(10);
        array.append(20);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.remove(2);
        });
    }
    @Test
    void removeThrowExceptionWhenIndexIsGreaterThanCount()
    {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(10);
        array.append(20);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.remove(10);
        });
    }

    @Test
    void oneDimensionalArray() {
        DynArray_2<Integer> array = new DynArray_2<>(2);
        array.set(10, 0);
        array.set(20, 1);
        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
    }

    @Test
    void twoDimensionalArray() {
        DynArray_2<String> array = new DynArray_2<>(2, 2);
        array.set("first", 0, 0);
        array.set("second", 1, 1);
        array.set("third", 1, 0);
        assertEquals("first", array.get(0, 0));
        assertEquals("second", array.get(1, 1));
        assertEquals("third", array.get(1, 0));
    }

    @Test
    void threeDimensionalArray() {
        DynArray_2<Integer> array = new DynArray_2<>(2, 2, 2);
        array.set(100, 1, 2, 3);
        array.set(200, 5, 1, 0);
        array.set(300, 20, 10, 7);
        assertEquals(100, array.get(1, 2, 3));
        assertEquals(200, array.get(5, 1, 0));
        assertEquals(300, array.get(20, 10, 7));
    }

    @Test
    void anyNumberOfDimensions() {
        DynArray_2<String> array = new DynArray_2<>(2, 2, 2, 2, 2);
        array.set("value", 1, 2, 3, 4, 5);
        assertEquals("value", array.get(1, 2, 3, 4, 5));
    }

    @Test
    void nullForUnsetCell() {
        DynArray_2<Integer> array = new DynArray_2<>(2, 2, 2);
        assertNull(array.get(0, 0, 0));
    }

    @Test
    void expandFirstDimension() {
        DynArray_2<Integer> array = new DynArray_2<>(1, 1);
        array.set(42, 100, 0);
        assertEquals(42, array.get(100, 0));
    }

    @Test
    void expandLastDimension() {
        DynArray_2<Integer> array = new DynArray_2<>(1, 1);
        array.set(42, 0, 100);
        assertEquals(42, array.get(0, 100));
    }

    @Test
    void expandAllDimensionsIndependently() {
        DynArray_2<String> array = new DynArray_2<>(1, 1, 1);
        array.set("result", 50, 100, 150);
        assertEquals("result", array.get(50, 100, 150));
        assertNull(array.get(50, 100, 149));
        assertNull(array.get(49, 100, 150));
    }
}

