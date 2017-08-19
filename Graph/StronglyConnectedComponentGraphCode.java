/*
 *In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
 */
package Graph;

import java.io.*;

import java.util.*;


 

class StronglyConnectedComponentGraphCode
{
    private int verticesNumber;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List
    int count =0;
 
    //Constructor
    StronglyConnectedComponentGraphCode(int v)
    {
        verticesNumber = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    //Function to add an edge into the graph
    void addEdge(int u, int v )  { 
    	adj[u].add(v);
    	
    	}
 
   void dfs(int s,boolean[] visited){
	   visited[s] = true;
	   System.out.print(s+" ");
	   
	   Iterator<Integer> it = adj[s].listIterator();
	   
	   while(it.hasNext()){
		   int n = it.next();
		   if(!visited[n]){
			   dfs(n, visited);
		   }
	   }
	   
   }
   
   StronglyConnectedComponentGraphCode getRevers(){
	   StronglyConnectedComponentGraphCode reverse = new StronglyConnectedComponentGraphCode(verticesNumber);
	   
	   for(int i=0;i<verticesNumber;i++){
		   Iterator<Integer> it = adj[i].listIterator();
		   
		   while(it.hasNext()){
			   reverse.adj[it.next()].add(i);
		   }
	   }
	   return reverse;
   }
   
   void topologocalSort(int s,boolean[] visited,Stack<Integer> stack){ 
	   visited[s] = true;
	   
	   Iterator<Integer> it = adj[s].listIterator();
	   
	   while(it.hasNext()){
		   int n = it.next();
		   
		   if(!visited[n]){
			   topologocalSort(n, visited, stack);
		   }
	   }
	   
	   stack.push(s);
	   
   }
   
   void printSCCs(){
	   Stack<Integer> statck = new Stack<>();
	   boolean[] isVisited = new boolean[verticesNumber];
	   
	   for(int i =0;i<verticesNumber;i++){
		   
		   if(!isVisited[i]){
			   topologocalSort(i, isVisited, statck);
		   }
	   }
	   
	   
	   StronglyConnectedComponentGraphCode rev = getRevers();
	   
	   for(int i =0;i<isVisited.length;i++){
		   isVisited[i] = false;
	   }
	   
	   while(statck.size()!=0){
		   int n = statck.pop();
		   
		   if(!isVisited[n]){
			   rev.dfs(n, isVisited);
			   count++;
			   System.out.println();
		   }
		   
		   
	   }
	   System.out.println();
   }
 
    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        StronglyConnectedComponentGraphCode ob = new StronglyConnectedComponentGraphCode(5);
        ob.addEdge(0, 1);
		ob.addEdge(1, 4);
		ob.addEdge(1, 2);
		ob.addEdge(2, 3);
		ob.addEdge(3, 2);
		ob.addEdge(2, 0);
		
 
        System.out.println("Following are strongly connected components "+
                           "in given graph ");
        ob.printSCCs();
        System.out.println("Number of stronglyConnected component "+ob.count);
    	
   
    	
    }
}