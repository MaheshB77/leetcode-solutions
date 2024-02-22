class Solution {
    public void rotate(int[] nums, int k) {
        // solution1(nums, k);
        // solution2(nums, k);
        // solution3(nums, k);
        solution4(nums, k);
    }

    public void solution4(int[] nums, int k) {
        int len = nums.length;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, (k % len) - 1);
        reverse(nums, (k % len), nums.length-1);
    }

    /**
        Time -> O(n)
        Space -> O(n)
     */
    public void solution3(int[] nums, int k) {
        int length = nums.length;
        int[] dup = new int[length];
        for (int i = 0; i < length; i++) {
            dup[(i+k) % length] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = dup[i];
        }
    }

    /**
        Time -> O(n)
        Space -> O(n)
     */
    public void solution2(int[] nums, int k) { 
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

    public int[] reverse(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        return nums;
    }
}