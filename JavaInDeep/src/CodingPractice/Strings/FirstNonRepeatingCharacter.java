package CodingPractice.Strings;

public class FirstNonRepeatingCharacter {

    public static int nonRepeatingCharIndex(String word){
        int index = -1;

        //abcdcaf
        int[] count = new int[26];


       for(char ch:word.toCharArray()){
           count[ch-'a']++;
       }

       for(char ch: word.toCharArray()){
           System.out.println(" : "+ count[ch-'a'] );
       }
       for(int i=0;i<word.length();i++){
           if(count[word.charAt(i)-'a']==1){
               index=i;
               return index;
           }
       }


        return index;
    }



    public static void main(String[] args) {

        System.out.println(nonRepeatingCharIndex("acbdcaf"));
    }
}
