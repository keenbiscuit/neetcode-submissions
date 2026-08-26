class Solution {
    public int characterReplacement(String s, int k) {
        // OLD: Set<Character> seen = new HashSet<>();
        // NEW: Store the frequency of every character in one window.
        HashMap<Character, Integer> count = new HashMap<>();

        int max = 0;
        int left = 0;

        // OLD: count meant "frequency of one selected character c."
        // NEW: maxFreq means "frequency of the most common character
        // currently seen in any window so far."
        int maxFreq = 0;

        // OLD: outer loop chose c, inner loop scanned the string.
        // NEW: only one scan across the string.
        for (int right = 0; right < s.length(); right++) {

            // Add the right character into the current window's counts.
            char rightChar = s.charAt(right);
            count.put(rightChar, count.getOrDefault(rightChar, 0) + 1);

            // If this character is now the most common one, update maxFreq.
            maxFreq = Math.max(maxFreq, count.get(rightChar));

            // Keep the most frequent character; replace every other character.
            // If replacements needed exceed k, shrink from the left.
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);

                // Remove the left character from the current window.
                count.put(leftChar, count.get(leftChar) - 1);

                // Shift / shrink the window.
                left++;
            }

            // Record the biggest window that can be made one repeated character.
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}