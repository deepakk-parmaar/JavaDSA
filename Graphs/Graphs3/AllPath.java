package Graphs3;

import java.util.*;

public class AllPath {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.weight = wt;
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

        void addEdge(int src, int dest, int wt) {
            adjList[src].add(new Edge(src, dest, wt));
        }
    }

    public static void allPath(Graph graph, int src, int dest, String path) {
        path += "->" + (src);
        if (src == dest) {
            System.out.println(path);
            return;
        }
        for (Edge e : graph.adjList[src]) {
            allPath(graph, e.dest, dest, path);
        }
    }

    public static void main(String[] args) {
        // Create a Graph with 5 edges and only two path from 0 to 4 
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 10);
        graph.addEdge(0, 3, 10);
        graph.addEdge(1, 3, 10);
        graph.addEdge(2, 3, 10);
        graph.addEdge(3, 4, 10);
        allPath(graph, 0, 4, "");

    }
}
