import java.io.*;
import java.util.*;

public final class Main {

    static int[][] graph;
    static int N;
    static int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        graph = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = solve(B);
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] solve(long B) {
        if(B == 1){
            int[][] returned = new int[N + 1][N + 1];
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    returned[i][j] = graph[i][j] % MOD;
                }
            }
            return returned;
        }

        long n = B / 2;
        int[][] returned = solve(n);
        if(B % 2 == 1){
            return multiply(multiply(returned, returned), graph);
        }
        return multiply(returned, returned);
    }

    static int[][] multiply(int[][] graph1, int[][] graph2){
        int[][] result = new int[graph1.length][graph1.length];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int tmp = 0;
                for (int k = 1; k < N + 1; k++) {
                    tmp += graph1[i][k] * graph2[k][j] % MOD;
                    result[i][j] = tmp % MOD;
                }
            }
        }
        return result;
    }
}
