class Solution {
    public int maxSubArray(int[] nums) {
        // return brutForce(nums);
        return solution(nums);
    }

    /**
     * Kaden's Algorithm
     * Time -> O(n)
     * Space -> O(1)
     */
    public int solution(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
        for (int num : nums) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    /**
     * Time -> O(n^2)
     * Space -> O(1)
     */
    public int brutForce(int[] nums) {
        int sum = nums[0];
        for (int i = 0, j = i; i < nums.length; i++) {
            int currSum = 0;
            for (j = i; j < nums.length; j++) {
                currSum += nums[j];
                if (currSum > sum)
                    sum = currSum;
            }
        }
        return sum;
    }
}