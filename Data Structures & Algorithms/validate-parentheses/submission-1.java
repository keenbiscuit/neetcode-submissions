class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> seen = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c) && !seen.isEmpty()) {
                char curr = seen.pop();
                if (curr != map.get(c)) {
                    return false;
                }
            } else {
                seen.push(c);
            }
        }
        return seen.isEmpty();
    }
}
