class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;

        int[] countA= new int[26];
        int[] countB = new int[26];

        for(Character c: s.toCharArray())
        {
            countA[c - 'a']++;
        }

        for(Character c: t.toCharArray())
        {
            countB[c - 'a']++;
        }

        return Arrays.compare(countA, countB) ==0;

    }
}
