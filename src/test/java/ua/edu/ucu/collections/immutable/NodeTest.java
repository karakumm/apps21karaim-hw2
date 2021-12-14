package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    Node nextNode;
    Node previousNode;

    @Before
    public void setUp(){
        nextNode = new Node();
        previousNode = new Node();
        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);
        nextNode.setValue(1);
        previousNode.setValue(2);
    }

    @Test
    public void testToString() {
        assertEquals("1", nextNode.toString());
    }

    @Test
    public void getPrevious() {
        assertEquals(previousNode, nextNode.getPrevious());
    }

    @Test
    public void setPrevious() {
        previousNode.setPrevious(nextNode);
        assertEquals(nextNode, previousNode.getPrevious());
    }

    @Test
    public void getValue() {
        assertEquals(2, previousNode.getValue());
    }

    @Test
    public void setValue() {
        previousNode.setValue(5);
        assertEquals(5, previousNode.getValue());
    }

    @Test
    public void getNext() {
        assertEquals(nextNode, previousNode.getNext());
    }

    @Test
    public void setNext() {
        nextNode.setNext(previousNode);
        assertEquals(previousNode, nextNode.getNext());
    }
}