class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer>  max_freq = new HashMap<>();
        for(int num: nums){
            // Increment frequency count (defaults to 0 if the number is seen for the first time)
            max_freq.put(num, max_freq.getOrDefault(num,0) + 1);
        }
       List<Integer> list = new ArrayList<>(max_freq.keySet());
        list.sort((a,b) -> max_freq.get(b) - max_freq.get(a));
        int result[] = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = list.get(i);
        }
        return result;

    }
}
