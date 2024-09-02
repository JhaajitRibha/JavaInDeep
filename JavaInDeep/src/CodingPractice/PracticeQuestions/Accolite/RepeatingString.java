package CodingPractice.PracticeQuestions.Accolite;

public class RepeatingString {

    public static String convertToRegex(String input) {
        int n = input.length();

        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) {
                String substring = input.substring(0, len);
                StringBuilder repeated = new StringBuilder();


                for (int i = 0; i < n / len; i++) {
                    repeated.append(substring);
                }


                if (repeated.toString().equals(input)) {

                    return substring + "*";
                }
            }
        }

        for (int len = 1; len <= n / 2; len++) {
            String prefix = input.substring(0, len);
            StringBuilder sb = new StringBuilder();
            int i = 0;


            while (i < n) {
                sb.append(prefix);
                i += len;
            }


            if (sb.toString().startsWith(input)) {
                String rest = input.substring(sb.length() - len);
                return prefix + "*" + rest;
            }
        }

        return input;
    }

    public static void main(String[] args) {
        System.out.println(convertToRegex("AAAA"));      // Output: AA*A
        System.out.println(convertToRegex("AABAABD"));   // Output: AAB*D
        System.out.println(convertToRegex("ababab"));    // Output: ab*
        System.out.println(convertToRegex("abcabcabc")); // Output: abc*
        System.out.println(convertToRegex("aabbcc"));    // Output: aabbcc (no repeating pattern)
    }
}
