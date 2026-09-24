class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLeft = 0, rowRight = matrix.length - 1;
        int colLeft = 0, colRight = matrix[0].length - 1;
        int count = matrix.length;

        while (count !=0) {
            int rowMid = rowLeft + ((rowRight - rowLeft) / 2);
            if(rowMid == matrix.length)
            return false;

            if(target <= matrix[rowMid][colRight] && target >= matrix[rowMid][colLeft])
            {   System.out.println("test1");
                for(int i = 0; i <= colRight; i++)
                {
                    System.out.println("test2");
                    if(matrix[rowMid][i] == target)
                    return true;
                }
                return false;
            }

            else if(target > matrix[rowMid][colRight])
            {
                rowLeft = rowMid + 1;
            }

            else if (target < matrix[rowMid][colLeft] && rowMid !=0 )
            {
                rowRight = rowMid - 1;
            }
            count --;
        }
        return false;
    }
}
