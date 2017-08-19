/*
 *In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
 */

/*
 * Following is a simple algorithm to find out whether a given graph 
 * is Birpartite or not using Breadth First Search (BFS).
 * 
1.	Assign RED color to the source vertex (putting into set U).
2.	Color all the neighbors with BLUE color (putting into set V).
3.	Color all neighbor’s neighbor with RED color (putting into set U).
4.	This way, assign color to all vertices such that it satisfies all the
 	constraints of m way coloring problem where m = 2.
5.  While assigning colors, if we find a neighbor which is colored with same
 	color as current vertex, then the graph cannot be colored with 2 vertices 
 	(or graph is not Bipartite)				
 */
package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BipartiteGraph {
	
	int v;
	List<Integer> adj[];
	
	/**
	 * 
	 */
	public BipartiteGraph(int n) {
		// TODO Auto-generated constructor stub
		v = n;
		adj = new LinkedList[n];
		
		for(int i=0;i<n;i++){
			adj[i] = new LinkedList<>();
		}
	}
	
	void addEdgee(int u,int v){
	adj[u].add(v);
	adj[v].add(u);
	}

	boolean isBipaertite(int src){
		
		/*
		 * Create a color array for keeping color record]
		 * Vertix number is used as index
		 * at first asiign all the vertices ccolor as -1.
		 * the value 1 is used to indicate first Color
		 * the value 0 is used to indicate second color
		 */
		int[] colorArr = new int[v];
		
		for(int i=0;i<v;i++){
			colorArr[i] = -1;
		}
		
		//Assinging first color to the source
		colorArr[src] = 1;
		
		//run while there is a vertices in Queue
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		while(queue.size()!=0){
			int  u = queue.poll();
			
			//return false if there is a self loop
			if(adj[u].contains(u)){
				return false;
			}
			
			//find all non color adjecnt vertices
			Iterator<Integer> it = adj[u].listIterator();
			while(it.hasNext()){
				int n = it.next();
				//AN edge from u to v is exists and v is not colored
				if(adj[u].contains(n) && colorArr[n]==-1){
					//Assigning alternative color to this adjacent  v of u
					colorArr[n] = 1-colorArr[u];
					queue.add(n);
				}
				
				//An Edge from u to v is exists and destinition colored with same color as  u
				else if(adj[u].contains(n) && colorArr[n]==colorArr[u]){
					return false;
				}
			}
		}
		
		//If we reach here then all adject vertices can be colored with with an alternative color
		return true;
	}
	
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		BipartiteGraph  g = new BipartiteGraph(n);
		for(int i=0;i<m;i++ ){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			g.addEdgee(a, b);
		}
		
		System.out.println(g.isBipaertite(0));
	}
}
