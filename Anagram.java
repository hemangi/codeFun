//Minimum Number of swaps/replacement required to make two Strings Anagram  
//For example
//        Input set 1 :
//        s1 = "aab"
//        s2 = "baa"
//        Output : 0
//        Explanation: Both String contains identical characters
//
//        Input  set 2: s1 = "aabc" s2 = "kcbf"
//        Output : 2
//        Explanation : Here, we need to change two characters in either of the strings to make them identical.
//        We can change 'a' and 'a' in s1 or 'k' and 'f' in s2

//Method 1 using char array
// Counts the no of swap/replacement required
public class Anagram {
     // below method calculate minimum number of relplcement to make string anagram of each other
    static long countReplacementToMakeTwoStringAnagram(String s1, String s2)
    {
        // store the count of character
        int charCount[] = new int[26];

        // iterate though the first String and update
        s1.chars().forEach(i -> charCount[i - 'a']++);
        long count  = s2.chars().filter(i -> charCount[i - 'a']-- <=0).count();

        return count;
    }
    // below methos returns minimum number of deletion in both string to make anagram of each other
    static long makeAnagramWithMiniumMinimumDeletion(String a ,String b) {
        int charCount[] = new int[26];
        a.chars().forEach(c -> charCount[c -'a']++);
        b.chars().forEach(c -> charCount[c - 'a']--);
        return Arrays.stream(charCount).reduce(0 , (i ,j ) ->  ( Math.abs(i) + Math.abs(j)));
    }
    public static void main(String[] args)
    {
        System.out.println("Need to replace chars from string \"ddcf\" &  \"cedk\" : "+countReplacementToMakeTwoStringAnagram("ddcf", "cedk"));
        System.out.println("Need to replace chars from string \"aab\" &  \"abb\" : "+countReplacementToMakeTwoStringAnagram("aab", "abb"));
        System.out.println("Need to replace chars from string \"abcd\" &  \"cdba\" : "+countReplacementToMakeTwoStringAnagram("abcd", "cdba"));
        System.out.println("Need to replace chars from string \"aaab\" &  \"abcc\" : "+countReplacementToMakeTwoStringAnagram("aaaab", "abcc"));
    }
}
