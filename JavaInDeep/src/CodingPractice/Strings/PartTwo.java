package CodingPractice.Strings;

public class PartTwo {

    public static int uniqueChar(String word){
        int count =0;

        int temp[] = new int[255];

        for(int i=0;i<word.length();i++){

            temp[word.charAt(i)]++;
        }

        for(int i=0;i<temp.length;i++){

            if(temp[i]==1){
                count++;
            }

        }
        return count;

    }

    public static int nthElementFibonacci(int n){
        int a=0;
        int b=1;

        int c = a+b;

        for(int i=0;i<n-1;i++){
            System.out.println(c);
            a=b;
            b=c;
            c=a+b;
        }

        return c;
    }
    public static void main(String[] args) {
        System.out.println(uniqueChar("malyalamlksz"));
        System.out.println(nthElementFibonacci(9));
    }
}

