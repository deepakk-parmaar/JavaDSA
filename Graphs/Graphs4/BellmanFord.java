package Graphs4;

import java.util.*;

public class BellmanFord {
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

    public static void bellmanFord(Graph graph, int src) {
        int V = graph.V;
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge e : graph.adjList[u]) {
                    int v = e.dest;
                    int wt = e.weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for (int u = 0; u < V; u++) {//Check for negative cycles
            for (Edge e : graph.adjList[u]) {//If we can relax the edges further, then there is a negative cycle
                int v = e.dest;
                int wt = e.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    System.out.println("Negative Cycle");
                    return;
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }

    public static void bFord(Graph graph,int src) {
        int dist[] = new int[graph.V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < graph.V - 1; i++) {//Relax all edges V-1 times
            for (int j = 0; j < graph.V; j++) {
                for (Edge e : graph.adjList[j]) {
                    int u = e.src;
                    int v = e.dest;
                    int weight = e.weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {//Relaxation
                        dist[v] = dist[u] + weight;//Update the distance
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i+" -> "+dist[i]);
        }
    }//time->O(V*E)
    public static void main(String[] args) {
        //Create a graph with non negative cycles to use in bellman ford
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, -8);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, -5);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 4, 9);
        graph.addEdge(3, 4, 4);
        bellmanFord(graph, 0);
        System.out.println("Using bFord");
        bFord(graph, 0);

    }
}
