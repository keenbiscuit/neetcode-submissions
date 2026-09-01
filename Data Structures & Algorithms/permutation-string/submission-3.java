class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
        return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Add first s1Count.length characters to each array
        for(int i = 0; i < s1.length(); i++)
        {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        // Check how many intial matches we have
        int matches = 0;
        for(int i = 0; i < 26; i++)
        {
            if(s1Count[i]==s2Count[i])
            matches++;
        }

        //
        int left = 0;
        for(int right = s1.length(); right < s2.length(); right++)
        {
            if(matches == 26)
            return true;

            //Getting character to the right
            int index = s2.charAt(right) - 'a';
            s2Count[index]++;

            // If the character freqs match add 1 to matches
            if(s1Count[index]==s2Count[index])
            {
                matches++;
            }
            /*Need this check because for a brief moment before
            removing the left character s2Count has 4 characters and we could have
            a proper permutation. Ex: s1Count="abc" s2Count ="abca"*/ 
            else if(s1Count[index] + 1 == s2Count[index])
            {
                matches--;
            }

            // Get left char for removal
            index = s2.charAt(left) - 'a';
            s2Count[index]--;
            if(s1Count[index]==s2Count[index])
            {
                matches++;
            }
            else if(s1Count[index] - 1 == s2Count[index])
            {
                matches--;
            }

            left++;

        }
        return matches == 26;
    }
}
