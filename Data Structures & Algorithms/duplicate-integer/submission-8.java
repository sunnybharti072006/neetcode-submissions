class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> Duplicate = new HashSet<>();
        for (int num : nums) {
            if (Duplicate.contains(num)) return true;
            Duplicate.add(num);
        }
        return false;
    }
}