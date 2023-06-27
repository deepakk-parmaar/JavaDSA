import java.util.ArrayList;

public class HasPath {
    
    static class Edge {
        int src;
        int dest;
        int weight;
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
            adjList = new ArrayList[V];
            for(int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }
    }

    public static void addEdge(Graph graph, int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        graph.adjList[src].add(edge);
    }

    public static boolean hasPath(Graph graph,int src,int dest,boolean visited[]){
        if(src==dest){
            return true;
        }
        visited[src]=true;
        for(Edge e: graph.adjList[src]){
            if(visited[e.dest]==false){
                return hasPath(graph, e.dest, dest, visited);
            }
        }
        return false;
    }//time comp. O(V+E) space comp. O(V)
    
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 10);
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 3);
        addEdge(graph, 5, 6, 3);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 2, 5, 5);
        addEdge(graph, 7, 8, 10);
        boolean visited[] = new boolean[graph.V];
        System.out.println(hasPath(graph, 0, 7, visited));

    }
}
