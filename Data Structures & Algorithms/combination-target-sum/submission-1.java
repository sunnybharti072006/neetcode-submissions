class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] nums, int target, int start, List<Integer> currentList, List<List<Integer>> result) {
        if(target == 0){
            result.add(new ArrayList<>(currentList));
            return;
        }
        if (target < 0) return;
        for (int i = start; i < nums.length; i++){
            currentList.add(nums[i]);
            backtrack(nums, target - nums[i], i,currentList, result );
            currentList.remove(currentList.size() - 1);
        }
    }
}
