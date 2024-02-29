import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "abccccdd"; // 2nd input case = "speediskey" output = 5
        if (s.length() >= 1 && s.length() <= 2000) {
            System.out.println(longestPalindrome(s));
        } else {
            System.out.println("Length Invalid");
        }
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        boolean oddFound = false;
        int maxLength = 0;

        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                maxLength += count;
            } else {
                maxLength += count - 1;
                oddFound = true;
            }
        }

        if (oddFound) {
            maxLength++; // Includes one odd count character
        }

        return maxLength;
    }
}

