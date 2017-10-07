import java.util.*;
/*In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
*/

/*
 * Generate all permutations of string in lexicographically sorted order where repetitions of
 * character is possible in string.
 */
public class StringPermutation {

    public List<String> permute(char[] input){



        Set<Character> set = new TreeSet<>();

        for(int i=0;i<input.length;i++){
            set.add(input[i]);

        }
        char[] str = new char[set.size()];
        int[] count = new int[set.size()];


        Iterator<Character> it = set.iterator();

        int index =0;

        while (it.hasNext()){
            char in = it.next();
            int counter =0;

            for(int i=0;i<input.length;i++){
                if(in==input[i]){
                    counter++;
                }

            }

            str[index] = in;
            count[index] = counter;
            index++;
        }


        List<String> resultList = new ArrayList<>();
        char[] result = new char[input.length];

        permuteUtil(str,count,result,resultList,0);


        return resultList;

    }

    public void permuteUtil(char[] str, int[] count, char[] result, List<String> resultList, int level) {
        if(level == result.length){
            resultList.add(new String(result));
            return;
        }

        for(int i=0;i<str.length;i++){
            if(count[i]==0){
                continue;
            }

            result[level] = str[i];
            count[i]--;
            permuteUtil(str,count,result,resultList,level+1);
            count[i] ++;


        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

       StringPermutation ob = new StringPermutation();
       List<String> list = ob.permute(s.toCharArray());

       for (String st :list){
           System.out.println(st);
       }

    }
}
