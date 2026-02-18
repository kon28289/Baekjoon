import java.io.*;
import java.util.*;

public final class Main {

    static int[][] graph;
    static int N;

    static class Node{
        int row;
        int col;
        int time;

        Node(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        X += 500;
        Y += 500;

        graph = new int[1001][1001];
        graph[X][Y] = 2;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            x += 500;
            y += 500;
            graph[x][y] = 1;
        }

        solve();

    }

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    private static void solve() {
        boolean[][] visited = new boolean[1001][1001];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(500,500,0));
        visited[500][500] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            if(graph[node.row][node.col] == 2){
                System.out.println(node.time);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = node.row + dx[i];
                int nCol = node.col + dy[i];

                if(nRow >= 0 && nRow < 1001 && nCol >= 0 && nCol < 1001 && !visited[nRow][nCol]){
                    if(graph[nRow][nCol] != 1){
                        q.add(new Node(nRow, nCol, node.time + 1));
                        visited[nRow][nCol] = true;
                    }
                }
            }

        }

    }
}
