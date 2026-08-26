class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> seen = new HashSet<>();
        int max = 0;
        // Add all unique characters to seen
        for(Character c : s.toCharArray())
        {
            seen.add(c);
        }


        for(char c : seen)
        {
            // Count = freq of c inside the window
            int count = 0, left = 0;

            //Moving right pointer across string to attempt to make string all A's, B's, etc.
            for(int right = 0; right < s.length(); right++)
            {
                // If we are currently looking at c add to its freq inside the window
                // Also no need to replace it
                if(s.charAt(right)==c)
                count++;

                
                // If number of replacements exceeds k
                while((right - left + 1) - count > k)
                {
                    // If the leftmost char in the window is c decrease frequency count inside of window
                    if(s.charAt(left) == c)
                    count--;

                    left++;
                }

                // Update Result
                max = Math.max(max, (right - left + 1));
                
            }
        }
        return max;
    }
}
