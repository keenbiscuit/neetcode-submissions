class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i=0;i<nums.length;i++) {
            
            set.add(nums[i]);
        }
        for(int n : set) {
            if(!set.contains(n-1)) {
                int v = n;
                int count =1;
                
                while(set.contains(v+1)) {
                    count++;
                    v++;
                    
                }
                result = Math.max(result,count);

            }
        }
        return result;
    }
}
