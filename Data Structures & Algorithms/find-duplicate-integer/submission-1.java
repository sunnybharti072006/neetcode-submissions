class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> Duplicate = new HashSet<>();

        for(int num: nums){
            if(Duplicate.contains(num)){
                return num;
            }
            Duplicate.add(num);
        }
        return -1;
    }
}
