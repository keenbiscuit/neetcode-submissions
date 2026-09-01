class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> seen = new HashMap<>();

        for(String s:strs)
        {
            int[] count = new int[26];

            for(char c : s.toCharArray())
            {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            seen.putIfAbsent(key, new ArrayList<>());

            seen.get(key).add(s);
        }

        return new ArrayList<>(seen.values());
    }
}
