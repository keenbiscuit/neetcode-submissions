class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int j=1;

        for(int i=0; i<nums.length; i++)
        {   result[i]=1;
            while(i!=j)
            {
                result[i] *= nums[j++];

                if(j==nums.length)
                {
                    j=0;
                    break;
                }

                if(j==i && j+1!=nums.length)
                {
                    j++;
                }
            }
        }
        
        
    return result;
    }
}  
