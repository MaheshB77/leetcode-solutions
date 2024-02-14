class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        solution(result, sub, nums, 0, nums.length);
        return result;
    }

    public void solution(List<List<Integer>> result, List<Integer> sub, int[] nums, int index, int length) {
        if (index >= length) {
            result.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[index]);
        solution(result, sub, nums, index + 1, length);
        sub.remove(sub.size() - 1);
        solution(result, sub, nums, index + 1, length);
    }
}