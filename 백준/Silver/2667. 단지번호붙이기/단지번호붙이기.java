import java.io.*;
import java.util.*;

public final class Main {

    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, -1, 0, 1};

    static class Node{
        int row;
        int col;

        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static int bfs(char[][] graph, boolean[][] visited, int row, int col, int n){
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(row, col));
        visited[row][col] = true;
        int count = 1;

        while(!que.isEmpty()){
            Node node = que.poll();
            int myRow = node.row;
            int myCol = node.col;

            for(int i = 0; i < 4; i++){
                int nRow = myRow + dRow[i];
                int nCol = myCol + dCol[i];

                if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < n && graph[nRow][nCol] == '1' && !visited[nRow][nCol]){
                    que.add(new Node(nRow, nCol));
                    visited[nRow][nCol] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        char[][] graph = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < n; j++){
                graph[i][j] = s.charAt(j);
            }
        }

        Queue<Integer> que = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][j] == '1' && !visited[i][j]){
                    int count = bfs(graph, visited, i, j, n);
                    que.add(count);
                }
            }
        }
        System.out.println(que.size());
        while(!que.isEmpty()){
            System.out.println(que.poll());
        }


    }
}