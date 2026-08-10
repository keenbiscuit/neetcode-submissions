class Solution {
    public int longestConsecutive(int[] nums) {
       if(nums.length<1)
       return 0;
       
        Arrays.sort(nums);

        PriorityQueue<Integer> maxResult = new PriorityQueue<>(Collections.reverseOrder());
        int sequenceCount = 1;
        
        
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                sequenceCount++;
            } else if (nums[i] == nums[i + 1])
                continue;
            else {
                maxResult.add(sequenceCount);
                sequenceCount = 1;
            }
        }
        maxResult.add(sequenceCount);

        return maxResult.poll();
    }
}
