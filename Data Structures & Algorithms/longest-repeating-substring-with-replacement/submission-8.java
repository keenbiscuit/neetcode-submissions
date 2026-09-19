class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int max = 0;
        int maxFreq = 0;
        int[] count = new int[26];

        for(int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            count[c -'A']++;

            // Find most frequent number in window
            maxFreq = Math.max(maxFreq, count[c - 'A']);

            // While number of replacements is greater than k
            while((right - left + 1) - maxFreq > k)
            {
                // Shrink window by updating frequency array for number thats leaving
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update max
            max  = Math.max(max, right - left + 1);
        }
        return max;


    }
}
