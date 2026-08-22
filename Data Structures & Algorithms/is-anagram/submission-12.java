class Solution {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];

        for(Character c: s.toCharArray())
        countS[c-'a']++;

        for(Character c: t.toCharArray())
        countT[c-'a']++;

        return Arrays.compare(countS,countT)==0;
   }
}
