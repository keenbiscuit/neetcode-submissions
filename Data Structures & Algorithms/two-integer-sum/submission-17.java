class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // For each element in nums
        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference
            int diff = target - nums[i];

            // if the difference is in the map
            if (map.containsKey(diff)) {
                // return new array with the index of the diff and i
                return new int[] {map.get(diff), i};
            }

            // add the current element and its index to the map
            map.put(nums[i], i);
        }
        return null;
    }
}
