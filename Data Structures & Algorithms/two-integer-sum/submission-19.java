class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> seen = new ArrayList<>();
        int[] result = new int[2];
        // Add each element to a hashSet
        for (int i = 0; i < nums.length; i++) {
            // Key is the element value is the index in the original array
            int diff = target - nums[i];
            if (seen.contains(diff)) {
                result[0] = seen.indexOf(diff);
                result[1] = i;
            }
            seen.add(i,nums[i]);
        }
        return result;
    }
}
