package DynamicProgramming;
/*In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
*/
public class ZeroOneKnapsack {

    static int knapsack(int[] weight,int[] value,int n,int totalWeight){
        int[][] arr = new int[n+1][totalWeight+1];

        for(int i=0;i<=n;i++){

            for(int j=0;j<=totalWeight;j++){

                if(i==0 || j==0){
                    arr[i][j] =0;
                }
                else if(weight[i-1]<=j){

                    arr[i][j] = Math.max((value[i-1]+arr[i-1][j-weight[i-1]]),arr[i-1][j]);
                }
                else{
                    arr[i][j] = arr[i-1][j];
                }

            }
        }

        return arr[n][totalWeight];
    }

    public static void main(String[] args) {

        int wt[] = new int[]{26,22,4,18,13,9};
        int val[] = new int[]{64,85,52,99,39,54};

        int w = 26;
        int n = 6;

        System.out.println(knapsack(wt,val,n,w));
    }


}
