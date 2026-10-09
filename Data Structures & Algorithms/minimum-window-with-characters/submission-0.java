public class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        // Create frequency map for string t and window map for iteration
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        // put in all chars in t and their frequencies
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        // have & need is for when window satisfies conditions
        int have = 0, need = countT.size();
        // res will contain indexes for our final substring
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        // Iterate through s
        for (int r = 0; r < s.length(); r++) {
            // get the right character & put into window
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If we are looking at a character in t && it has the correct frequency add 1 to have
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            // While all characters in t are in the window
            while (have == need) {
                if ((r - l + 1) < resLen) {
                    // update result Length
                    resLen = r - l + 1;
                    // Leftmost character index
                    res[0] = l;
                    // Rightmost character index
                    res[1] = r;
                }

                // get the char we are about to lose from the window
                char leftChar = s.charAt(l);

                // update count of char in the window
                window.put(leftChar, window.get(leftChar) - 1);

                // If we are moving from a char in t which had the correct frequency count
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    // update have
                    have--;
                }
                // move pointer left
                l++;
            }
        }

        // If resLen == default value we didn't find a substring
        // Else return the substring using the values in res + 1 for end index because substring uses endIndex - 1
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}