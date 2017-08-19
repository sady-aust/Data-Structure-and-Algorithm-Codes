/*
 *In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
 */

				
package Graph;

import java.util.*;

public class TopoLogicalSortUsingDFS {

	int verticesNumber;
	LinkedList<Integer> adj[];
	Stack<Integer> statck = new Stack<>();
	int cycle =0;
	
	
	
	public TopoLogicalSortUsingDFS(int n){
		verticesNumber = n;
		adj = new LinkedList[verticesNumber];
		for(int i=0;i<verticesNumber;i++){
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdgee(int u,int v){
		adj[u].add(u);
	}
	
	//a function for travarse the graph by DFS and put the elemt into Stack
	public void fuctionForTraversal(int s,boolean[] visited,Stack<Integer> stack){
		
		visited[s] = true;
		
		Iterator<Integer> it = adj[s].listIterator();
		
		while(it.hasNext()){
			int n = it.next();
			if(!visited[n]){
				fuctionForTraversal(n, visited, stack);
			}
		}
		
		stack.push(s);
	}
	
	//function for Topological sort
	public void topologicalSort(){
		
		boolean[] isVisited = new boolean[verticesNumber];
		Stack<Integer> stack = new Stack<>();
		
		for(int i =0;i<verticesNumber;i++){
			if(!isVisited[i]){
				fuctionForTraversal(i, isVisited, stack);
			}
		}
		
		while(stack.size()!=1){
			System.out.print(stack.pop()+" ");
		}
	}
	
	
		
	
	public static void main(String[] arg){
		
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		TopoLogicalSortUsingDFS ts = new TopoLogicalSortUsingDFS(n);
		
		for(int i =0;i<n;i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			ts.addEdgee(u, v);
		}
	        
	       
	       
	        
	       ts.topologicalSort();
		
	       
	        
	      
	      
	}
}
