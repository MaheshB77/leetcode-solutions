class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for (int num : nums) set.add(num);

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int temp = 1;
                while (set.contains(num + 1)) {
                    temp++;
                    num++;
                }
                longest = Math.max(temp, longest);
            }
            if ((longest / 2) > nums.length) break;
        }
        return longest;
    }
}