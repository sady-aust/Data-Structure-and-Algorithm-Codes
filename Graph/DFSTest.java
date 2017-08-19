package Graph;
/*
 * dfs(node start) {
 stack<node> s;
 s.push(start);
 while (s.empty() == false) {
  top = s.top();
  s.pop();

  if (top is not marked as visited) {
   check for termination condition (have we reached the node we want to?)

   mark top as visited;
   add all of top's neighbors to the stack.
  }
 }
}
 */
import java.util.Iterator;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class DFSTest {
	
	private int vertices;
	private LinkedList<Integer> adj[];
	
	public DFSTest(int verticesNumber) {
		vertices = verticesNumber;
		adj = new LinkedList[verticesNumber];
		for(int i=0;i<verticesNumber;i++){
			adj[i] = new LinkedList<>();
		}
		
	}
	
	public void addEdge(int v,int w){
		adj[v].add(w);
	}
	
	public void DFS(int s){
		boolean[]  isVisited = new boolean[vertices];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(s);
		while(!stack.empty()){
			s = stack.pop();
			//System.out.println("pop "+s);
			if(!isVisited[s]){
				System.out.print(s+" ");
				isVisited[s] = true;
			}                                                         
			
			Iterator<Integer> it = adj[s].listIterator();
			
			while(it.hasNext()){
				int n = it.next();
				if(!isVisited[n]){
					stack.push(n);
				///	System.out.println("push "+n);
				}
				//System.out.println("Stack "+stack);
			}
		}
	}
	
	public static void main(String[] arg) {
		DFSTest  g = new DFSTest(100);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 3);
		g.addEdge(3, 1);
		    
			        System.out.println("Following is Depth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        g.DFS(4);
		
		
	}
}
