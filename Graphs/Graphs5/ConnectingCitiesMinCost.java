package Graphs5;
import java.util.*;
public class ConnectingCitiesMinCost {
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

    public static int minCost(int n, int[][] connections) {
        Graph graph = new Graph(n);
        for (int[] conn : connections) {
            graph.addEdge(conn[0] - 1, conn[1] - 1, conn[2]);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean visited[] = new boolean[graph.V];
        int cost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (visited[curr.vertex] == true) {
                continue;
            }
            visited[curr.vertex] = true;
            cost += curr.weight;
            if (curr.parent != -1) {
                System.out.println(curr.vertex + " via " + curr.parent + " @ " + curr.weight);
            }
            for (Edge e : graph.adjList[curr.vertex]) {
                if (visited[e.dest] == false) {
                    pq.add(new Pair(e.dest, curr.vertex, e.weight));
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
        System.out.println(minCost(n, connections));
    }
}
