
import java.util.*;

class Solution {

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Create graph
        ArrayList<Edge> graph[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Create edges
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            // Undirected graph
            graph[u].add(new Edge(u, v, 1));
            graph[v].add(new Edge(v, u, 1));
        }

        // Find path using DFS
        boolean isVisited[] = new boolean[n];

        return hasPath(graph, isVisited, source, destination);
    }

    public boolean hasPath(ArrayList<Edge> graph[],
                            boolean isVisited[],
                            int src,
                            int dest) {

        // If source becomes destination
        if (src == dest) {
            return true;
        }

        // Mark current vertex visited
        isVisited[src] = true;

        // Find neighbours
        for (int i = 0; i < graph[src].size(); i++) {

            Edge e = graph[src].get(i);

            if (!isVisited[e.dest]) {

                if (hasPath(graph, isVisited, e.dest, dest)) {
                    return true;
                }
            }
        }

        return false;
    }
}
