import java.util.*;

public class TarjansAlgo {
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
        ArrayList<Edge> adjList[];

        Graph(int V) {
            this.V = V;
            this.adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        void addEdge(int src, int dest, int weight) {
            adjList[src].add(new Edge(src, dest, weight));
        }
    }

    // Steps for tarjan's algo
    // 1. Make two arrays disc[] and low[] i.e, discovery time and low time
    // 2. Make an int time = 0 and visited[]
    // 3. Do a dfs and increment time
    // 4. In the dfs, set disc[src] = low[src] = ++time
    // 5. For every adjacent vertex of src, if it is not visited, do a dfs on it
    // 6. If it is visited, then set low[src] = Math.min(low[src], disc[dest])
    // 7. If disc[src] < low[dest], then it is a bridge

    public static void tarjanBridgeUtil(Graph graph, int curr, int disc[], int low[], boolean visited[], int time,
            int parent) {
        visited[curr] = true;
        disc[curr] = low[curr] = ++time;
        for (Edge e : graph.adjList[curr]) {
            int neigh = e.dest;
            if(neigh==parent){
                continue;
            }
            if (!visited[neigh]) {
                tarjanBridgeUtil(graph,neigh, disc, low, visited, time, curr);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (disc[curr] < low[neigh]) {
                    System.out.println("Bridge: "+curr+" -> "+neigh);
                }
            } else if (visited[neigh]) {
                low[curr] = Math.min(low[curr], disc[neigh]);
            }
        }
    }

    public static void tarjanBridge(Graph graph) {
        int disc[] = new int[graph.V];
        int low[] = new int[graph.V];
        boolean visited[] = new boolean[graph.V];
        int time = 0;
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                tarjanBridgeUtil(graph, i, disc, low, visited, time, -1);// -1 is the parent of the source
                // modified dfs
            }
        }
    }
    
    public static void main(String[] args) {
        //Create graph with one bridge and 15 edges
        Graph graph = new Graph(9);
        graph.addEdge(0, 1, 0);
        graph.addEdge(0, 2, 0);
        graph.addEdge(1, 2, 0);
        graph.addEdge(2, 3, 0);
        graph.addEdge(3, 4, 0);
        graph.addEdge(2, 5, 0);
        graph.addEdge(5, 6, 0);
        graph.addEdge(6, 7, 0);
        graph.addEdge(7, 8, 0);
        graph.addEdge(8, 5, 0);
        graph.addEdge(8, 2, 0);
        graph.addEdge(8, 3, 0);
        graph.addEdge(8, 4, 0);
        graph.addEdge(8, 6, 0);
        graph.addEdge(8, 7, 0);
        tarjanBridge(graph);
    }
}