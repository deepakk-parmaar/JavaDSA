package Graphs2;

import java.util.*;

public class CycleDetectionUndirected {
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
    
    public static void addEdge(Graph g,int src,int dest,int weight){
        g.adjList[src].add(new Edge(src, dest, weight));
        g.adjList[dest].add(new Edge(dest, src, weight));
    } 
        
    public static boolean isCyclic(Graph g){
        boolean visited[]=new boolean[g.V];
        for(int i=0;i<g.V;i++){
            if(!visited[i]){
                if(isCyclicHelper(g,i,visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicHelper(Graph g,int src,boolean visited[],int parent){
        visited[src]=true;
        for(Edge e:g.adjList[src]){
            if(!visited[e.dest]){
                if(isCyclicHelper(g,e.dest,visited,src)){
                    return true;
                }
            }
            else if(e.dest!=parent){
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(Graph graph) {
        boolean visited[]=new boolean[graph.V];
        boolean check=false;
        for(int i=0;i<graph.V;i++){
            if(!visited[i]){
                check=detectCycleUtil(graph,visited,i,-1);
            }
        }
        return check;
    }
    public static boolean detectCycleUtil(Graph graph,boolean visited[],int curr,int par) {
        visited[curr]=true;
        for(Edge e: graph.adjList[curr]){
            if(visited[e.dest]==true && e.dest!=par){
                return true;
            }else if(visited[e.dest]==true && e.dest==par){
                continue;
            }else{
                return detectCycleUtil(graph, visited, e.dest, curr);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V=6;
        Graph g=new Graph(V);
        //addEdge(g,0, 5, 0);
        addEdge(g,1, 2, 0);
        addEdge(g,1, 3, 0);
        //addEdge(g,2, 3, 0);
        addEdge(g,3, 4, 0);
        //addEdge(g,4, 5, 0);
        addEdge(g,0, 4, 0);
        System.out.println(isCyclic(g));
        System.out.println(detectCycle(g));
        
    }
}
