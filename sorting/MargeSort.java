package sorting;

public class MargeSort {
	
	public void marge(int [] arr,int l ,int m,int r){
		
		//size of two array
		
		int n1 = m-l+1;
		int n2 = r-m;
		
		// create two temporaray array
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		//copy Data to temporary array
		for(int i=0;i<n1;++i){
			L[i] = arr[l+i];
		}
		
		for(int j=0;j<n2;++j){
			R[j] = arr[m+j+1];
		}
		
		/*Marge the temporary arrays */
		//initial index of left and right subarrays
		int i=0 , j = 0;
		
		//initial index of marged subarrays
		int k =l;
		while(i<n1 && j<n2){
			if(L[i]<=R[j]){
				arr[k] = L[i];
				i++;
			}
			else{
				arr[k] = R[j];
				j++;
			}
			
			k++;
		}
		
		while(i<n1){
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j<n2){
			arr[k] = R[j];
			j++;
			k++;
		}
		
		
		
	}
	
	public void sort(int[] arr,int l,int r){
		if(l<r){
			int mid =(l+r)/2;
			
			sort(arr, l, mid);
			sort(arr,mid+1,r);
			
			marge(arr, l, mid, r);
		}
	}
	
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] arg){
		int[] a = {12, 11, 13, 5, 6, 7};
		System.out.println("GiVen Array");
		printArray(a);
		
		MargeSort ob = new MargeSort();
		
		ob.sort(a, 0, a.length-1);
		
		System.out.println("Sorted Array");
		printArray(a);
	}

}
