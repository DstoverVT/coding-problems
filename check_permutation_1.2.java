// Given two strings, write a method to determine if one is a permutation of the other

class Solution2 {
    // My implementation:
    // Use arrays to count number of each character (int index), and if same then they are permutations
    public static boolean checkPermutation(String str1, String str2)
    {
        // Assume ASCII character set of 128 characters
        final int MAX_CHARS = 128;

        // Edge case: Can't be permutation if different lengths
        if(str1.length() != str2.length())
            return false;
        
        // Increment count of each character in respective arrays
        int[] characterCount = new int[MAX_CHARS];
        // int[] characterCount2 = new int[MAX_CHARS];  // Don't need another array, can subtract from first
        for(int i = 0; i < str1.length(); i++)
        {
            // Assuming case does not matter
            // **Also assume that whitespace does matter
            char char1 = str1.toLowerCase().charAt(i);
            char char2 = str2.toLowerCase().charAt(i);
            characterCount[char1]++;
            characterCount[char2]--;
        }
        
        // Check that count for each character is 0, meaning that it is same for both strings
        // If not then not permutations
        for(int i = 0; i < MAX_CHARS; i++)
        {
            if(characterCount[i] != 0)
                return false;
        }
        
        return true;
    }

    public static void main(String[] args)
    {
        String[][] tests = {
            // Edge cases
            {"toolong", "short"},
            {"", "empty"},
            // Permutations
            {"ELRTTU", "TURTLE"},
            {"food", "odof"},
            {"thuNder", "THurdeN"},
            {"ab cd", "dabc "},
            {"i", "i"},
            {"astro", "otsar"},
            {"geodude", "udedoeg"},
            // Not Permutations
            {"m", "n"},
            {"gordon", "ramseyg"},
            {"soclose", "soclos3"},
            {"software", "sofyware"},
            {"   food", "odo f"}
        };

        for(String[] inputs : tests) {
            String str1 = inputs[0];
            String str2 = inputs[1];
            System.out.println("{" + str1 + ", " + str2 + "}: " + checkPermutation(str1, str2));
        }
    }
}
