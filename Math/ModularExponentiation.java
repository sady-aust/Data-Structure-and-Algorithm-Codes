package Math;

public class ModularExponentiation {

    static long BigMod(long a,long n,long m){
        if(n==0){
            return 1;
        }
        //Formula (a*b)%m = ((a%m)*(b%m))%m

        //n odd hole a^n = a*a^n-1
        //                 = ((a%m)*((a^(n-1))%m))%m
        //n even hole a^n = a^(n/2)*a^(n/2)
        //                 = (((a^(n/2))%m)*((a^(n/2))%m))%m

        if(n%2==1){

            return ((a%m)*BigMod(a,n-1,m))%m;
        }
        else {
            long d = BigMod(a,n/2,m);
            return ((d%m)*(d%m))%m;
        }
    }

    public static void main(String[] args) {
        System.out.println(BigMod(3,18132,17));
    }
}
