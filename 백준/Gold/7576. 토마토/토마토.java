import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int row;
        int col;
        int day;

        Node(int row, int col, int day){
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> que = new PriorityQueue<>((o1, o2) -> o1.day - o2.day);
        boolean[][] visited = new boolean[n][m];
        int countGood = 0;
        int countBad = 0;
        int countEmpty = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(graph[i][j] == 1) {
                    que.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    countGood++;
                }
                else if(graph[i][j] == 0)
                    countBad++;
                else
                    countEmpty++;
            }
        }
        if(countGood == n * m - countEmpty){
            System.out.println(0);
            return;
        }

        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, -1, 0, 1};
        Node node = new Node(0,0,0);
        while(!que.isEmpty()){
            node = que.poll();

            for(int i = 0; i < 4; i++){
                int row = node.row + dRow[i];
                int col = node.col + dCol[i];

                if(row >= 0 && col >= 0 && row < n && col < m && !visited[row][col] && graph[row][col] == 0){
                    que.add(new Node(row, col, node.day + 1));
                    visited[row][col] = true;
                    graph[row][col] = 1;
                    countGood++;
                    countBad--;
                }
            }
        }

        if(countGood == n * m - countEmpty){
            System.out.println(node.day);
            return;
        }

        if(countBad > 0)
            System.out.println(-1);
    }
}