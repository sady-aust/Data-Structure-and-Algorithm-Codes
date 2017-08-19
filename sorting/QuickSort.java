package sorting;

public class QuickSort {
	int arr[] ={2,7,3,5,4};
	void swapFunction(int leftIndex, int rightIndex) {
		 
		   int temp = arr[leftIndex];
		   arr[leftIndex] = arr[rightIndex];
		   arr[rightIndex] = temp;
		 
		}
	
	int partitionFunction(int left,int right,int pivot){
		int leftPointer = left-1;
		int rightPointer = right;
		while (true){
			while(arr[++leftPointer]<pivot){
				// do nothing 
			}
			
			while(arr[--rightPointer]>pivot && rightPointer>0){
				// do nothing 
			}
			
			if(leftPointer>=rightPointer){
				break;
			}
			else{
				swapFunction(leftPointer, rightPointer);
			}
			
		}
		swapFunction(leftPointer, right);
		return leftPointer;
	}
	
	void Sort(int left, int right) {
		 
		   if(right-left <= 0)
		      return;
		   else {
		      int pivot = arr[right];
		      int partitionPoint = partitionFunction(left, right, pivot);
		      
		      Sort(left,partitionPoint-1);
		      Sort(partitionPoint+1,right);
		   }
		}
	
	public void print()
	{
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] arg){
		QuickSort ob = new QuickSort();
		ob.Sort(0, ob.arr.length-1);
		ob.print();
		
	}

}
