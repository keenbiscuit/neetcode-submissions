class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> seen = new ArrayList<>();
        
        // Add each element to a hashSet
        for (int i = 0; i < nums.length; i++) {
            // Key is the element value is the index in the original array
            int diff = target - nums[i];
            if (seen.contains(diff)) {
                return new int[]{seen.indexOf(diff), i};
            }
            seen.add(i,nums[i]);
        }
        return null;
    }
}
