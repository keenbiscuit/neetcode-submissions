class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<>(nums.length);
        for(int i: nums)
        {
            if(map.contains(i))
            return true;

            map.add(i);
        }
        return false;
    }
}