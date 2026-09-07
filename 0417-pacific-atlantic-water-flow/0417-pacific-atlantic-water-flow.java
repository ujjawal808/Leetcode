class Solution {

    int m, n;
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        this.heights = heights;

        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
            dfs(i, n - 1, atlantic);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);
            dfs(m - 1, j, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public void dfs(int r, int c, boolean[][] visited) {

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                !visited[nr][nc] &&
                heights[nr][nc] >= heights[r][c]) {

                dfs(nr, nc, visited);
            }
        }
    }
}