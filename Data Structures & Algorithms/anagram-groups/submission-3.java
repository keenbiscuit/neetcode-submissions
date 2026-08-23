class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Key:count arrayToString, value:Arraylist to store all anagrams matching the key
        Map<String, List<String>> seen = new HashMap<>();

        for(String s:strs)
        {
            //Count array to store character freq
            int[] count = new int[26];

            for(Character c: s.toCharArray())
            {
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            
            seen.putIfAbsent(key, new ArrayList<String>());

            seen.get(key).add(s);
        }

        return new ArrayList<>(seen.values());
    }
}
