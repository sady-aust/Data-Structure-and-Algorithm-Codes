package MaximumSubArraySum;

public class KadanesAlgorithm {

    static long MaximumSubArraySum(int[] arr){
        long maxSoFar = Integer.MIN_VALUE;
        long maxEndingHere =0;

        for(int i=0;i<arr.length;i++){
            maxEndingHere +=arr[i];
            if(maxEndingHere<0){
                maxEndingHere =0;
            }

            if(maxEndingHere>maxSoFar){
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,2};
        System.out.println(MaximumSubArraySum(arr));
    }
}
