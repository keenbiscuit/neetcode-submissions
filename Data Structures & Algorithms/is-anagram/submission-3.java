class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }
        int count = t.length();
        while (count != 0) {
            for (int i = 0; i < t.length(); i++) {
                if (st.peek().equals(t.charAt(i))) {
                    st.pop();
                    t = t.substring(0, i) + t.substring(i + 1);
    
                }

                if (st.isEmpty()) {
                    return true;
                }
            }
            count--;
        }
        return false;
    }
}