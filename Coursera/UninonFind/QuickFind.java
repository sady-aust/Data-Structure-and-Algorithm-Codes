package Coursera.UninonFind;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class QuickFind {
	
	 int[] id;
	
	public QuickFind(int n){
		id = new int[n];
		
		for(int i=0;i<id.length;i++){
			id[i] = i; //set id of each object to itsself
		}
	
	}
	
	//check if id of p and q are in the same component
	public boolean connected (int p ,int q){
		return (id[p]== id[q]);
	}
	
	//change the first one by the second one 
	public  void union (int p ,int q){
		int pId = id[p];
		int qId = id[q];
		for(int i=0;i<id.length;i++){
			if(id[i]==pId){
				id[i] = qId;
			}
		}
	}
	
	public void print(){
		for(int i=0;i<id.length;i++){
			System.out.println(id[i]);
		}
	}
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		QuickFind ob = new QuickFind(6);
		
		int[] a= {0,0,2};
		int[] b={3,1,4};
		
		for(int i=0;i<a.length;i++){
			ob.union(a[i], b[i]);
		}
		ob.print();

	}
	
	

}
