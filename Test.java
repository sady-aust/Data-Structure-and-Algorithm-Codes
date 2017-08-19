
public class Test {
	
	Node head; //head of a link list

	/*
	 * Creating the Node
	 */
	
	public void printList(){
	   Node n = head;
	   
	   while(n!= null){
		   System.out.println(n.data + " ");
		   n = n.next;
	   }
	}
	public static class Node{
		int data;
		Node next;
		
		public Node(int i){
			data = i;
		}
	}
	/*
	 * count the number of node in link list
	 */
	public void countNumberOfNode(){
		int count =0;
		Node temp = head;
		while(temp!=null){
			temp= temp.next;
			count++;
			
		}
		System.out.println("The number of node "+ count);
		
	}
	/*
	 * Count the number of node using recursion
	 */
	
	public int countNodeRec(Node node){
		//base case
		if(node== null){
			return 0;
			
		}
		
		//count this node plus rest of the node
		return 1+countNodeRec(node.next);
	}
	
	//wrapper over countNodeRec
	public int getCountnodeRec(){
		return countNodeRec(head);
		
	}
	
	
	public static void main(String arg[]){
		Test list = new Test();
		/*
		 * creating link list
		 */
		list.head = new Node(8);
		Node second  = new Node(9);
		Node third = new Node(10);
		
		/*
		 * Connecting the link list
		 */
		list.head.next = second;
		second.next = third;
		
		/*
		 * PRINT the link list
		 */
		
		list.printList();
	
		list.countNumberOfNode();
		System.out.println("Number of node using recurssion "+list.getCountnodeRec());
		
		
		
	}
	
	
}
