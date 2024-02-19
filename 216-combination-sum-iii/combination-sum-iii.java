class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        solution(result, sub, arr, k, n, 0);
        return result;
    }

    public void solution(
        List<List<Integer>> result,
        List<Integer> sub,
        int[] arr,
        int k,
        int n,
        int index
    ) {
        if (sub.size() == k) {
            if (sum(sub) == n) {
                result.add(new ArrayList<>(sub));
            }
            return;
        }
        if (index >= arr.length) return;
        sub.add(arr[index]);
        solution(result, sub, arr, k, n, index + 1);
        sub.remove(sub.size() - 1);
        solution(result, sub, arr, k, n, index + 1);
    }

    public int sum(List<Integer> list) {
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        return sum;
    }
}