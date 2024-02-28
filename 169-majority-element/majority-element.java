class Solution {
    public int majorityElement(int[] nums) {
        // return brutForce(nums);
        return optimalSolution(nums);
    }

    /**
        Boyer Moore Algorithm
        Time -> O(n)
        Space -> O(1)
     */
    public int optimalSolution(int[] nums) {
        int result = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
            }
            if (result != num) {
                count--;
            } else {
                count++;
            }
        }
        return result;
    }

    /**
        Time -> O(n)
        Space -> O(n)
     */
    public int brutForce(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length / 2)) {
                return entry.getKey();
            }
        }
        return -1;
    }
}