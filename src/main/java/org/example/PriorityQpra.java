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


    }

    private static int Dijkstra(ArrayList<Node>[] graph, int n, int start) {
        boolean[] check = new boolean[n+1];
        int[] result = new int[n+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(result,INF);
        result[0] = 0;
        result[start] =0;
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y)-> Integer.compare(x.cost, y.cost));

        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            int cur = pq.poll().index;
            if(check[cur]) continue;
            check[cur] = true;


            for(Node node: graph[cur]){
                if(result[node.index]> node.cost+result[cur]){
                    result[node.index]= node.cost+result[cur];
                }
                pq.offer(new Node(node.index, result[node.index]));
            }
        }

        int m=0;
        for(int x: result){
            if(x == INF) return -1;
            m  = Math.max(m,x);
        }
        return m;

        //최소거리 출력
//        for(int i : dist) {
//            if(i == INF) System.out.print(0 + " ");
//            else System.out.print(i+" ");
//        }
    }
}
