package String;/*In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
*/

public class PrintAllKLengthString {

    static void printAllKLenthUtill(char[] str,int n,int k,String prefix){
        if(k==0){
            //base case: if k=0 then just print the prefix
            System.out.println(prefix);
            return;
        }

       //One by one add all char from str array and recursively call for k equal k-1;
        for(int i=0;i<n;i++){
            //Next caractr of the input is added
            String newPrefix = prefix+str[i];
            //k is decreased becouse we have add a newe charactr
            printAllKLenthUtill(str,n,k-1,newPrefix);

        }
    }

    static void printAllKLenth(char[] str,int k){
        printAllKLenthUtill(str,str.length,k,"");
    }

    public static void main(String[] main){
        String in = "1234567";

        printAllKLenth(in.toCharArray(),7);
    }
}
