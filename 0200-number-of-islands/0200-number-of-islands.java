
class Solution {

    public int numIslands(char[][] grid) {

        int count = 0;

        boolean isVisited[][] =
            new boolean[grid.length][grid[0].length];

        // Check every cell
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1' && !isVisited[i][j]) {

                    // New island found
                    count++;

                    DFS(grid, i, j, isVisited);
                }
            }
        }

        return count;
    }

    public void DFS(char[][] grid,
                    int row,
                    int col,
                    boolean isVisited[][]) {

        // Boundary check
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {

            return;
        }

        // If water or already visited
        if (grid[row][col] == '0' ||
            isVisited[row][col]) {

            return;
        }

        // Mark current cell visited
        isVisited[row][col] = true;

        // Up
        DFS(grid, row - 1, col, isVisited);

        // Down
        DFS(grid, row + 1, col, isVisited);

        // Left
        DFS(grid, row, col - 1, isVisited);

        // Right
        DFS(grid, row, col + 1, isVisited);
    }
}

