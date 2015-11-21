package V01;


public class Node {
	private Object data;
	private Node next;
	
	public Node(Object data,Node next) {
		this.data = data;
		this. next = next;
	}
	
	public Object getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public String toString() {
		if (next == null) 
			return (String) data;
		else 
			return data + ", " +  next.toString();
	}
	
	public static Node fromString(String inputString) {
		String[] content = inputString.split(",");
		Node result = null;
		for (int i=content.length-1;i>=0;i--){
			result = new Node(content[i].trim(),result);		
		}
		return result;
	}
	
	public static Node deletingNode(Node startNode, Object toDeletingNode){
		return deletingNode02(startNode, null,startNode,toDeletingNode);
	}
	
	private static Node deletingNode02(Node startOfList, Node previousNode, Node currentNode, Object toDeletingNode) {
		if (startOfList == currentNode)
			if (currentNode.getData() == toDeletingNode)
				return currentNode.getNext();
			else 
				return deletingNode02(startOfList,currentNode,currentNode.getNext(),toDeletingNode);
		else 
			if (currentNode.getData() == toDeletingNode){
				previousNode.next = currentNode.getNext();
				return startOfList;
			}
			else
				if (currentNode.getNext() == null)
					return startOfList;
				else
					return deletingNode02(startOfList,currentNode,currentNode.getNext(),toDeletingNode);

	}
	
	public Node reverse() {
		Node resultNode = Node.reverseLinkedList(null, this);
		return resultNode;
	}

	private static Node reverseLinkedList(Node previousNode, Node node) {
		if (node.getNext() == null){
			node.next = previousNode;
			return node;
		}
		else {
			Node reminder = node.getNext();
			node.next = previousNode;
			return Node.reverseLinkedList(node,reminder);
		}
	}
	
	
}
