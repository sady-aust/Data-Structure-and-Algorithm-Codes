/*
 *In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
 */

				
package Graph;

public class FloyedWarshalALgo {

	int v =4;
	static int Inf = 9999;
	int[][] dist = new int[v][v];
	void FloyedWarshal(int graph[][]){
		
		  for (int i = 0; i < v; i++){
	            for (int j = 0; j < v; j++){
	                dist[i][j] = graph[i][j];
	            }
		  }
		  
		  
		  for(int i=0;i<v;i++){
			  for(int j=0;j<v;j++){
				  for(int k=0;k<v;k++){
					  
					  dist[i][j] = Math.min(dist[i][j], dist[i][j]+dist[k][j]);
				  }
				  
			  }
		  }
		  
		  printSolution(dist);
		
	}
	
	void printSolution(int dist[][])
    {
        System.out.println("Following matrix shows the shortest "+
                         "distances between every pair of vertices");
        for (int i=0; i<v; ++i)
        {
            for (int j=0; j<v; ++j)
            {
                if (dist[i][j]==Inf)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
	
	public static void main(String[] arg){
		
		 int graph[][] = { {0,   5,  Inf, 10},
                 {Inf, 0,   3, Inf},
                 {Inf, Inf, 0,   1},
                 {Inf, Inf,Inf, 0}
               };
		 
		 FloyedWarshalALgo ob = new FloyedWarshalALgo();
		 ob.FloyedWarshal(graph);
	}
}
