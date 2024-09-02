    package CodingPractice.PracticeQuestions.Accolite;

    import java.util.HashSet;
    import java.util.Set;

    class solution {
        public static String reverseVowel(String s) {

            Set<Character> vowels = new HashSet<>();

            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            vowels.add('A');
            vowels.add('E');
            vowels.add('I');
            vowels.add('O');
            vowels.add('U');

            char[] chars = s.toCharArray();
            int left = 0, right = chars.length - 1;

            while (left < right) {

                while (left < right && !vowels.contains(chars[left])) {
                    left++;
                }

                while (left < right && !vowels.contains(chars[right])) {
                    right--;
                }

                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;


            }
            return new String(chars);
        }
    }

    public class ReverseVowelString {

        public static void main(String[] args) {
            System.out.println(solution.reverseVowel("leetcode"));
        }
    }
