class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Don't need hashMap, we will keep max length in a variable
        Set<Character> seen = new HashSet<>();

        int left = 0, count = 0;
        int max =0;
        // Iterate through the String
        for(int right = 0; right<s.length(); right++)
        {
            //while we have a character in the set that we've already seen
            while(seen.contains(s.charAt(right)))
            {
                //reduce the window size
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            //compare stored max with current max which is the size of the window + 1
            max = Math.max(max, right - left + 1 );
        }
        return max;
    }
}
