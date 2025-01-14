package DSA.arrays;

public class LongestWord {
    public static void main(String[] args) {
        String sen = "i love dogs";
        System.out.println(longestWord(sen));
    }

    private static String longestWord(String sen) {
        // split the string to string array of words
        String [] words = sen.split(" ");
        // iterate through and capture index of largest length
        int maxLength = 0;int index =-1;
        for(int i =0; i< words.length; i++) {
            int len = words[i].length();
            if(len > maxLength) {
                index = i;
                maxLength = len;
            }
        }
        // return string of that index
        return words[index];
    }
}
