import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        public int key;
        public int row;
        public int column;

        Node(int key, int row, int column) {
            this.key = key;
            this.row = row;
            this.column = column;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.key, other.key);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        char[][] graph = new char[row][column];
        int[][][] visited = new int[(1 << 8)][row][column];
        int startX = 0;
        int startY = 0;

        // visited 배열 초기화
        for (int i = 0; i < (1 << 8); i++) {
            for (int j = 0; j < row; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        // 그래프 입력
        for (int i = 0; i < row; i++) {
            String tmp = br.readLine();
            if (tmp.length() != column) {
                throw new IllegalArgumentException("Invalid input length");
            }
            for (int j = 0; j < column; j++) {
                graph[i][j] = tmp.charAt(j);
                if (graph[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
            }
        }
        visited[0][startX][startY] = 0;

        int[] deltaX = {0, 0, -1, 1};
        int[] deltaY = {-1, 1, 0, 0};

        PriorityQueue<Node> queue = new PriorityQueue<>(
            Comparator.comparingInt(node -> visited[node.key][node.row][node.column])
        );
        queue.add(new Node(0, startX, startY));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int key = node.key;

            if (graph[node.row][node.column] == '1') {
                System.out.println(visited[key][node.row][node.column]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int dx = node.row + deltaX[i];
                int dy = node.column + deltaY[i];
                int newKey = key;

                if (dx < 0 || dy < 0 || dx >= row || dy >= column || graph[dx][dy] == '#') {
                    continue;
                }

                if ('a' <= graph[dx][dy] && graph[dx][dy] <= 'f') {
                    int a = graph[dx][dy] - 'a';
                    newKey |= (1 << a);
                }

                if ('A' <= graph[dx][dy] && graph[dx][dy] <= 'F') {
                    int a = graph[dx][dy] - 'A';
                    if ((newKey & (1 << a)) == 0) {
                        continue;
                    }
                }

                if (visited[newKey][dx][dy] > visited[key][node.row][node.column] + 1) {
                    visited[newKey][dx][dy] = visited[key][node.row][node.column] + 1;
                    queue.add(new Node(newKey, dx, dy));
                }
            }
        }
        System.out.println(-1);
    }
}
