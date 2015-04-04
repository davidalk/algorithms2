package uk.co.alkanani.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

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
        assertTrue(allNodesAreInTheSameSet(Arrays.asList(node1, node2, node3)));
    }

    @Test
    public void nodeGroupsUnionCorrectly() {
        // given
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        // when
        node1.union(node2);
        node2.union(node3);

        node4.union(node5);
        node5.union(node6);

        node5.union(node3);

        // then
        List<Node> nodes = Arrays.asList(node1, node2, node3, node4, node5, node6);
        assertTrue(allNodesAreInTheSameSet(nodes));
    }

    @Test
    public void preservesDisjointGroups() {
        // given
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        // when
        node1.union(node2);
        node2.union(node3);

        node4.union(node5);
        node5.union(node6);

        // then
        List<Node> nodes = Arrays.asList(node1, node2, node3, node4, node5, node6);
        assertFalse(allNodesAreInTheSameSet(nodes));
    }

    private boolean allNodesAreInTheSameSet(List<Node> nodes) {
        Node set = nodes.get(0).findSet();

        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i).findSet() != set) {
                return false;
            }
        }

        return true;
    }


}