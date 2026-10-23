
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> foundWords = new HashSet<>();

        int m = board.length;
        int n = board[0].length;

        for (String word : words) {
            boolean found = false;

            for (int i = 0; i < m && !found; i++) {
                for (int j = 0; j < n && !found; j++) {
                    if (solve(board, word, i, j, 0)) {
                        foundWords.add(word);
                        found = true;
                    }
                }
            }
        }

        result.addAll(foundWords);
        return result;
    }

    private boolean solve(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        char ch = board[i][j];
        board[i][j] = '.';

        boolean found = solve(board, word, i + 1, j, index + 1)
                || solve(board, word, i - 1, j, index + 1)
                || solve(board, word, i, j + 1, index + 1)
                || solve(board, word, i, j - 1, index + 1);

        board[i][j] = ch;
        return found;
    }
}
