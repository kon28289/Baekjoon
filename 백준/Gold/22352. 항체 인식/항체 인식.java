import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int row;
        int col;

        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                graph[i][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                result[i][j] = tmp;
            }
        }

        int xValue = 50;
        int yValue = 50;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m && xValue == 50 && yValue == 50 ; j++) {
                if(graph[i][j] != result[i][j]){
                    xValue = i;
                    yValue = j;
                }
            }
        }

        if(xValue == 50 && yValue == 50){
            System.out.println("YES");
            return;
        }
        int value = graph[xValue][yValue];
        Queue<Node> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, -1, 0, 1};

        que.add(new Node(xValue, yValue));
        visited[xValue][yValue] = true;
        graph[xValue][yValue] = result[xValue][yValue];
        while(!que.isEmpty()){
            Node node = que.poll();

            for(int k = 0; k < 4; k++){
                int nRow = node.row + dRow[k];
                int nCol = node.col + dCol[k];

                if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && !visited[nRow][nCol] && graph[nRow][nCol] == value){
                    que.add(new Node(nRow, nCol));
                    visited[nRow][nCol] = true;
                    graph[nRow][nCol] = result[xValue][yValue];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] != result[i][j]){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }


}
