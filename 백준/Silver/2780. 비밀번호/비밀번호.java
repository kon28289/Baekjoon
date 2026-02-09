import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] graph = {
                {7},        // 0
                {2, 4},     // 1
                {1, 3, 5},  // 2
                {2, 6},     // 3
                {1, 5, 7},  // 4
                {2, 4, 6, 8}, // 5
                {3, 5, 9},  // 6
                {0, 4, 8},  // 7
                {5, 7, 9},  // 8
                {6, 8}      // 9
        };

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N + 1][10];
            for (int j = 0; j < 10; j++) {
                dp[1][j] = 1;
            }

            for (int j = 2; j < N + 1; j++) {
                for (int k = 0; k < 10; k++) {
                    int sum = 0;
                    for (int pre : graph[k]){
                        sum += dp[j - 1][pre];
                        sum %= 1234567;
                    }
                    dp[j][k] = sum;
                }
            }
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += dp[N][j];
                sum %= 1234567;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
