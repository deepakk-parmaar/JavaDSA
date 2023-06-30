package Graphs2;
import java.util.*;
public class ConnectedGraphs {
    static class Edge{
        int src;
        int dest;
        int weight;
        Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    static class Graph{
        int V;
        ArrayList<Edge> adjList[];
        Graph(int V){
            this.V=V;
            adjList=new ArrayList[V];
            for(int i=0;i<V;i++){
                adjList[i]=new ArrayList<>();
            }
        }
    }

    public static void addEdge(Graph graph,int src,int dest,int weight){
        Edge edge=new Edge(src, dest, weight);
        graph.adjList[src].add(edge);
    }
    
    public static void bfs(Graph graph){
        boolean visited[]=new boolean[graph.V];
        for(int i=0;i<graph.V;i++){
            if(!visited[i]){
                bfsUtil(graph,visited);
            }
        }
    }

    public static void bfsUtil(Graph graph,boolean visited[]){
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove(); 
            if(!visited[curr]){
                System.out.println(curr+"->");
                visited[curr]=true;
                for(Edge e:graph.adjList[curr]){
                    if(!visited[e.dest]){
                        q.add(e.dest);
                    }
                }
            }
        }
    }

    public static void dfs(Graph graph) {
        boolean visited[] = new boolean[graph.V];
        for(int i=0;i<graph.V;i++){
            if(!visited[i]){
                dfsUtil(graph,visited,i);
            }
        }
    }
    public static void dfsUtil(Graph graph,boolean visited[],int curr) {
        System.out.println(curr+"->");
        visited[curr]=true;
        for(Edge e:graph.adjList[curr]){
            if(!visited[e.dest]){
                dfsUtil(graph, visited, e.dest);
            }
        }
    }
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
    }
}
