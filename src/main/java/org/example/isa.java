package org.example;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class isa {


    public static void bfs(int x,int y,char[][]grid, boolean[][]visited){

        int rowLength = grid.length;
        int colLength = grid[0].length;

        Queue<Point> q = new LinkedList<>();
        visited[x][y] =true;
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        q.offer(new Point(x,y));
        while(!q.isEmpty()){
            Point p = q.poll();
            int cx = p.x;
            int cy = p.y;
            for(int i=0;i<4;i++){
                int nx = dx[i];
                int ny = dy[i];

                if(nx>=0 && nx<rowLength && ny>=0 && ny<colLength){
                    if((!visited[nx][ny]) && grid[nx][ny]=='1'){
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny));
                    }
                }
            }
        }
    }



    public static int numIslands(char[][] grid) {

        int cnt =0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean visited[][]  = new boolean[rowLength][colLength];


        for(int i=0; i<rowLength;i++){
            for(int j=0; j<colLength;j++){
                if((!visited[i][j]) && (grid[i][j]=='1')){
                    bfs(i,j,grid,visited);
                    cnt +=1;
                }
            }
        }


        return cnt;
    }

    public static void main(String[] args) {
        char[][] grid={ {'1','1','1','1','0'},
                        {'1','1','0','0','0'},
                        {'1','1','0','1','0'},
                        {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));

    }
}