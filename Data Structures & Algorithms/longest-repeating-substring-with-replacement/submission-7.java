class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] count = new int[26];

        int max = 0;
        int maxFreq = 0;

        for(int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            count[c - 'A']++;

            maxFreq = Math.max(maxFreq, count[c-'A']);

            while((right - left + 1) - maxFreq > k)
            {
                //Shrink window
                count[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
