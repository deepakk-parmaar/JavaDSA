package Graphs2;
import java.util.*; 
public class Bipartite {
    
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
        graph.adjList[src].add(new Edge(src, dest, weight));
        graph.adjList[dest].add(new Edge(dest, src, weight));

    }

    public static boolean isBipartite(Graph graph){
        int color[]=new int[graph.V];
        Arrays.fill(color, -1);
        for(int i=0;i<graph.V;i++){
            if(color[i]==-1){
                if(!isBipartiteHelper(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartiteHelper(Graph graph,int src,int color[]){
        color[src]=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int u=q.poll();
            for(Edge e:graph.adjList[u]){
                if(color[e.dest]==-1){
                    color[e.dest]=1-color[u];
                    q.add(e.dest);
                }
                else if(color[e.dest]==color[u]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bipartite(Graph graph) {
        int color[]=new int[graph.V];
        for(int i=0;i<graph.V;i++){
            color[i]=-1;
        }
        for(int i=0;i<graph.V;i++){
            if(color[i]==-1){
                if(!bipartiteHelper(graph, color, i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bipartiteHelper(Graph graph, int[] color, int curr) {
        color[curr] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        while (!q.isEmpty()) {
            curr = q.remove();
            for (Edge e : graph.adjList[curr]) {
                 if (color[e.dest] == -1) {
                    q.add(e.dest);
                    color[e.dest] = 1 - color[curr];
                }else if (color[curr] == color[e.dest]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V=6;
        Graph graph=new Graph(V);
        addEdge(graph, 0, 1, 0);
        addEdge(graph, 1, 2, 0);
        addEdge(graph, 2, 3, 0);
        addEdge(graph, 3, 4, 0);
        addEdge(graph, 4, 5, 0);
        addEdge(graph, 5, 0, 0); 
        System.out.println(isBipartite(graph));
        System.out.println(bipartite(graph));        
    }
}
