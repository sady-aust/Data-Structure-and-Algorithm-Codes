import java.util.Scanner;
/*
  Print all possible combinations of r elements in a given array of size n
 */


public class Combination {
    /*
    r = length of each combinatin
    n = lenth of the array
    data is ana annry where we will keeep temporarily each combination
     */

    static void printUtil(int[] arr, int n, int r, int index, int[] data, int i){

        if(index==r){
            for(int j=0;j<data.length;j++){
                System.out.print(data[j]+" ");
            }
            System.out.println("");
            return;
        }

        if(i>=n){
            return;
        }
        data[index] = arr[i];

        printUtil(arr,n,r,index+1,data,i+1);
        printUtil(arr,n,r,index,data,i+1);
    }

    static void printAllCombinition(int[] arr,int n,int r){
        int[] data = new int[r];
        printUtil(arr,n,r,0,data,0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ar = {1,2,3,4,5,6,7};

        printAllCombinition(ar,ar.length,6);
    }
}
