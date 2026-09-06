
import java.util.*;

class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean isVisited[] = new boolean[rooms.size()];

        // Start DFS from room 0
        DFS(rooms, 0, isVisited);

        // Check if all rooms are visited
        for (int i = 0; i < isVisited.length; i++) {

            if (!isVisited[i]) {
                return false;
            }
        }

        return true;
    }

    public void DFS(List<List<Integer>> rooms,
                    int curr,
                    boolean isVisited[]) {

        // Mark current room as visited
        isVisited[curr] = true;

        // Find neighbours / keys
        for (int i = 0; i < rooms.get(curr).size(); i++) {

            int key = rooms.get(curr).get(i);

            if (!isVisited[key]) {

                DFS(rooms, key, isVisited);
            }
        }
    }
}
