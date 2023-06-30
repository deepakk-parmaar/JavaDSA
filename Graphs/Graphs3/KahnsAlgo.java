package Graphs3;

import java.util.*;

public class KahnsAlgo {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.dest = nbr;
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

    public static void topologicalSort(Graph graph) {
        int indegree[] = new int[graph.V];
        for (int i = 0; i < graph.V; i++) {
            for (Edge e : graph.adjList[i]) {
                indegree[e.dest]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + "->");
            for (Edge e : graph.adjList[curr]) {
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }

        }
    }

    public static void main(String[] args) {
        // Create a Directed acyclic graph with 5 edges
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 10);
        graph.addEdge(1, 3, 10);
        graph.addEdge(2, 3, 10);
        graph.addEdge(3, 4, 10);
        graph.addEdge(4, 5, 10);
        topologicalSort(graph);
    }
}
