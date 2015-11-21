package V01;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testToStringWithOneNode() {
		Node testNode = new Node("a",null);
		assertEquals("a", testNode.toString());
	}

	@Test
	public void testToStringWithTwoNodes() {
		Node secondTestNode = new Node("b",null);
		Node firstTestNode = new Node ("a", secondTestNode);
		assertEquals("a, b",firstTestNode.toString());
	}
	
	@Test
	public void testToStringWithThreeNodes() {
		Node thirdTestNode = new Node ("c",null);
		Node secondTestNode = new Node("b",thirdTestNode);
		Node firstTestNode = new Node ("a", secondTestNode);
		assertEquals("a, b, c",firstTestNode.toString());
	}
	
	@Test
	public void testFromString() {
		Node testNode = Node.fromString("c, b, d");
		assertEquals("c, b, d", testNode.toString());
	}
	
	@Test
	public void testdeletingFirstNodeWithExactNode() {
		Node thirdTestNode = new Node ("c",null);
		Node secondTestNode = new Node("b",thirdTestNode);
		Node firstTestNode = new Node ("a", secondTestNode);
		Node resultNode = Node.deletingNode(firstTestNode,"a");
		assertEquals("b, c", resultNode.toString());
	}
	@Test
	public void testdeletingWhenThereIsNoMatsch() {
		Node thirdTestNode = new Node ("c",null);
		Node secondTestNode = new Node("b",thirdTestNode);
		Node firstTestNode = new Node ("a", secondTestNode);
		Node resultNode = Node.deletingNode(firstTestNode,"d");
		assertEquals("a, b, c", resultNode.toString());
	}
	@Test
	public void testdeletingLastNodeWithExactNode() {
		Node thirdTestNode = new Node ("c",null);
		Node secondTestNode = new Node("b",thirdTestNode);
		Node firstTestNode = new Node ("a", secondTestNode);
		Node resultNode = Node.deletingNode(firstTestNode,"c");
		assertEquals("a, b", resultNode.toString());
	}
	
	@Test
	public void testdeletingNodeWithExactNode() {
		Node thirdTestNode = new Node ("c",null);
		Node secondTestNode = new Node("b",thirdTestNode);
		Node firstTestNode = new Node ("a", secondTestNode);
		Node resultNode = Node.deletingNode(firstTestNode,"b");
		assertEquals("a, c", resultNode.toString());
	}
	
	@Test 
	public void testDeletingNodeWhenThereIsOnlyOneNode() {
		Node firstTestNode = new Node ("a", null);
		Node resultNode = Node.deletingNode(firstTestNode,"a");
		assertNull(resultNode);
	}
	
	@Test
	public void testReverse(){
		Node thirdTestNode = new Node ("c",null);
		Node secondTestNode = new Node("b",thirdTestNode);
		Node firstTestNode = new Node ("a", secondTestNode);
		Node resultNode = firstTestNode.reverse();
		assertEquals("c, b, a", resultNode.toString());
	}
	
	@Test
	public void testReverseWithOnlyOneNode(){
		Node testNode = new Node ("a",null);
		Node resultNode = testNode.reverse();
		assertEquals("a", resultNode.toString());
	}
}
