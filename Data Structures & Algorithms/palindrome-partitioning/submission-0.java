class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), s, 0);
        return resultList;
    }
    private void backtrack(List<List<String>> resultList, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tempList.add(s.substring(start, i + 1));
                backtrack(resultList, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
