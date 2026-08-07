class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i!=j) {
                    if (i <= j) {
                        solution[0] = i;
                        solution[1] = j;
                        return solution;
                    } else {
                        solution[0] = j;
                        solution[1] = i;
                        return solution;
                    }

                }
            }
        }
        return null;
    }
}