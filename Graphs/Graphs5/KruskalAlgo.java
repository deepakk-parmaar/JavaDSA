package Graphs5;

import java.util.*;

public class KruskalAlgo {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.dest = nbr;
            this.weight = wt;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight;
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

    public static void kruskals(Graph graph, int parent[], int rank[], ArrayList<Edge> mst) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < graph.V; i++) {
            for (Edge e : graph.adjList[i]) {
                pq.add(e);
            }
        }
        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            int psrc = find(curr.src, parent);
            int pdest = find(curr.dest, parent);
            if (psrc != pdest) {
                union(curr.src, curr.dest,parent,rank);
                mst.add(curr);
            }
        }
    }

    public static int find(int x, int parent[]) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    public static void union(int x, int y, int parent[], int rank[]) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px == py) {
            return;
        }
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px ]> rank[py]) {
            parent[py] = px;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 10);
        graph.addEdge(0, 3, 40);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 3);
        graph.addEdge(5, 6, 3);
        graph.addEdge(4, 6, 8);
        int parent[] = new int[graph.V];
        int rank[] = new int[graph.V];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        ArrayList<Edge> mst = new ArrayList<>();
        kruskals(graph, parent, rank, mst);
        for (Edge e : mst) {
            System.out.println(e.src + " -> " + e.dest + " @ " + e.weight);
        }
    }
}
