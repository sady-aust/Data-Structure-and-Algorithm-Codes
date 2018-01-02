package Searching;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    static int BinarySearch(List<Integer> arr, int item){
        int start =0;
        int end =arr.size()-1;

        int location = -1;

        while (start<=end){
            int mid = (start+end)/2;

                if (arr.get(mid) == item) {
                    location = mid;
                    break;
                } else if (arr.get(mid) < item) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }


        return location;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);


        System.out.println(BinarySearch(list,9));
    }
}
