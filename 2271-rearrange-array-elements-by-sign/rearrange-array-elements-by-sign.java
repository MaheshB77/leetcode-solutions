class Solution {
    public int[] rearrangeArray(int[] nums) {
        return solution(nums);
    }

    public int[] solution(int[] nums) {
        int[] result = new int[nums.length];
        int pPosition = 0;
        int nPosition = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[pPosition] = nums[i];
                pPosition += 2;
            } else {
                result[nPosition] = nums[i];
                nPosition += 2;
            }
        }
        return result;
    }
}