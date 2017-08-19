package sorting;

public class InsertionSort {
	                                              /*
	                                               * 5 4 3 2 1
	                                               * 5                     4 3 2 1
	                                               * sorted array          unsorted array
	                                               */
	void sort(int arr[])
    {
		int length = arr.length;
		
		for(int i=1;i<length;i++){
			 int key = arr[i];                      //key = 4
			 int j= i-1;
			 while(j>=0 && key<arr[j]){              // here we compare key= 4 to each of element to left side
				  
				 arr[j+1] = arr[j];                  //Move elements of array whose are greater than 'key' to one position ahead
				 j = j-1;                            // sorted array index
			 }
			 arr[j+1]= key;                           /* while we come out from 'while loop' we will get the coorect position for
			                                            'key' if we add 1 with 'j' . because the while loop will break while j==-1 
			                                            or value of key will greater than arr[j]. so we need to place key at arr[j+1]
			                                           */
			                                           
		}
		
    
    }
 
	
	
public static void main(String[] arg){
	int[] a = {5,4,3,2,1};
	InsertionSort ob = new InsertionSort();
	ob.sort(a);
	for(int i=0;i<a.length;i++){
		System.out.println(a[i]+" ");
	}
	
	
	
}
}
