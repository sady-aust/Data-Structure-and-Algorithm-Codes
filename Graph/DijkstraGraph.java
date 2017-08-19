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

public class DijkstraGraph {

	
	
	int verticesNmbr,EdgeNmbr;
	
	/**
	 * 
	 */
	public DijkstraGraph(int v,int e) {
		verticesNmbr = v;
		EdgeNmbr = e;
		
		
		
	}
	
	
	
	int extract_Min(int[] dist,boolean[] sptSet){
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		
		for(int i=0;i<verticesNmbr;i++){
			if(!sptSet[i] && dist[i]<=min){
				min = dist[i];
				min_index = i;
			}
		}
		return min_index;
	}
	
	void Dijksta(int[][] graph,int src){
		
		int[] dist = new int[verticesNmbr];
		
		boolean[] sptSet  = new boolean[verticesNmbr];
		
		
		for(int i=0;i<verticesNmbr;i++){
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		
		for(int i=0;i<verticesNmbr-1;i++){
			int u = extract_Min(dist, sptSet);
			sptSet[u] = true;
			
			for(int j=0;j<verticesNmbr;j++){
				
				if(!sptSet[j]  && dist[u]+graph[u][j]<dist[j] && dist[u]!=Integer.MAX_VALUE && graph[u][j]!=0){
					dist[j] = dist[u]+graph[u][j];
				}
			}
		}
		
		print_Dist(dist);
	}
	
	void print_Dist(int[] dist){
		System.out.println("Vertices Distance from Source");
		for(int i=0;i<verticesNmbr;i++){
			System.out.println(i+"        "+dist[i]);
		}
	}
	
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		DijkstraGraph g = new DijkstraGraph(n, m);
	
		int[][] graph = new int[][]{{0,3,1,2,9},
									{7,3,4,9,9},
									{1,7,5,5,3},
									{2,3,4,2,5},
			};
									
								
								g.Dijksta(graph, 0);
	}
}
