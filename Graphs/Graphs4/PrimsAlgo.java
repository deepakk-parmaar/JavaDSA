package Graphs4;

import java.util.*;

public class PrimsAlgo {
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

    static class Pair implements Comparable<Pair> {
        int vertex, parent, weight;

        Pair(int vertex, int parent, int weight) {
            this.vertex = vertex;
            this.parent = parent;
            this.weight = weight;
        }

        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }
    
    public static void prims(Graph graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean visited[] = new boolean[graph.V];
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (visited[curr.vertex] == true) {
                continue;
            }
            visited[curr.vertex] = true;
            if (curr.parent != -1) {
                System.out.println(curr.vertex + " via " + curr.parent + " @ " + curr.weight);
            }
            for (Edge e : graph.adjList[curr.vertex]) {
                if (visited[e.dest] == false) {
                    pq.add(new Pair(e.dest, curr.vertex, e.weight));
                }
            }
        }
    }

    public static void primsAlgo(Graph graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean visited[] = new boolean[graph.V];
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (visited[curr.vertex] == true) {
                continue;
            }
            visited[curr.vertex] = true;
            if (curr.parent != -1) {
                System.out.println(curr.parent + " -> " + curr.vertex + " @ " + curr.weight);
            }
            for (Edge e : graph.adjList[curr.vertex]) {
                pq.add(new Pair(e.dest, e.src, e.weight));                
            }
        }
    }

    public static void main(String[] args) {
        //Create a graph with 7 vertices
        Graph graph = new Graph(7);
        //Add edges
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 10);
        graph.addEdge(0, 3, 40);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 3);
        graph.addEdge(5, 6, 3);
        graph.addEdge(4, 6, 8);
        graph.addEdge(2, 5, 5);
        graph.addEdge(2, 6, 8);
        
        prims(graph);
        System.out.println("===================================");
        primsAlgo(graph);

    }
}
