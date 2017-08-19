package Coursera.UninonFind;

import java.util.Scanner;

public class QuickUnionModified {

	int id[];
	int sz[];
	public QuickUnionModified(int n) {
		// TODO Auto-generated constructor stub
		id = new int[n];
		sz = new int[n];
		for(int i=0;i<n;i++){
			id[i] = i;
			sz[i] =i;
		}
	}
	
	private int root(int i){
		while(i!=id[i]){
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p,int q){
		return root(p)==root(p);
		
	}
	/*
	 * Link root of smaller tree to root of larger tree.
	 * Update the sz[] array.
	 */
	public void union(int p,int q){
		
		int i = root(p);
		int j = root(q);
		if(i==j){
			return;
		}
		
		if(sz[i]<sz[j]){
			
			id[i] =j;
			sz[j]+=sz[i];
			
		}
		else{
			id[j] = i;
			sz[i]+=sz[j];
		}
	}
	
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		QuickUnionModified ob = new QuickUnionModified(26);
		while(true){
			
		   String in = sc.nextLine();
		   
		   if(in.contains("*")){
			   break;
		   }
		 char[] ch = in.toCharArray();
		   int a = (int)ch[0]-65;
		   int b = (int)ch[2]-65;
		   
		   if(ob.root(a)!=ob.root(b)){
			 ob.union(a, b);
		   }
		   
		   
		   
		}
		
		for(int i=0;i<ob.id.length;i++){
			   System.out.println(ob.id[i]);
		   }
	}
}
