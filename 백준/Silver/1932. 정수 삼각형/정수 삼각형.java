import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class Main {

    static int[][] graph;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i + 1; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                graph[i][j] = tmp;
            }
        }
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(1,1, n));

    }

    private static int solve(int row, int col, int n) {
        if(row > n)
            return 0;

        if(dp[row][col] != -1)
            return dp[row][col];

        int ans = 0;
        ans = Math.max(solve(row + 1, col, n) + graph[row][col], ans);
        ans = Math.max(solve(row + 1, col + 1, n) + graph[row][col], ans);

        return dp[row][col] = ans;
    }
}
