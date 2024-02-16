class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, sub, nums, 0);
        return result;
    }

    public void dfs(
        List<List<Integer>> result,
        List<Integer> sub,
        int[] nums,
        int index
    ) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[index]);
        dfs(result, sub, nums, index + 1);
        int last = sub.get(sub.size() - 1);
        sub.remove(sub.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index+1]) {
            index += 1;
        }
        dfs(result, sub, nums, index + 1);
    }
}