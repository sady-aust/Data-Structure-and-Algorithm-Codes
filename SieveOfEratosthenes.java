import java.util.Scanner;

public class SieveOfEratosthenes {

    static void sieveOfEratosthenes(int n ){
        boolean[] isPrime = new boolean[n+1];

        /*A value in prime[i] will finally be false
          if it is not prime.
        */

        for(int i=0;i<n;i++){
            isPrime[i] = true;
        }

        //ekti sonkha kake kake vag kore tar track trakhbo

        for(int i=2;i*i<=n;i++){

            if(isPrime[i]==true){
                for(int j= i*2;j<=n;j+=i){
                    /*
                     gunitok gula newa hobe..such as 4,6,8... or 3,6,9....
                      karon ekti sonkha only tar gunitok gulare vag korbe
                     */
                    isPrime[j] = false;
                }
            }
        }


        for(int i=0;i<isPrime.length;i++){
            if(isPrime[i]){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sieveOfEratosthenes(n);
    }
}
