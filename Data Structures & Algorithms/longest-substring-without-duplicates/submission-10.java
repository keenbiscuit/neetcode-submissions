class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        int left = 0, max = 0;

        Set<Character> seen = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            
            while (seen.contains(c)) {

                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(c);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
