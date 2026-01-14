import java.io.*;
import java.util.*;

public final class Main {

    static int[][] graph;
    static int[][][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n + 1][n + 1][3];
        dp[1][2][0] = 1;
        for (int row = 1; row < n + 1; row++) {
            for (int col = 1; col < n + 1; col++) {

                if(graph[row][col] == 1)
                    continue;

                if(graph[row][col] == 0){
                    if(col - 1 >= 1 && graph[row][col - 1] == 0)
                        dp[row][col][0] += dp[row][col - 1][0] + dp[row][col - 1][2];

                    if(row - 1 >= 1 && graph[row - 1][col] == 0)
                        dp[row][col][1] += dp[row - 1][col][1] + dp[row - 1][col][2];

                    if(row - 1 >= 1 && col - 1 >= 1){
                        if(graph[row - 1][col - 1] == 0 && graph[row - 1][col] == 0 && graph[row][col - 1] == 0){
                            dp[row][col][2] += dp[row - 1][col - 1][0] + dp[row - 1][col - 1][1] + dp[row - 1][col - 1][2];
                        }
                    }

                }
            }
        }
        int ans = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(ans);
    }
}
