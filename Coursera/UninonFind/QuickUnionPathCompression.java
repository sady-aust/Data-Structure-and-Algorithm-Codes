package Coursera.UninonFind;

public class QuickUnionPathCompression {

	int[] id;
	int[] sz;
	
	public QuickUnionPathCompression(int n) {
		// TODO Auto-generated constructor stub
		id = new int[n];
		sz = new int[n];
		
		for(int i=0;i<n;i++){
			id[i] = i;
			sz[i] = i;
		}
	}
	
	public int root(int i){
		while(i!=id[i]){
			id[i] = id[id[i]];
			i = id[i];
		}
		
		
		return i;
	}
	
	public boolean connected(int p,int q){
		return root(p) == root(q);
	}
	
	public void union(int p,int q){
		int i = root(p);
		int j = root(q);
		
		if(i==j){
			return;
		}
		
		if(sz[i]<sz[j]){
			id[i] =j;
			sz[j] +=sz[i];
		}
		else{
			id[j] = i;
			sz[i] +=sz[j];
		}
		
	}
	
}
