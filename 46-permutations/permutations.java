class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        solution1(list, new ArrayList<>(), new boolean[nums.length], nums);
        return list;
    }

    public void solution1(
            List<List<Integer>> list,
            List<Integer> sub,
            boolean[] temp,
            int[] nums) {
        if (sub.size() == nums.length) {
            list.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!temp[i]) {
                temp[i] = true;
                sub.add(nums[i]);
                solution1(list, sub, temp, nums);
                sub.remove(sub.size() - 1);
                temp[i] = false;
            }
        }
    }
}