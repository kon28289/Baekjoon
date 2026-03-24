import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N;
    static int M;
    static int[][] graph;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while (true) {
            int count = countGroup();

            if (count >= 2) {
                System.out.println(time);
                return;
            }

            if (count == 0) {
                System.out.println(0);
                return;
            }

            melt();
            time++;
        }
    }

    private static int countGroup() {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                q.add(new Node(i, j));
                visited[i][j] = true;
                count++;

                while (!q.isEmpty()) {
                    Node now = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int nRow = now.row + dx[k];
                        int nCol = now.col + dy[k];

                        if (!isInRange(nRow, nCol)) {
                            continue;
                        }

                        if (visited[nRow][nCol] || graph[nRow][nCol] == 0) {
                            continue;
                        }

                        visited[nRow][nCol] = true;
                        q.add(new Node(nRow, nCol));
                    }
                }
            }
        }

        return count;
    }

    private static void melt() {
        int[][] meltAmount = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    continue;
                }

                int seaCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nRow = i + dx[k];
                    int nCol = j + dy[k];

                    if (!isInRange(nRow, nCol)) {
                        continue;
                    }

                    if (graph[nRow][nCol] == 0) {
                        seaCount++;
                    }
                }

                meltAmount[i][j] = seaCount;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    continue;
                }

                graph[i][j] -= meltAmount[i][j];
                if (graph[i][j] < 0) {
                    graph[i][j] = 0;
                }
            }
        }
    }

    private static boolean isInRange(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}