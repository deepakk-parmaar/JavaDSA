package Graphs2;

import java.util.*;

public class TopologicalSort {
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
        ArrayList<Edge> adjList[];

        Graph(int V) {
            this.V = V;
            adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }
    }

    public static void addEdge(Graph g, int src, int dest, int weight) {
        g.adjList[src].add(new Edge(src, dest, weight));
    }

    public static void topologicalSort(Graph g) {
        boolean visited[] = new boolean[g.V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < g.V; i++) {
            if (!visited[i]) {
                topologicalSortHelper(g, i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void topologicalSortHelper(Graph g, int src, boolean visited[], Stack<Integer> stack) {
        visited[src] = true;
        for (Edge e : g.adjList[src]) {
            if (!visited[e.dest]) {
                topologicalSortHelper(g, e.dest, visited, stack);
            }
        }
        stack.push(src);
    }

    public static void topSort(Graph graph) {
        boolean visited[] = new boolean[graph.V];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                topSortUtil(graph, visited, s, i);
            }
        }

        while (!s.isEmpty()) {
            if (s.size() == 1) {
                System.out.println(s.pop());
            } else
                System.out.print(s.pop() + "->");
        }
    }

    public static void topSortUtil(Graph graph, boolean visited[], Stack<Integer> s, int curr) {
        visited[curr] = true;
        for (Edge e : graph.adjList[curr]) {
            if (!visited[e.dest]) {
                topSortUtil(graph, visited, s, e.dest);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        //create a directed graph with 5 vertices and without any cycles
        Graph g = new Graph(5);
        addEdge(g, 0, 1, 1);
        addEdge(g, 0, 2, 1);
        addEdge(g, 1, 3, 1);
        addEdge(g, 2, 3, 1);
        addEdge(g, 2, 4, 1);
        addEdge(g, 3, 4, 1);
        topologicalSort(g);
        System.out.println();
        topSort(g);
    }
}
// Time Complexity: O(V+E)
// Space Complexity: O(V)
// 1. Create a stack to store the topological order.
// 2. Create a boolean array to keep track of visited nodes.
// 3. Iterate over all the nodes of the graph and call the topologicalSortHelper function on the nodes which are not visited.
// 4. In the topologicalSortHelper function, mark the current node as visited and then recursively call the function on all the adjacent nodes of the current node.
// 5. After the recursive call, push the current node into the stack.
// 6. After the iteration is over, print the stack.
// 7. The topological sort of a graph is not unique. There can be multiple topological sorts of a graph.
// 8. The topological sort of a graph is only possible if the graph is a directed acyclic graph (DAG).
