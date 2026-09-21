class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        while(left < right)
        {
            //Calculate current area and update maxArea
            int area = (right - left) * Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, area);

            // move pointer of whatever number is smaller
            if(heights[left] <= heights[right])
            {
                left++;
            }
            else
            {
                right--;
            }

        }
        return maxArea;
    }
}
