class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1, left = 0, count = 0;

        for(int right = 0; right < nums.length; right++)
        {
            prod *= nums[right];

            while(prod >= k && left <= right)
            {
                prod /= nums[left++];
            }

            count += right - left + 1;
        }
        return count;
    }
}