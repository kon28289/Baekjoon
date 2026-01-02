import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int row;
        int col;
        int count;

        Node(int row, int col, int count){
            this.row = row;
            this.col = col;
            this.count = count;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] graph = new char[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < m; j++){
                graph[i][j] = s.charAt(j);
            }
        }

        boolean[][] visited = new boolean[n][m];
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(0,0, 1));
        visited[0][0] = true;

        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, -1, 0, 1};
        while(!que.isEmpty()){
            Node node = que.poll();
            int row = node.row;
            int col = node.col;
            if(row == n - 1 && col == m - 1){
                System.out.println(node.count);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && graph[nRow][nCol] != '0' && !visited[nRow][nCol]){
                    que.add(new Node(nRow, nCol, node.count + 1));
                    visited[nRow][nCol] = true;
                }
            }
        }

    }
}