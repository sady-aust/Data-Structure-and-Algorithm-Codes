/*In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
*/

public class EulerTotient {

    int[] phi = new int[1000006];
    int[] mark = new int[1000006];


    void phi(int n){

        //initialization
        for(int i=1;i<=n;i++){
            phi[i] = i;
        }

        phi[1] =1;
        mark[1] =1;

        //protiti moulik sonkha i er jonno er sob gula gunitok ke i die vag ar (i-1) dia gun korlei hobe

        for(int i=2;i<=n;i++){

            if(mark[i]==0){ //if i is prime
                for(int j=i;j<=n;j+=i){
                    mark[j] =1;

                    phi[j] = (phi[j]/i)*(i-1);
                }
            }
        }
    }

    public static void main(String[] args) {
       EulerTotient ob = new EulerTotient();
       ob.phi(1000000);
        System.out.println(ob.phi[123456]);
    }

}
