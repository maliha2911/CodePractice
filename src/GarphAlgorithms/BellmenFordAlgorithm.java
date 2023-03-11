package GarphAlgorithms;

import java.util.ArrayList;

// edges er weight negative hoile, bellmenfor lagbe
//dynamic programming
//O(V * E)
public class BellmenFordAlgorithm {

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
    public static class Pair implements Comparable<DijkstraAlgorithm.Pair>{
        int node;
        int dist;
        public Pair(int n, int d){
            this.node=n;
            this.dist=d;
        }

        @Override
        public int compareTo(DijkstraAlgorithm.Pair p) {
            return this.dist-p.dist;
        }
    }
    public static int[] bellmenford(ArrayList<Edge> graph[], int source){
        int [] dist= new int[graph.length];
        for(int i=0; i< dist.length; i++){
            if(i!= source){
                dist[i]= Integer.MAX_VALUE;
            }
        }
        for(int i=0; i< graph.length; i++){
            for( int j=0; j< graph.length; j++){
                for (int k=0; k< graph[j].size(); k++){
                    Edge e= graph[j]. get(k);
                    int u= e.src;
                    int v= e.dest;
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+ e.wt< dist[v]){
                        dist[v]= dist[u]+ e.wt;
                    }
                }
            }
        }
        return  dist;
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        int [] ans= bellmenford(graph, 0);
        for(int val: ans){
            System.out.print(val+ " ");
        }
    }
}
