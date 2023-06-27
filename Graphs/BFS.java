import java.util.*;

public class BFS {
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

    public static void createGraph(ArrayList<Edge> graph[]){
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
    }

    public static void bfs(ArrayList<Edge> graph[]){//time comp. O(V+E) space comp. O(V)
        Queue<Integer> q= new java.util.LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(visited[curr]==true){
                continue;
            }
            visited[curr]=true;
            System.out.print(curr+" ");
            for(Edge e:graph[curr]){
                if(visited[e.dest]==false){
                    q.add(e.dest);
                }
           }
        }   
    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph [] = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
    }
}
