class Solution {
    public int longestConsecutive(int[] nums) {
      if(nums.length <= 1)
      return nums.length;

      
      
      Set<Integer> seen = new HashSet<>();
      int result = 0;
      for(int n : nums)
      {
        seen.add(n);
      }  

      for(int n : seen)
      {
        if(!seen.contains(n-1))
        {
            int v = n;

            int count = 1;

            // While seen contains next element
            while(seen.contains(v+1))
            {
                count++;
                v++;
            }
            result = Math.max(result, count);
        }
        
      }
      return result;
    }
}
