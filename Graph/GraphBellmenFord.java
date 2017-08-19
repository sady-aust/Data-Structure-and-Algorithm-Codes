/*
 *In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
 */

				
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GraphBellmenFord {
	
	static class Edge{
		int u,v,w;
		
		Edge(int u,int v,int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	int verticesNumber,edgeNumber;
	List<Edge> edges = new ArrayList<>();
	
	
	public GraphBellmenFord(int v,int e) {
		verticesNumber = v;
		edgeNumber = e;
		
	}
	
	void bellMenFord(GraphBellmenFord graph,int src){
		
		int totalVertices = graph.verticesNumber;
		int totalEdges = graph.edgeNumber;
		
		int[] dist = new int[totalVertices];
		
		for(int i=0;i<totalVertices;i++){
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[src] = 0;
		
		for(int i=0;i<totalVertices-1;i++){
			for(int j=0;j<totalEdges;j++){
				int u = graph.edges.get(j).u;
				int v = graph.edges.get(j).v;
				int w = graph.edges.get(j).w;
				
				if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+w){
					dist[v] = dist[u]+w;
				}
				
				
			}
		}
		
		for(int j=0;j<totalEdges;j++){
			int u = graph.edges.get(j).u;
			int v = graph.edges.get(j).v;
			int w = graph.edges.get(j).w;
			
			if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+w){
				System.out.println("Graph Contain Negative weight cycle");
			}
		}
		
		printArr(dist, verticesNumber);
			
		
	}

	/**
	 * @param dist
	 * @param verticesNumber2
	 */
	void printArr(int[] dist, int verticesNumber) {
		
		System.out.println("Vertex Distance From source");
		
		for(int i=0;i<verticesNumber;i++){
			System.out.println(i+"          "+dist[i]);
		}
	}
	
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		GraphBellmenFord g = new GraphBellmenFord(v, e);
		
		for (int i=0;i<e;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			Edge edge = new Edge(a, b, c);
			g.edges.add(edge);
			
		}
		
		g.bellMenFord(g, 0);
	}
	
	

}
