class Solution {
    public int diagonalSum(int[][] mat) {

        int n = mat.length;
        int ans = 0;

        for(int i=0;i<n;i++){
            ans+=mat[i][i];
            ans+=mat[i][n-i-1];
        }
        // Remove duplicate center element for odd n
        if (n % 2 == 1) {
            ans -= mat[n / 2][n / 2];
        }

        return ans;
    }
}