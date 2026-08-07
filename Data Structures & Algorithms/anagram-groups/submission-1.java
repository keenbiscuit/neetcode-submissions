class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //HashMap to store the key which is the string in count index form 
        //and the value which is the list of strings that match that form
        Map<String, List<String>> map = new HashMap<>();
        
        //For each string in the list
        for(String s: strs)
        {
            //Create a new count array to track character counts
            int[] count = new int[26];

            //For each character in the string
            for(Character c: s.toCharArray())
            {
                //increment wherever we have a character
                count[c-'a']++;
            }

            //Convert the count array to a string to allow it to be the key in the map
            String key = Arrays.toString(count);

            //If new key we make a new List of Strings for the key
            map.putIfAbsent(key, new ArrayList<>());

            //Add the string to the list via the key we just calculated
            map.get(key).add(s);
        }
        //Return a new list that has the organized String values from our map
        return new ArrayList<>(map.values());
    }
}
