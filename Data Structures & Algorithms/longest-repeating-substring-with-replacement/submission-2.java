class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> seen = new HashSet<>();
        int max = 0;
        // Add all unique characters to seen
        for (Character c : s.toCharArray()) {
            seen.add(c);
        }

        // For each unique Character
        // Moving right pointer across string to attempt to make string all A's, B's, etc.
        for (char c : seen) {
            // Count = freq of c inside the window
            int count = 0, left = 0;

            // Moving right across string
            for (int right = 0; right < s.length(); right++) {
                // If we are currently looking at c add to its freq inside the window
                // Also no need to replace it
                if (s.charAt(right) == c)
                    count++;

                // If number of replacements exceeds k
                // Minus count because we dont replace the char if it matches c
                while ((right - left + 1) - count > k) {
                    // If the leftmost char in the window is c decrease frequency count inside of
                    // window
                    if (s.charAt(left) == c)
                        count--;

                    // Shift shrink size of window to the right
                    left++;
                }

                // Update Result
                max = Math.max(max, (right - left + 1));
            }
        }
        return max;
    }
}
