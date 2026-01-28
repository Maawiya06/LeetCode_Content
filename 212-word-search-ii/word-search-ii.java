class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private void solve(char[][] board, int i, int j, TrieNode found, List<String> result) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char c = board[i][j];
        if (c == '#' || found.children[c - 'a'] == null)
            return;

        found = found.children[c - 'a'];

        if (found.word != null) {
            result.add(found.word);
            found.word = null;
        }

        board[i][j] = '#';

        solve(board, i + 1, j, found, result);
        solve(board, i - 1, j, found, result);
        solve(board, i, j + 1, found, result);
        solve(board, i, j - 1, found, result);

        board[i][j] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                solve(board, i, j, root, result);
            }
        }

        return result;
    }
}
