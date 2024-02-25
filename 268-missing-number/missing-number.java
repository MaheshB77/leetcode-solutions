class Solution {
    public int missingNumber(int[] nums) {
        // return brutForce(nums);
        return solution(nums);
    }

    public int solution(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int num : nums) sum+=num;
        return (n * (n + 1))/2 - sum;
    }

    /**
        Time -> O(n log n)
        Space -> O(1)
     */
    public int brutForce(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] - nums[i] != 1) {
                return i+1;
            }
        }
        int lastVal = nums[nums.length - 1];
        if (lastVal == nums.length - 1) {
            return nums.length;
        }
        return 0;
    }
}