package Graphs3;

import java.util.*;

public class DijkstraAlgo {
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
    static class Pair implements Comparable<Pair> {
        int vertex;
        String path;
        int weight;

        Pair(int vertex, String path, int weight) {
            this.vertex = vertex;
            this.path = path;
            this.weight = weight;
        }

        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }
    public static void dijkstra(Graph graph, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src + "", 0));
        boolean visited[] = new boolean[graph.V];
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (visited[curr.vertex] == true) {
                continue;
            }
            visited[curr.vertex] = true;
            System.out.println(curr.vertex + " via " + curr.path + " @ " + curr.weight);
            for (Edge e : graph.adjList[curr.vertex]) {
                if (visited[e.dest] == false) {
                    pq.add(new Pair(e.dest, curr.path + e.dest, curr.weight + e.weight));
                }
            }
        }
    }

    public static void main(String[] args) {
        //Create a graph with 8 veritces with many edges and different weights
        Graph graph = new Graph(9);
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 10);
        graph.addEdge(0, 3, 40);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 3);
        graph.addEdge(5, 6, 3);
        graph.addEdge(4, 6, 8);
        graph.addEdge(2, 5, 5);
        graph.addEdge(7, 8, 10);

        dijkstra(graph, 0);
    }
}
