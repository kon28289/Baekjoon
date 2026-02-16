import java.io.*;
import java.util.*;

public final class Main {

    static int N;
    static int[][] graph;
    static int island;
    static boolean[][] visited;
    static int ans;

    static class Node{
        int row;
        int col;
        int bridge;

        Node(int row, int col){
            this.row = row;
            this.col = col;
        }

        Node(int row, int col, int bridge){
            this.row = row;
            this.col = col;
            this.bridge = bridge;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        island = 1;
        visited = new boolean[N][N];
        ans = Integer.MAX_VALUE;

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 다 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && graph[i][j] != 0){
                    bfs(i,j);
                    island++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        // 다리 연결하기
        int pre = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] != 0 && pre != graph[i][j]){
                    bfs2(i,j);
                    pre = graph[i][j];
                }
            }
        }

        System.out.println(ans);

    }

    private static void bfs2(int row, int col) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(row, col));
        boolean[][] visited = new boolean[N][N];
        visited[row][col] = true;


        while(!q.isEmpty()){
            Node node = q.poll();

            // 바다가 아닌데 나와 다른 값을 가진 땅을 만났다면
            if(graph[node.row][node.col] != 0 && graph[node.row][node.col] != graph[row][col]){
                ans = Math.min(ans, node.bridge);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = node.row + dx[i];
                int nCol = node.col + dy[i];

                if(nRow >= 0 && nRow < N && nCol >= 0 && nCol < N && !visited[nRow][nCol]){
                    int bridge = node.bridge;
                    if(graph[nRow][nCol] == 0)
                        bridge++;
                    q.add(new Node(nRow, nCol, bridge));
                    visited[nRow][nCol] = true;
                }
            }
        }
    }

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    private static void bfs(int row, int col) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(row, col));
        visited[row][col] = true;
        graph[row][col] = island;

        while(!q.isEmpty()){
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = node.row + dx[i];
                int nCol = node.col + dy[i];

                if(nRow >= 0 && nRow < N && nCol >= 0 && nCol < N && !visited[nRow][nCol] && graph[nRow][nCol] != 0){
                    q.add(new Node(nRow, nCol));
                    visited[nRow][nCol] = true;
                    graph[nRow][nCol] = island;
                }
            }
        }


    }
}
