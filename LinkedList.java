
/*
 * Author Toufiqul Islam
 * Linked list Insertion
 */

import javax.swing.text.Position;

public class LinkedList {

	Node head; // head of the link list

	public static class Node {
		int data;
		Node next;

		public Node(int d) {
			data = d;
		}
	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.println(n.data + " ");
			n = n.next;
		}
	}

	/*
	 * Insert a new node in the front of link list
	 */
	public void InsertInFront(int data) {
		Node node = new Node(data);
		node.next = head;
		/*
		 * making head node pointing to the 'node'
		 */
		head = node;
	}
	/*
	 * Insert after a given Node
	 */

	public void insertAfter(Node previousNode, int data) {
		// check if previous Node is null or not
		if (previousNode == null) {
			System.out.println("Your Given Node is Null");
		} else {
			Node node = new Node(data); // creating new node
			node.next = previousNode.next;
			previousNode.next = node;
		}
	}
	/*
	 * insert at the tail of a link list
	 */

	public void insertTail(int data) {
		Node node = new Node(data);
		if (head == null) { // if the head is null
			head = node;
		}
		node.next = null;
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = node;
	}

	/*
	 * Insert at a specific position
	 */
	public void inserNodeAtSpecificPosotion(int data, int position) {
		// 2 5 6
		Node node = new Node(data);
		if (position == 0) {
			node.next = head;
			head = node;
		} else {
			Node track = head;
			int j = 0;
			while (j != position - 1) {
				track = track.next;
				j++;
			}
			node.next = track.next;
			track.next = node;
		}
	}

	/*
	 * Delete any node
	 */
	public void deleteNode(int key) {
		Node temp = head;
		Node prev = null;
		if (temp.data == key) {
			head = temp.next;
		} else {
			while (temp.data != key) {
				prev = temp;
				temp = temp.next;
			}

			prev.next = temp.next;
		}

	}

	/*
	 * Delete Node at a given position
	 */

	public void deleteNodePosition(int position) {

		if (position == 0) {
			head = head.next;
		} else {
			Node temp = head;
			Node prev = null;

			for (int i = 0; i < position; i++) {
				prev = temp;
				temp = temp.next;
			}
			prev.next = temp.next;
		}
	}

	/*
	 * Count the number of nodes in the link list
	 */

	public void countNode() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}

		System.out.println("The Number of Node " + count);
	}

	/*
	 * count the number of node using recurssion
	 */
	public int countNodeRec(Node node) {
		// Base case
		if (node == null) {
			return 0;
		}

		// count this node plus rest of the list
		return 1 + countNodeRec(node.next);
	}

	/*
	 * Wrapper over getCountRec()
	 */
	public int getcountNodeRec() {
		return countNodeRec(head);
	}

	/*
	 * Searchiong any data on link list
	 */

	public boolean isfound(Node head, int x) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == x) {
				return true; // data found

			}

			temp = temp.next;

		}

		return false;

	}
	
	/*
	 * Swaping two node by changing link 
	 */
	
	public void swapNodes(int x,int y){
		//2 3 4 5 6 7
	  Node curX = head;
	  Node prevX= null;
	  
	  while(curX.data!= x){
		  prevX = curX;
		  curX = curX.next;
	  }
	  
	  Node curY = head;
	  Node prevY = null;
	  
	  while(curY.data!= y){
		  prevY = curY;
		  curY = curY.next;
	  }
	  
	 if(prevX!=null){
		 prevX.next = curY;
	 }
	 if(prevY!= null){
		 prevY.next= curX;
		 
	 }
	 
	 Node  temp = curX.next;
	 curX.next = curY.next;
	 curY.next = temp;
	  
		
		
		
	}

	public static void main(String[] arg) {
		LinkedList list = new LinkedList();
		// creating three link list
		list.head = new Node(5);
		Node second = new Node(6);
		Node third = new Node(7);

		// connecting them
		list.head.next = second;
		second.next = third;

		list.printList();

		list.InsertInFront(10);

		System.out.println("After inserting inFront");
		list.printList();

		list.insertAfter(second, 22);
		System.out.println("Insert after previous node");
		list.printList();
		list.insertTail(16);
		System.out.println("After insering last");
		list.printList();
		// iNsert at a given position

		list.inserNodeAtSpecificPosotion(8, 3);
		System.out.println("After insering Specific position");
		list.printList();
		System.out.println("After Deletin");
		list.deleteNodePosition(6);
		list.printList();

		// Print the number of node
		list.countNode();

		// print the number of node using recurssion

		System.out.println("Number of node using Recurssion " + list.getcountNodeRec());

		// searching any data
		if(list.isfound(list.head, 10)){
			System.out.println("Data is Found in the lisk list");
		}
		else{
			System.out.println("Data is not found in the link list");
		}
		list.swapNodes(5, 6);
		list.printList();
	}
}
