/*
 *In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
 */

				
package sorting;

public class HeapSort {
	
	public int left(int i){
		return 2*i+1;
	}
	
	public int right(int i){
		return 2*i+2;
	}
	
	public void swap(int i,int j,int[] arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public void max_Heapify(int[] arr,int heapSize,int parentIndex){
		
		int largest = parentIndex;
		
		int L = left(largest);
		int R = right(largest);
		
		
		if(L<heapSize && arr[L]>arr[largest]){
			largest = L;
		}
		
		if(R<heapSize && arr[R]>arr[largest]){
		    largest = R;	
		}
		
		
		if(largest!=parentIndex){
			
			swap(parentIndex, largest, arr);
			
			max_Heapify(arr, heapSize, largest);
		}
	}
	
	public void sort(int[] arr){
		int length = arr.length;
		
		for(int i=(int) Math.floor(length/2)-1;i>=0;i--){
			max_Heapify(arr, length, i);
		}
		
		
		for(int i = length-1;i>=0;i--){
			swap(0, i, arr);
			
			max_Heapify(arr, i, 0);
		}
	}
	
	public void print(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] arg){
		int[] array = {8,6,4,3,2,1};
		
		HeapSort ob = new HeapSort();
		ob.sort(array);
		ob.print(array);
	}
	

}
