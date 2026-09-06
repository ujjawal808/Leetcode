
import java.util.*;

class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean isVisited[] = new boolean[n];

        int count = 0;

        // Check every city
        for (int i = 0; i < n; i++) {

            if (!isVisited[i]) {

                // New province found
                count++;

                DFS(isConnected, i, isVisited);
            }
        }

        return count;
    }

    public void DFS(int[][] isConnected,
                    int curr,
                    boolean isVisited[]) {

        // Mark current city visited
        isVisited[curr] = true;

        // Find neighbours
        for (int i = 0; i < isConnected[curr].length; i++) {

            // If city is connected and not visited
            if (isConnected[curr][i] == 1 &&
                !isVisited[i]) {

                DFS(isConnected, i, isVisited);
            }
        }
    }
}

