package Graphs5;
import java.util.*;

public class CheapKstops {
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
    
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Graph graph = new Graph(n);
        for (int i = 0; i < flights.length; i++) {
            graph.addEdge(flights[i][0], flights[i][1], flights[i][2]);
        }
        int V = graph.V;
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= K; i++) {
            int temp[] = Arrays.copyOf(dist, V);
            for (int u = 0; u < V; u++) {
                for (Edge e : graph.adjList[u]) {
                    int v = e.dest;
                    int wt = e.weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < temp[v]) {
                        temp[v] = dist[u] + wt;
                    }
                }
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    static class Info{
        int v;
        int cost;
        int stops;

        Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapKStops(int n,int flights[][], int src, int dest, int K) {
        Graph graph = new Graph(n);
        for (int i = 0; i < flights.length; i++) {
            graph.addEdge(flights[i][0], flights[i][1], flights[i][2]);
        }
        int dis[] = new int[graph.V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > K) {
                break;
            }
            for (Edge e : graph.adjList[curr.v]) {
                int u = curr.v;
                int v = e.dest;
                int wt = e.weight;
                if (dis[u] != Integer.MAX_VALUE && dis[u] + wt < dis[v]) {
                    dis[v] = dis[u] + wt;
                    q.add(new Info(v, dis[v], curr.stops + 1));
                }
            }
        }
        return dis[dest] == Integer.MAX_VALUE ? -1 : dis[dest];
    }

    public static void main(String[] args) {
        int n = 3;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        int src = 0;
        int dest = 2;
        int K = 1;
        System.out.println(findCheapestPrice(n, flights, src, dest, K));
        cheapKStops(n, flights, src, dest, K);
        
    }
}