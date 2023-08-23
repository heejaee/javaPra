package org.example;

import java.util.*;

class Node implements  Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return Integer.compare(this.cost, o.cost);
    }

}

public class PriorityQpra {

    static ArrayList<Node>[] graph;
    public static void main(String[] args) {
        int n = 4;
        int[][] times ={{2,1,1},{2,3,1},{3,4,1}};
        graph = new ArrayList[n+1];

        for(int i =0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph[u].add(new Node(v,w));
        }
        int start = 2;
        System.out.println(Dijkstra(n,start));

    }

    private static int Dijkstra(int n, int start) {
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist,INF);
        dist[start]=0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while (!pq.isEmpty()) {
            int now = pq.poll().index;

            if(check[now]) continue;
            check[now] = true;

            for(Node next: graph[now]){
                if(dist[next.index]> dist[now]+next.cost){
                    dist[next.index] = dist[now] + next.cost;
                }

                pq.offer(new Node(next.index, dist[next.index]));
            }
        }

        for (int i : dist) {
            System.out.println("i = " + i);
        }
        int m = 0;
        for(int x: dist){
            if (x==INF) return -1;
            m = Math.max(m,x);
        }
        System.out.println("m = " + m);
        return m;
        //최소거리 출력
//        for(int i : dist) {
//            if(i == INF) System.out.print(0 + " ");
//            else System.out.print(i+" ");
//        }
    }
}
