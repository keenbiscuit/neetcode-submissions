class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        Set<Character> seen = new HashSet<>();

        // All unique characters in a string
        for(char c: s.toCharArray())
        seen.add(c);

        // For each character in the set
        for(char c : seen)
        {
            // count = count of c inside the window
            int left = 0, count = 0;

            // Move right pointer across the String
            // Essentially saying try making the window all A's , B's, etc.
            for(int right =0; right<s.length(); right++)
            {

                //Increase count when s[r] == c
                if(s.charAt(right)==c)
                {
                    count ++;
                }

                // If window needs greater than k replacements shrink the window 
                // By moving left forward and adjusting count
                // Current window size - copies of current target character
                while((right - left + 1) - count > k)
                {
                    if(s.charAt(left)==c)
                    count--;

                    left++;
                }
                //update result
                result = Math.max(result, right - left + 1);
            }
        }
        return result;
    }
}
