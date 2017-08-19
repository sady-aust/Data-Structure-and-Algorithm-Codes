/*
 *In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
 */

				
package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class DijkstraAlgorithm {
	static class Edge{
		int to,weight;
		
		Edge(int v,int w){
			to = v;
			weight = w;
			
		}
		
	}
	
	static class Node implements Comparable<Node>{

		int node,dist,parent;
		Node(int node,int dist,int parent){
			this.node = node;
			this.parent = parent;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			if(dist== o.dist){
				return Integer.compare(node, o.node);
			}
			
			return Integer.compare(dist, o.dist);
		}
		
	}
	
	static List<Edge> adj[];
	int t;
	static int node,edges;
	static int[] distance;
	static Scanner sc = new Scanner(System.in);
	
	
	static void CreateGraph(){
		adj = new ArrayList[node];
		
		for(int i=0;i<node;i++){
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0;i<edges;i++){
			int from,to,weight;
			from = sc.nextInt()-1;
			to = sc.nextInt()-1;
			weight = sc.nextInt();
			
			adj[from].add(new Edge(to, weight));
			adj[to].add(new Edge(from, weight));
			
		}
	}
	
	static void findShortestPath(int start){
		distance = new int[node];
		
		for(int i=0;i<node;i++){
			distance[i] = Integer.MAX_VALUE;
		}
		TreeSet<Node> set = new TreeSet<>();
		
		distance[start] = 0;
		set.add(new Node(start, 0, -1));
		
		while(set.size()>0){
			Node curr = set.pollFirst();
			
			for(Edge edge: adj[curr.node]){
				if(distance[curr.node]+edge.weight<distance[edge.to]){
					set.remove(new Node(edge.to, distance[edge.to], -1));
					
					distance[edge.to] = distance[curr.node]+edge.weight;
					set.add(new Node(edge.to, distance[edge.to], curr.node));
				}
			}
		}
	}
	
	public static void main(String[] arg){
		System.out.println("Enter the Number of Nodes  You want in the graph: ");
		node = sc.nextInt();
		System.out.println("Enter the number of Edge: ");
		edges = sc.nextInt();
		CreateGraph();
		findShortestPath(0);
		System.out.println("The Shortes path to all nodes from 0 is ");
		for(int i=0;i<node;i++){
			System.out.println(i+" : "+distance[i]);
		}
		
		
	}

}
