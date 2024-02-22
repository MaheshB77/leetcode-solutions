class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 1; j < nums.length;) {
            if(nums[i] == 0 && nums[j] == 0) {
                j++;
                continue;
            }
            if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i++;
            j++;
        }
        
    }
}