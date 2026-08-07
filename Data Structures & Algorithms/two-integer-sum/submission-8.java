class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] results = new int[2];

        for(int i=0; i<nums.length; i++)
        {
            int comp = target - nums[i];
            if(map.containsKey(comp))
            {
                results[0] = map.get(comp);
                results[1] = i;
            }
            
            map.put(nums[i],i);
        }
        return results;
    }
}
