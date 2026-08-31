class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> seen = new HashMap<>();

        int left = 0, maxFreq = 0;
        int max = 0;


        for (int right = 0; right < s.length(); right++) {
            char rightc = s.charAt(right);
            // Put in new character
            seen.put(rightc, seen.getOrDefault(rightc, 0) + 1);

            // Update max frequency if need be
            maxFreq = Math.max(maxFreq, seen.get(rightc));

            // While number of replacements is bigger than k
            while ((right - left + 1) - maxFreq > k) {
                char leftc = s.charAt(left);
                // Reduce count of leftmost character
                seen.put(leftc, seen.get(leftc) - 1);
               
                // Shift left
                left++;
            }

            // Update max
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
