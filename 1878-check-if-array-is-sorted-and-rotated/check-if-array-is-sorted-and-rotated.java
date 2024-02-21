class Solution {
    public boolean check(int[] nums) {
        // return solution1(nums);
        return solution2(nums);
    }

    // My solution
    public boolean solution1(int[] nums) {
                int irr = 0;
        int i = 0;
        if (nums.length == 1) return true;

        for (; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]){
                irr++;
            }
        }
        if (nums[i] > nums[0]) {
            irr++;
        }
        if (irr > 1) {
            return false;
        }
        return true;
    }

    // Better solution
    public boolean solution2(int[] nums) {
        int irr = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > nums[(i + 1) % length]) {
                irr++;
            }
        }
        if (irr > 1) return false;
        return true;
    }
}