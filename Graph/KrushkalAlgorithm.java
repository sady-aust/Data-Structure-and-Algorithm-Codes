package Graph;

import java.util.*; 
class KrushkalAlgorithm
{
  
	class Edge{
		int source,desti,weight;
		
		
	}
	
	class Subset{
		int parent,rank;
	}
	
	
	/**
	 * 
	 */
	Edge[] edge;
	int v ,e;
	public KrushkalAlgorithm(int verticesNmbr,int edgeNmbr) {
		v = verticesNmbr;
		e = edgeNmbr;
		edge = new Edge[edgeNmbr];
		
		for(int i=0;i<edgeNmbr;i++){
			edge[i] = new Edge();
		}
	}
	
	
	int find_root(Subset[] subset,int i){
		
		if(i!=subset[i].parent){
			subset[i].parent = find_root(subset, subset[i].parent);
		}
		
	return	subset[i].parent;
	}
	
	void Union(int x,int y,Subset[] subset){
		int xroot = find_root(subset, x);
		int yroot = find_root(subset, y);
		
		
		if(subset[xroot].rank<subset[yroot].rank){
			subset[xroot].parent = yroot;
		}
		
		else if(subset[yroot].rank<subset[xroot].rank){
			subset[yroot].parent = xroot;
		}
		
		else{
			subset[yroot].parent = xroot;
			subset[xroot].rank++;
		}
		
	}
	
	void sort(int arr[])
    {
		int length = arr.length;
		
		for(int i=1;i<length;i++){
			 int key = arr[i];                      
			 int j= i-1;
			 while(j>=0 && key<arr[j]){              
				  
				 arr[j+1] = arr[j];                  
				 j = j-1;                            
			 }
			 arr[j+1]= key;                          
			                                           
		}	                                           
			                                          
			                                           
		}
	
	public int krushkalMST(){
		Subset[] subsets = new Subset[v];
		
		for(int i=0;i<v;i++){
			subsets[i] = new Subset();
		}
		
		for(int i=0;i<v;i++){
			subsets[i].parent =i;
			subsets[i].rank=0;
		}
		
		int weights[] = new int[e];
		
		for(int i=0;i<edge.length;i++){
			weights[i] = edge[i].weight;
		}
		
		
		sort(weights);
		
		
	
		int ans =0;
		
		
		
		
		for(int i=0;i<edge.length;i++){
			
			
			for(int j=0;j<edge.length;j++){
				//System.out.println("Weights "+weights[i]);
				if(edge[j].weight == weights[i]){
					
					
					
					int  x = find_root(subsets, edge[j].source);
					int  y = find_root(subsets, edge[j].desti);
					 
					 if(x!=y){
							//System.out.println("Weight "+weights[i]);
							Union(x, y, subsets);
							ans+=weights[i];
							
						}
					 break;
				}
				
				
				
			}
			
			
			
		}
		
		return ans;
	}
	
	public static void main(String[] arg){
		
		KrushkalAlgorithm graph = new KrushkalAlgorithm(4, 5);
		
		  int V = 4;  // Number of vertices in graph
	        int E = 5;  // Number of edges in graph
	     
	 
	        // add edge 0-1
	        graph.edge[0].source = 0;
	        graph.edge[0].desti = 1;
	        graph.edge[0].weight = 7;
	 
	        // add edge 0-2
	        graph.edge[1].source = 0;
	        graph.edge[1].desti = 3;
	        graph.edge[1].weight = 6;
	 
	        // add edge 0-3
	        graph.edge[2].source = 3;
	        graph.edge[2].desti = 1;
	        graph.edge[2].weight = 9;
	 
	        // add edge 1-3
	        graph.edge[3].source = 3;
	        graph.edge[3].desti = 2;
	        graph.edge[3].weight = 8;
	 
	        // add edge 2-3
	        graph.edge[4].source = 2;
	        graph.edge[4].desti = 6;
	        graph.edge[4].weight = 6;
	 
	        //graph.KruskalMST();
	       System.out.println("SUm OF Cost "+ graph.krushkalMST());
	       // graph.krushkalMST();
		
	}
    
}