package Coursera.UninonFind;

public class QuickUnion {

	int[] id;
	
	public QuickUnion(int N) {
		// TODO Auto-generated constructor stub
		id = new int[N];
		
		for(int i=0;i<N;i++){
			id[i] = i;
		}
		
		
	}
	
	public int root(int i){
		while(i!=id[i]){  //chase parent pointers until reach root
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p,int q){
		return (root(p)==root(q));  //check if p and q have same root
	}
	
	public void union(int p,int q){
		
		int i = root(p);
		int j = root(q);
		id[i] = j;  //change root of p to point to root of q
	}
	
}
