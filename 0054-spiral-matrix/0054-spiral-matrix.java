class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int sr = 0;
        int er = matrix.length - 1;
        int sc = 0;
        int ec = matrix[0].length - 1;

        while (sr <= er && sc <= ec) {

            // Top
            for (int j = sc; j <= ec; j++) {
                ans.add(matrix[sr][j]);
            }

            // Right
            for (int i = sr + 1; i <= er; i++) {
                ans.add(matrix[i][ec]);
            }

            // Bottom
            if (sr != er) {
                for (int j = ec - 1; j >= sc; j--) {
                    ans.add(matrix[er][j]);
                }
            }

            // Left
            if (sc != ec) {
                for (int i = er - 1; i >= sr + 1; i--) {
                    ans.add(matrix[i][sc]);
                }
            }

            sr++;
            er--;
            sc++;
            ec--;
        }

        return ans;
    }
}