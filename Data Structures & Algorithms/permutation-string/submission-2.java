class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1C = new int[26];
        int[] s2C = new int[26];

        // add first s1.L characters to both Arrays
        for (int i = 0; i < s1.length(); i++) {
            s1C[s1.charAt(i) - 'a']++;
            s2C[s2.charAt(i) - 'a']++;
        }

        // Check the initial amount of matches
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1C[i] == s2C[i]) {
                matches++;
            }
        }

        int left = 0;
        for(int r = s1.length(); r<s2.length(); r++)
        {
            // If frequency arrays match
            if(matches == 26)
            return true;

            // Add the next letter to the array
            int index = s2.charAt(r) - 'a';
            s2C[index]++;
            if(s1C[index] == s2C[index])
            {
                matches++;
            }
            // Before adding this character the count was correct
            // Adding it made the count to high 
            else if(s1C[index] + 1 == s2C[index]){
                matches--;
            }

            // Remove leftmost letter from the array
            index = s2.charAt(left) - 'a';
            s2C[index]--;
            if(s1C[index] == s2C[index])
            {
                matches++;
            }
            // Before removing this character the count was correct
            // deleting it made the count to low 
            else if(s1C[index] - 1 == s2C[index]){
                matches--;
            }

            // Shift window
            left++;
        }
        return matches == 26;
    }
}
