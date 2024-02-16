class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(candidates);
        solution(
            result,
            sub,
            0,
            candidates,
            target,
            0
        );
        return result;
    }

    public void solution(
        List<List<Integer>> result, 
        List<Integer> sub,
        int index,
        int[] candidates,
        int target,
        int sum
    ) {
        if (sum > target) {
            return;
        }
        if (index >= candidates.length) {
            if (sum == target) {
                result.add(new ArrayList<>(sub));
            }
            return;
        }
        sub.add(candidates[index]);
        sum += candidates[index];
        solution(
            result,
            sub,
            index + 1,
            candidates,
            target,
            sum
        );
        sum -= sub.get(sub.size() - 1);
        sub.remove(sub.size() - 1);
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index += 1;
        }
        solution(
            result,
            sub,
            index + 1,
            candidates,
            target,
            sum
        );
    }
}