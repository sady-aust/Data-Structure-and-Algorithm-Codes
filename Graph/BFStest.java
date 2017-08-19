package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * void bfs(node start) {
 queue<node> s;
 s.push(start);
 mark start as visited
 while (s.empty() == false) {
  top = s.front();
  s.pop();

  check for termination condition (have we reached the node we want to?)

  add all of top's unvisited neighbors to the queue
  mark all of top's unvisited neighbors as visited
 }
}
 */
public class BFStest {
	private int verticesNumber ;
	private LinkedList<Integer> adj[];
	int[] dest ;
	
	public BFStest(int v){
		this.verticesNumber = v;
		
		adj  = new LinkedList[v];
		dest = new int[v+1];
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int vertices,int weight){
		adj[vertices].add(weight);
	}
	
	public void BFS(int source){
		boolean isVisited[] = new boolean[verticesNumber];
		
		
		Queue<Integer> queue = new LinkedList();
		
		
		isVisited[source] = true;
		queue.add(source);
		
	
		
		while(queue.size()!=0){
			int n = queue.poll();
			System.out.print(n+" ");
			
			Iterator<Integer> it = adj[n].listIterator();
			while(it.hasNext()){
				int value = it.next();
				
				if(!isVisited[value]){
					
					dest[value] = dest[n]+1; // for keeping the level of each node
					
					isVisited[value] = true;
					queue.add(value);
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] arg){
		BFStest g = new BFStest(5);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(2, 4);
		g.addEdge(4,3);
		g.addEdge(1,3);

		
		g.BFS(1);
		
		System.out.println();
		
		for(int i=1;i<g.dest.length-1;i++){
			System.out.print(g.dest[i]+" ");
		}
	}
	

}
