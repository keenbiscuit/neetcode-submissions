class Solution {
    public int largestRectangleArea(int[] heights) {
       Deque<Integer> stack = new ArrayDeque<>();
       int maxArea = 0;

       for(int i =0; i<=heights.length; i++)
       {
            int currentHeight = (i==heights.length) ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] >= currentHeight)
            {
                int height = heights[stack.pop()];
                int left = stack.isEmpty()? -1 : stack.peek();
                int width = i - left - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            if( i < heights.length)
            {
                stack.push(i);
            }
       }
       return maxArea; 
    }
}
