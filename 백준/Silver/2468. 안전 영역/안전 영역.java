import java.io.*;
import java.util.*;

public final class Main {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static class Node{
        int row;
        int col;

        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static int N;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, tmp);
                graph[i][j] = tmp;
            }
        }

        int ans = 0;
        for(int i = 0; i < maxHeight; i++){
            int count = 0;
            int[][] newGraph = new int[N][N];
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    newGraph[j][k] = (graph[j][k] - i) > 0 ? graph[j][k] - i : 0;
                }
            }

            for (int k = 0; k < N; k++) {
                for (int j = 0; j < N; j++) {
                    if(newGraph[k][j] != 0 && !visited[k][j]){
                        solve(newGraph, k, j);
                        count++;
                    }
                }
            }
            ans = Math.max(count, ans);
        }
        System.out.println(ans);

    }

    private static void solve(int[][] graph, int startRow, int startCol) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(startRow, startCol));

        while(!q.isEmpty()){
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = node.row + dx[i];
                int newCol = node.col + dy[i];

                if(newRow < N && newRow >= 0 && newCol < N && newCol >= 0 && !visited[newRow][newCol] && graph[newRow][newCol] != 0){
                    q.add(new Node(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}
