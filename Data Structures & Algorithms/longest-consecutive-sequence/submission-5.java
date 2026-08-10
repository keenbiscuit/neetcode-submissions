class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int max_count = 0;
        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            int count = 0;
            if(!set.contains(num-1)){
                while(set.contains(num)){
                    count++;
                    num++;
                }
            }

            max_count = Math.max(count, max_count);
        }

        return max_count;

    }
}
