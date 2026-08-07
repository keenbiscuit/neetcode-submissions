class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        //For each number in nums check if its in the map if yes return true if not put it in the map
        //Return false if we get through nums with no duplicates
        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(nums[i])) {
                return true;
            }
            map.put(i, nums[i]);
        }
        return false;
    }
}