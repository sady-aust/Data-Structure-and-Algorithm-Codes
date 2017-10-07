/*In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
*/

//Shanto vaier er Boi

public class EulerTotientLoopPhi {

   static  int loopPhi(int n ){
        int ret = n;

        for(int i=2;i*i<=n;i++){

            if(n%i==0){
                while (n%i==0){
                    //finding next prime number devide n
                    n/=i;
                }
              //  ret = ret*(1-(1/i));

                ret -=(ret/i);
            }
        }

        //if n>1 that meams there are Only one prime number which is grater then root(n) then devide n;

        if(n>1){
           // ret = ret *(1-(1/n));

            ret -=ret/n;
        }

        return  ret;
    }

    public static void main(String[] args) {
        System.out.println(loopPhi(123456));
    }
}
