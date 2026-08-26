class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, max = 0;
            // Frequency of 1's in the current window because we won't need to replace these
            int count = 0; 

        // Iterate through the nums array
        for (int right = 0; right < nums.length; right++) {
            
            if (nums[right] == 1)
                count++; // add to count of 1's

            
            // While the number of 0's in the window is greater than k
            while((right - left + 1) - count > k)
            {
                //if nums[left] is pointing at a 1 reduce the count of 1's inside of the window
                if(nums[left] == 1)
                    count--;

                // Shift/ Shrink window
                left++;
            }
            // Update max
            max = Math.max(max, (right - left + 1));
        }

        return max;
    }
}