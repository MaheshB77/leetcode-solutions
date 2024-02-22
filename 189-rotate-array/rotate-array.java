class Solution {
    public void rotate(int[] nums, int k) {
        // solution1(nums, k);
        solution2(nums, k);
    }

    public void solution2(int[] nums, int k) {
        // if (nums.length == 1 || nums.length == k) return;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (counter < nums.length) {
                map.put(counter, nums[i]);
                counter++;
            }
            if (counter == nums.length) {
                counter = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(i);
        }
    }

    // Fails one of the test due to time
    public void solution1(int[] nums, int k) {
        if (nums.length == 1) return;
        int next = 0;
        int curr = 0;
        int counter = 0;
        while (counter != k) {
            curr = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                next = nums[i+1];
                nums[i+1] = curr;
                curr = next;
            }
            nums[0] = next;
            counter++;
        }
    }
}