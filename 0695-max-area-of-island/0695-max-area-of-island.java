
class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        boolean isVisited[][] =
            new boolean[grid.length][grid[0].length];

        // Check every cell
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1 && !isVisited[i][j]) {

                    int area = DFS(grid, i, j, isVisited);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int DFS(int[][] grid,
                   int row,
                   int col,
                   boolean isVisited[][]) {

        // Boundary check
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {

            return 0;
        }

        // Water or already visited
        if (grid[row][col] == 0 ||
            isVisited[row][col]) {

            return 0;
        }

        // Mark current cell visited
        isVisited[row][col] = true;

        // Current cell contributes 1
        int area = 1;

        // Up
        area += DFS(grid, row - 1, col, isVisited);

        // Down
        area += DFS(grid, row + 1, col, isVisited);

        // Left
        area += DFS(grid, row, col - 1, isVisited);

        // Right
        area += DFS(grid, row, col + 1, isVisited);

        return area;
    }
}

