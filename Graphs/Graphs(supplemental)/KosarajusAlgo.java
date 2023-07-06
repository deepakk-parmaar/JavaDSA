import java.util.*;

public class KosarajusAlgo {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int nbr, int weight) {
            this.src = src;
            this.dest = nbr;
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

    // Steps for kosaraju's algo
    // 1. Do a dfs and store the vertices in a stack or topsort
    // 2. Reverse the graph
    // 3. Do a dfs on the reversed graph using the stack

    public static void topSort(Graph graph, boolean visited[], Stack<Integer> stack, int src) {
        visited[src] = true;
        for (Edge edge : graph.adjList[src]) {
            if (!visited[edge.dest]) {
                topSort(graph, visited, stack, edge.dest);
            }
        }
        stack.push(src);
    }

    public static void reverseGraph(Graph graph, Graph revGraph) {
        for (int i = 0; i < graph.V; i++) {
            for (Edge edge : graph.adjList[i]) {
                revGraph.addEdge(edge.dest, edge.src, edge.weight);
            }
        }
    }

    public static void dfs(Graph graph, boolean visited[], int src) {
        visited[src] = true;
        System.out.print(src + "->");
        for (Edge e : graph.adjList[src]) {
            if (!visited[e.dest]) {
                dfs(graph, visited, e.dest);
            }
        }
    }

    public static void kosaraju(Graph graph) {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[graph.V];
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                topSort(graph, visited, stack, i);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        KosarajusAlgo.Graph revgraph = new Graph(graph.V);
        reverseGraph(graph, revgraph);
        while (!stack.empty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                dfs(revgraph, visited, curr);
                System.out.println();

            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1, 0);
        graph.addEdge(1, 2, 0);
        graph.addEdge(2, 0, 0);
        graph.addEdge(2, 3, 0);
        graph.addEdge(3, 4, 0);
        graph.addEdge(4, 5, 0);
        graph.addEdge(5, 3, 0);
        graph.addEdge(5, 6, 0);
        kosaraju(graph);
    }
}
