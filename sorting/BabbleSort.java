package sorting;

public class BabbleSort {

	public static void  main (String[] arg){
		int[] a = {5,4,3,2,1,6};
		boolean isSwaped = true;
		while(isSwaped){
			isSwaped = false;
			for(int i=0;i<a.length-1;i++){
				if(a[i]>a[i+1]){
					int temp = a[i];
					a[i] =a[i+1];
					a[i+1] = temp;
					isSwaped = true;;
				}
			}
			
		}
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		
	}
}
