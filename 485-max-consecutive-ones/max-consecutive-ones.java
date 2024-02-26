class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 0) {
                if (maxCount < count) {
                    maxCount = count;
                }
                count = 0;
            } else {
                count++;
            }
            if (maxCount < count) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}