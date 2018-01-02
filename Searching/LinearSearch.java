package Searching;

public class LinearSearch {
    static int linearSearch(int[] array,int item){
        int index =-1;
        for(int i=0;i<array.length;i++){
            if(array[i]==item){
                index =i;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] arr ={5,8,7,6,9,5,4};

        System.out.println(linearSearch(arr,5));
    }
}
