package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableArrayList arrayLst, test_arr;

    @Before
    public void setUp() {
        arrayLst = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
    }

    @Test
    public void testAdd() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, arrayLst.add(5).toArray());
        assertArrayEquals(new Object[]{0, 1, 2, 3, 4}, arrayLst.add(0, 0).toArray());
    }

    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6}, arrayLst.addAll(new Object[] {5, 6}).toArray());
        assertArrayEquals(new Object[]{0, 1, 1, 2, 3, 4}, arrayLst.addAll(0, new Object[] {0, 1}).toArray());
    }

    @Test (expected =  IllegalArgumentException.class)
    public void testAddAllFail1() {
        ImmutableArrayList newLst = (ImmutableArrayList) arrayLst.addAll(-5, new Object[]{5, 6});
    }

    @Test (expected =  IllegalArgumentException.class)
    public void testAddAllFail2() {
        ImmutableArrayList newLst = (ImmutableArrayList) arrayLst.addAll(10, new Object[]{5, 6});
    }

    @Test
    public void testGet() {
        assertEquals(4, arrayLst.get(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFail1() {
        Object ans = arrayLst.get(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFail2() {
        Object ans = arrayLst.get(-10);
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[] {2, 3, 4}, arrayLst.remove(0).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFail() {
        ImmutableArrayList newLst = (ImmutableArrayList) arrayLst.remove(20);
    }

    @Test
    public void testSet() {
        assertArrayEquals(new Object[] {0, 2, 3, 4}, arrayLst.set(0, 0).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFail() {
        ImmutableArrayList newLst = (ImmutableArrayList) arrayLst.set(20, 5);
    }

    @Test
    public void testIndexOf() {
        assertEquals(2, arrayLst.indexOf(3));
        assertEquals(-1, arrayLst.indexOf(5));
    }

    @Test
    public void testSize() {
        assertEquals(4, arrayLst.size());
    }

    @Test
    public void testClear() {
        assertEquals(4, arrayLst.clear().size());
        assertNull(arrayLst.clear().get(1));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(new ImmutableArrayList().isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Object[]{1, 2, 3, 4}, arrayLst.toArray());
    }
}
