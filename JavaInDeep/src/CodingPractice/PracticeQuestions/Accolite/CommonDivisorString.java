package CodingPractice.PracticeQuestions.Accolite;

public class CommonDivisorString {
    public static String gcdOfStrings(String str1,String str2){
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);

    }


    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        String str1 = "LEET";
        String str2 = "CODE";
        String result = gcdOfStrings(str1, str2);
        System.out.println("GCD of strings: " + result);
    }
}
