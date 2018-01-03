package String;

import java.util.Scanner;

public class NextPermutation {
private char[] chars = null;

public NextPermutation(String s){
    chars = s.toCharArray();
}
//(0, 1, 2, 5, 3, 3, 0)

final public String nextPermutation(){
    //Step 1: finding the largest non increasing(Decreasing) suffix

    int i = chars.length-1;

  while (i>0 && chars[i-1]>=chars[i]){
      i--;
  }
    //now i is the index of suffix
  if(i<=0){
      //checking if we are at last permutation already
      return null;
  }

  //Step2; Let array [i-1] id pivot.Now we have to find the smallest value among the suffix that is greater than the pivot
  int j = chars.length-1;

  while (chars[j]<=chars[i-1]){
      j--;
  }

  //Step 3 : swaping the pivot with char[j]which is the smallest value among the suffix that is greater than the pivot
  char temp = chars[i-1];
  chars[i-1] = chars[j];
  chars[j] = temp;

  j = chars.length-1;

  //Step 4:Now we need to sort the suffix in non-decreasing (i.e. weakly increasing) order because we increased the prefix
  while (i<j){
      temp = chars[i];
      chars[i] = chars[j];
      chars[j] = temp;

      i++;
      j--;
  }

  return String.valueOf(chars);
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        NextPermutation np = new NextPermutation(s);
        String nextPermutation = np.nextPermutation();

        while (nextPermutation!=null){
            System.out.println(nextPermutation);
            np = new NextPermutation(nextPermutation);
            nextPermutation = np.nextPermutation();
        }
    }

}
