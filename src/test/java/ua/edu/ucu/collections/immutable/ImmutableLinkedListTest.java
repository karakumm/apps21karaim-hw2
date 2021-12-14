package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList linkedLst;

    @Before
    public void setUp() {
        linkedLst = new ImmutableLinkedList(new Object[]{1, 2, 3, 4});
    }

    @Test
    public void testAdd() {
        assertArrayEquals(new Object[] {1, 2, 3, 4, 5}, linkedLst.add(5).toArray());
        assertArrayEquals(new Object[] {1, 2, 5, 3, 4}, linkedLst.add(2, 5).toArray());
    }

    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[] {1, 2, 3, 4, 5, 6}, linkedLst.addAll(new Object[] {5, 6}).toArray());
        assertArrayEquals(new Object[] {1, 2, 3, 4, 5, 4}, linkedLst.addAll(3, new Object[] {4, 5}).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAllFail() {
        ImmutableList newLst = linkedLst.addAll(8, new Object[] {5, 6}); }

    @Test
    public void testGet() {
        assertEquals(3, linkedLst.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFail() {
        ImmutableList newLst = (ImmutableLinkedList) linkedLst.get(7);
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{2, 3, 4}, linkedLst.remove(0).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFail1() {
        ImmutableList newLst = (ImmutableLinkedList) linkedLst.remove(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFail2() {
        ImmutableList newLst = (ImmutableLinkedList) linkedLst.remove(-10);
    }

    @Test
    public void testSet() {
        assertArrayEquals(new Object[] {0, 2, 3, 4}, linkedLst.set(0, 0).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFail1() {
        ImmutableLinkedList newLst = (ImmutableLinkedList) linkedLst.set(5, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFail2() {
        ImmutableLinkedList newLst = (ImmutableLinkedList) linkedLst.set(-5, 6);
    }

    @Test
    public void testIndexOf() {
        assertEquals(linkedLst.indexOf(1), 0);
        assertEquals(linkedLst.indexOf(20), -1);
    }

    @Test
    public void testSize() {
        assertEquals(4, linkedLst.size());
    }

    @Test
    public void testClear() {
        assertEquals(4, linkedLst.clear().size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(linkedLst.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Object[]{1, 2, 3, 4}, linkedLst.toArray());
    }

    @Test
    public void testAddFirst() {
        assertArrayEquals(new Object[] {0, 1, 2, 3, 4}, linkedLst.addFirst(0).toArray());
    }

    @Test
    public void testAddLast() {
        assertArrayEquals(new Object[] {1, 2, 3, 4, 5}, linkedLst.addLast(5).toArray());
    }

    @Test
    public void testGetHead() {
        assertEquals(1, linkedLst.getHead().getValue());
    }

    @Test
    public void testGetTail() {
        assertEquals(4, linkedLst.getTail().getValue());
    }

    @Test
    public void testGetFirst() {
        assertEquals(1, linkedLst.getFirst());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFirstFail() {
        ImmutableLinkedList newLst = new ImmutableLinkedList();
        Object first = newLst.getFirst();
    }

    @Test
    public void testGetLast() {
        assertEquals(4, linkedLst.getLast());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLastFail() {
        ImmutableLinkedList newLst = new ImmutableLinkedList();
        Object last = newLst.getLast();
    }

    @Test
    public void removeFirst() {
        assertArrayEquals(new Object[] {2, 3, 4}, linkedLst.removeFirst().toArray());
    }

    @Test
    public void removeLast() {
        assertArrayEquals(new Object[] {1, 2, 3}, linkedLst.removeLast().toArray());
    }
}
