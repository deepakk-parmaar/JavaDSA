package Graphs2;
import java.util.*;
public class CycleDirected {
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
    }

    public static boolean isCyclic(Graph g){
        boolean visited[]=new boolean[g.V];
        boolean recStack[]=new boolean[g.V];
        for(int i=0;i<g.V;i++){
            if(!visited[i]){
                if(isCyclicHelper(g,i,visited,recStack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicHelper(Graph g,int src,boolean visited[],boolean recStack[]){
        visited[src]=true;
        recStack[src]=true;
        for(Edge e:g.adjList[src]){
            if(!visited[e.dest]){
                if(isCyclicHelper(g,e.dest,visited,recStack)){
                    return true;
                }
            }
            else if(recStack[e.dest]){
                return true;
            }
        }
        recStack[src]=false;
        return false;
    }

    public static boolean detectCycle(Graph graph){
        boolean visited[]=new boolean[graph.V];
        boolean recStack[]=new boolean[graph.V];
        for(int i=0;i<graph.V;i++){
            visited[i]=false;
            recStack[i]=false;
        }
        for(int i=0;i<graph.V;i++){
            if(detectCycleUtil(graph,visited,recStack,i)){
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(Graph graph,boolean visited[],boolean recStack[],int src){
        visited[src]=true;
        recStack[src]=true;
        for(Edge e: graph.adjList[src]){
            if(visited[e.dest]){
                if(recStack[e.dest]){
                    return true;
                }
            }else{
                if(detectCycleUtil(graph, visited, recStack, e.dest)){
                    return true;
                }
            }
        }
        recStack[src]=false;
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        addEdge(graph,0,1,0);
        addEdge(graph,1,2,0);
        addEdge(graph,2,3,0);
        addEdge(graph,3,4,0);
        addEdge(graph,4,5,0);
        addEdge(graph,5,1,0);
        System.out.println(isCyclic(graph));
        System.out.println(detectCycle(graph));
    }
}
