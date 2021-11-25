// Implement an algorithm to determine if a string has all unique characters.
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution1
{
    // My implementation (with data structures)
    // Use array that stores bit at each element, return false if accessing a true element
    public boolean isUnique(String s)
    {
        final int MAX_ASCII_CHARS = 128;

        // Edge cases
        if(s.length() <= 1) {
            return true;
        }
        if(s.length() > MAX_ASCII_CHARS) {
            return false;
        }

        // Assuming only normal ASCII characters will be in string
        boolean[] letters = new boolean[MAX_ASCII_CHARS];
        
        for(char c : s.toCharArray())
        {
            if(letters[c]) {
                return false;
            }
            else {
                letters[c] = true;
            }
        }

        return true;
    }

    // Implementation after research
    // Using Set to rid of duplicates
    public boolean isUnique_Solution1(String s)
    {
        Set<Character> s_set = new HashSet<Character>();
        s_set = s.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());

        return s_set.size() == s.length();
    }

    public static void main(String[] args)
    {
        Solution1 unique1 = new Solution1();
        String[] tests = {
            // Edge cases
            "",
            "a",
            // Not unique
            "goob",
            "aaron",
            "spaces    ",
            "!!!",
            "wowzers.",
            // Unique
            "wizards",
            "nothi=g",
            "beans luv"
        }; 

        for(int i = 0; i < tests.length; i++) {
            System.out.println("Test " + i + ": ");
            System.out.println(unique1.isUnique(tests[i]));
            System.out.println(unique1.isUnique_Solution1(tests[i]));
        }
    }

}