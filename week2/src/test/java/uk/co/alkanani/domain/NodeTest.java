package uk.co.alkanani.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class NodeTest {

    @Before
    public void setUp() {

    }

    @Test
    public void individualNodesUnionCorrectly() {
        // given
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        // when
        node1.union(node2);
        node2.union(node3);
        // then
        assertTrue(node1.findSet() == node2.findSet()
                && node2.findSet() == node3.findSet()
                && node1.findSet() == node3.findSet());
    }
}