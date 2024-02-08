import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
     String t = "God";
     String s = "dog";

     t = t.toLowerCase(); // incase of uppercase letters, we make sure all characters are lowercased.
     s = s.toLowerCase();

     
     if(t.length() == s.length()) { // checks if they have the same amount of characters, since for words to be anagram they must have the same amount of words.
        char[] char_T = t.toCharArray();
        char[] char_S= s.toCharArray();

        Arrays.sort(char_T); // sorts the characters alphabetically.
        Arrays.sort(char_S);
    
        if (Arrays.equals(char_T, char_S)) { // checks if the given words are anagram.
            System.out.println(true);
        } else {
            System.out.println(false);
        }
     } else {
        System.out.println(false);
        }
    }
}
