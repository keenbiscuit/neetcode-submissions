class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();

        int result = 0, left = 0;

        for(int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);

            while(seen.contains(c))
            {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(c);

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
