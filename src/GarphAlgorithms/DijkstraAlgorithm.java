package GarphAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src= src;
            this.dest= dest;
            this.wt=wt;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length; i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int n, int d){
            this.node=n;
            this.dist=d;
        }

        @Override
        public int compareTo(Pair p) {
            return this.dist-p.dist;
        }
    }
    public static int[] dijkstra(ArrayList<Edge>graph[], int source){
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        int[] dist= new int[graph.length];
        boolean[] visited=new boolean[graph.length];

        pq.add(new Pair(source, 0));

        for(int i=0; i< dist.length; i++){
            if(i!= source)
               dist[i]= Integer.MAX_VALUE;
        }

        while(!pq.isEmpty()){
            Pair curr= pq.remove();
            if(!visited[curr.node]){
                visited[curr.node]= true;
                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e= graph[curr.node].get(i);
                    int u= e.src;
                    int v= e.dest;
                    if(!visited[v] && dist[u]+ e.wt< dist[v]){
                        dist[v]= dist[u]+ e.wt;
                        pq.add(new Pair(v, dist[v]));

                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        int [] ans= dijkstra(graph, 0);
        for(int val: ans){
            System.out.print(val+ " ");
        }
    }
}
