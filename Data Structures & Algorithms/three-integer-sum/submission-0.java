class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // If first element is greater than 0 all elements after will be too so break
            if (nums[i] > 0)
                break;

            // Skip duplicates for the first element because
            // If we start with the same element on two different loops
            // We could end up with the same triplet
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Set left and right pointers
            int left = i + 1, right = nums.length - 1;

            // while the pointers don't cross
            while (left < right) {
                // Calculate sum
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum == 0) {
                    // Add triplet to result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Move both pointers inward
                    left++;
                    right--;
                    // Skip duplicates at left
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
