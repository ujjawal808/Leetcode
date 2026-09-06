
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // If old color and new color are same
        // no need to do anything
        if (originalColor == color) {
            return image;
        }

        boolean isVisited[][] =
            new boolean[image.length][image[0].length];

        DFS(image, sr, sc, originalColor, color, isVisited);

        return image;
    }

    public void DFS(int[][] image,
                    int row,
                    int col,
                    int originalColor,
                    int color,
                    boolean isVisited[][]) {

        // Check boundary
        if (row < 0 || row >= image.length ||
            col < 0 || col >= image[0].length) {
            return;
        }

        // If already visited
        if (isVisited[row][col]) {
            return;
        }

        // If current pixel has different color
        if (image[row][col] != originalColor) {
            return;
        }

        // Mark visited
        isVisited[row][col] = true;

        // Change color
        image[row][col] = color;

        // Up
        DFS(image, row - 1, col,
            originalColor, color, isVisited);

        // Down
        DFS(image, row + 1, col,
            originalColor, color, isVisited);

        // Left
        DFS(image, row, col - 1,
            originalColor, color, isVisited);

        // Right
        DFS(image, row, col + 1,
            originalColor, color, isVisited);
    }
}

