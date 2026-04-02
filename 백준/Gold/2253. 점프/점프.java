import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Node{
        int now;
        int jumpSize;
        int count;

        Node(int now, int jumpSize, int count){
            this.now = now;
            this.jumpSize = jumpSize;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int x = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            x = Integer.parseInt(br.readLine());
            if (x == 2) {
                System.out.println(-1);
                return;
            }
            set.add(x);
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int maxJump = (int)Math.sqrt(2 * N) + 2;

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(2, 1, 1));

        boolean[][] visited = new boolean[N + 1][maxJump + 1];
        visited[2][1] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int now = node.now;
            int jumpSize = node.jumpSize;
            int count = node.count;

            if (now == N) {
                System.out.println(count);
                return;
            }

            for (int nextJumpSize = jumpSize - 1; nextJumpSize <= jumpSize + 1; nextJumpSize++) {
                if (nextJumpSize <= 0)
                    continue;

                int nextNode = now + nextJumpSize;

                if (nextNode > N)
                    continue;
                if (set.contains(nextNode))
                    continue;
                if (nextJumpSize > maxJump)
                    continue;
                if (visited[nextNode][nextJumpSize])
                    continue;

                q.add(new Node(nextNode, nextJumpSize, count + 1));
                visited[nextNode][nextJumpSize] = true;
            }
        }

        System.out.println(-1);
    }
}