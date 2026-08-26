class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int result = 0;

        for(int i=0; i<nums.length;i++)
        {
            seen.add(nums[i]);
        }

        for(int n : seen)
        {
            if(!seen.contains(n-1))
            {
                int v = n;
                int count = 1;

                while(seen.contains(v + 1))
                {
                    count++;
                    v++;
                }
                result =  Math.max(result, count);
            }
            
        }
        return result;
    }
    
}
