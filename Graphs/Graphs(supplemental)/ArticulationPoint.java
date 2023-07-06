import java.util.ArrayList;

public class ArticulationPoint {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int V;
        ArrayList<Edge>[] adjList;

        Graph(int V) {
            this.V = V;
            this.adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<Edge>();
            }
        }

        void addEdge(int src, int dest, int weight) {
            adjList[src].add(new Edge(src, dest, weight));
        }
    }

    public static void articulationPoint(Graph graph) {
        int disc[] = new int[graph.V];
        int low[] = new int[graph.V];
        int time = 0;
        boolean visited[] = new boolean[graph.V];
        boolean ap[] = new boolean[graph.V];
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                articulationPointutil(graph, i, visited, low, disc, time, -1, ap);
            }
        }
    }

    public static void articulationPointutil(Graph graph, int curr, boolean visited[], int low[], int disc[], int time,
            int parent, boolean ap[]) {
        visited[curr] = true;
        low[curr] = disc[curr] = ++time;
        int children = 0;
        for (Edge e : graph.adjList[curr]) {
            int neigh = e.dest;
            if (parent == neigh) {
                continue;
            }
            if (!visited[neigh]) {
                articulationPointutil(graph, neigh, visited, low, disc, time, curr, ap);
                low[curr] = Math.min(low[neigh], low[curr]);
                if (parent != -1 && disc[curr] <= low[neigh]) {
                    System.out.println("Articulation point:" + curr);
                    ap[curr] = true;
                }
                children++;
            } else if (visited[neigh]) {
                low[curr] = Math.min(low[curr], disc[neigh]);
            }
        }
        if (parent == -1 && children > 1) {
            System.out.println("Articulation point:" + curr);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        // 0
        // |
        // 1
        // / \
        // 2 3
        // / \ \
        // 4 5 6
        // create above graph
        g.addEdge(0, 1, 0);
        g.addEdge(1, 2, 0);
        g.addEdge(1, 3, 0);
        g.addEdge(2, 4, 0);
        g.addEdge(2, 5, 0);
        g.addEdge(3, 6, 0);
        articulationPoint(g);
    }
}
