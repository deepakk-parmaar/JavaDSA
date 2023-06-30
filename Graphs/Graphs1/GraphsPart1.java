package Graphs1;
import java.util.*;
public class GraphsPart1{
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

    public static void main(String[] args) {
        
        int V=5;
        ArrayList<Edge> graph [] = new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 5, 0));
        graph[1].add(new Edge(1, 2, 0));
        graph[1].add(new Edge(1, 3, 0));
        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[4].add(new Edge(4, 5, 0));
        graph[0].add(new Edge(0, 4, 0));

        //2's neighbours
        for(Edge e:graph[2]){
            System.out.println(e.src+"->"+e.dest);
        }
        
    }
}