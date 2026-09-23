class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int MaxLength = 0;

        for(int right = 0; right < s.length();right++){
            char currentChar = s.charAt(right);
            if(map.containsKey(currentChar) && map.get(currentChar) >= left)
            left = map.get(currentChar) + 1;

            map.put(currentChar, right);
            MaxLength = Math.max(MaxLength, right - left +1);
        }
        return MaxLength;
    }
}
