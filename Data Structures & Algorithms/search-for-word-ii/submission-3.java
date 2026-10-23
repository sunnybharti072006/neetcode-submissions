class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (node.children[index] == null) node.children[index] = new TrieNode();
                node = node.children[index];
            }
            node.word = word;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                solve(board, i, j, root, result);
            }
        }
        return result;
    }
    private void solve(char[][] board, int i, int j, TrieNode node, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') return;

        char ch = board[i][j];
        TrieNode next = node.children[ch - 'a'];

        if (next == null) return;
        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }
        board[i][j] = '#';

        solve(board, i + 1, j, next, result);
        solve(board, i - 1, j, next, result);
        solve(board, i, j + 1, next, result);
        solve(board, i, j - 1, next, result);
        board[i][j] = ch;
    }
}