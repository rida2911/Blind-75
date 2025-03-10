class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true; // Word found
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index))
            return false; // Out of bounds or mismatch

        char temp = board[i][j]; // Store current character
        board[i][j] = '#'; // Mark visited

        boolean found = dfs(board, word, i + 1, j, index + 1) ||  // Down
                        dfs(board, word, i - 1, j, index + 1) ||  // Up
                        dfs(board, word, i, j + 1, index + 1) ||  // Right
                        dfs(board, word, i, j - 1, index + 1);    // Left

        board[i][j] = temp; // Restore character after backtracking
        return found;
    }
}
