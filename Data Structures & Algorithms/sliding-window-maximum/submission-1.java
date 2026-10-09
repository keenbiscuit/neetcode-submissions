class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Create MaxHeap
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        
        // Create output array
        int[] output = new int[(nums.length-k) + 1];

        // Left pointer
        int left = 0;
        

        for(int right = 0; right < nums.length; right++)
        {
            queue.add(nums[right]);

            if(queue.size() == k)
            {
                output[left] = queue.peek();
                queue.remove(nums[left]);
                left++;
            }
            
        }
        return output;
    }
}
