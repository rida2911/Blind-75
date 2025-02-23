class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        List<List<Integer>> result = new ArrayList<>();

        // Start DFS from Pacific (Top and Left edges)
        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, pacific, Integer.MIN_VALUE);
            dfs(heights, rows - 1, col, atlantic, Integer.MIN_VALUE);
        }

        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, row, cols - 1, atlantic, Integer.MIN_VALUE);
        }

        // Collect cells that can reach both oceans
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] ocean, int prevHeight) {
        int rows = heights.length, cols = heights[0].length;

        // Boundary & Height Check
        if (row < 0 || col < 0 || row >= rows || col >= cols || ocean[row][col] || heights[row][col] < prevHeight) {
            return;
        }

        // Mark cell as visited
        ocean[row][col] = true;

        // Explore in all four directions
        dfs(heights, row + 1, col, ocean, heights[row][col]); // Down
        dfs(heights, row - 1, col, ocean, heights[row][col]); // Up
        dfs(heights, row, col + 1, ocean, heights[row][col]); // Right
        dfs(heights, row, col - 1, ocean, heights[row][col]); // Left
    }
}
