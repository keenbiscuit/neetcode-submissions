class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
        return false;
        
        int[] s1C = new int[26];
        int[] s2C = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1C[s1.charAt(i) - 'a']++;
            s2C[s2.charAt(i) - 'a']++;
        }

        // We will use this to determine if a permutation is found
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1C[i] == s2C[i])
                matches++;
        }
        // Left window boundary
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26)
                return true;

            // Getting right character and updating frequency
            int index = s2.charAt(right) - 'a';
            s2C[index]++;
            // Update matches
            if (s1C[index] == s2C[index])
                matches++;
            // If frequency for that character is now too high, they dont match so reduce
            else if (s1C[index] + 1 == s2C[index])
                matches--;

            // Removing left most character to keep fixed window size
            index = s2.charAt(left) - 'a';
            s2C[index]--;
            if (s1C[index] == s2C[index])
                matches++;
            // If the character we shifted from was a match reduce matches
            else if (s1C[index] - 1 == s2C[index])
                matches--;

            left++;
        }
        return matches == 26;
    }
}
