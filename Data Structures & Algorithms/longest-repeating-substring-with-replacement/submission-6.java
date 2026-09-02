class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        // Key: current character
        // Value: frequency of character within window

        int left = 0;
        int maxFreq = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            // Get current character and put into map with update count
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);

            // Update max frequency
            maxFreq = Math.max(maxFreq, count.get(c));

            // while the number of replacements is greater than k
            while ((right - left + 1) - maxFreq > k) {
                // Reduce count of leftmost character
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);

                // Shrink window
                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
