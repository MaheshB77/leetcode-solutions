class Solution {
    public int findMin(int[] nums) {
        return solution(nums);
    }

    public int solution(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        int result = nums[mid];
        while (low < high) {
            result = Math.min(result, nums[mid]);
            int leftDiff = nums[low] - nums[mid];
            int rightDiff = nums[mid] - nums[high];
            boolean isLeft = false;
            if ((leftDiff > rightDiff) || (leftDiff < 0 && rightDiff < 0)) {
                isLeft = true;
            }
            if (isLeft) {
                high = ((mid - 1) >= 0) ? (mid - 1) : 0;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
            result = Math.min(result, nums[mid]);
        }
        return result;
    }
}