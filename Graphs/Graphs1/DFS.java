package Graphs1;

import java.util.*;

public class DFS {
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

    public static void dfs( ArrayList<Edge> graph[],int curr,boolean visited[]){//time comp. O(V+E) space comp. O(V)
        
        System.out.println(curr+"->");
        visited[curr]=true;
        for(Edge e:graph[curr]){
            if(!visited[e.dest])
                dfs(graph, e.dest,visited);
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph [] = new ArrayList[6];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 5, 0));
        graph[0].add(new Edge(0, 4, 0));
        graph[0].add(new Edge(0, 1, 0));
        graph[1].add(new Edge(1, 2, 0));
        graph[1].add(new Edge(1, 3, 0));
        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[4].add(new Edge(4, 5, 0));
        graph[5].add(new Edge(5, 0, 0));
        boolean visited[] = new boolean[graph.length];
        dfs(graph,0,visited);
    }
}
