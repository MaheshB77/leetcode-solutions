class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(result, sub, candidates, target, 0, 0);
        return result;
    }

    public void dfs(
        List<List<Integer>> result,
        List<Integer> sub,
        int[] candidates,
        int target,
        int sum,
        int index
    ) {
        if (target == sum) {
            result.add(new ArrayList<>(sub));
            return;
        }
        if (sum > target || index >= candidates.length) {
            return;
        }
        sub.add(candidates[index]);
        sum += candidates[index];
        dfs(result, sub, candidates, target, sum, index);
        sub.remove(sub.size() - 1);
        sum -= candidates[index];
        dfs(result, sub, candidates, target, sum, index + 1);
    }
}