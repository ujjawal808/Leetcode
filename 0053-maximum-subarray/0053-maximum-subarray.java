//By using the kadanes algorithm 
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < nums.length; i++) {
            cs += nums[i];

            maxSum = Math.max(maxSum, cs);

            if (cs < 0) {
                cs = 0;
            }
        }

        return maxSum;
    }
}