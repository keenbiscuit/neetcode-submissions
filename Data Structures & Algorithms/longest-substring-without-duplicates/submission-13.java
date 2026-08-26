class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, max = 0;

        for(int right = 0; right<s.length(); right++)
        {
            char c = s.charAt(right);

            while(seen.contains(c))
            {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(c);

            max = Math.max(max, (right - left + 1));
        }

        return max;
    }
}
