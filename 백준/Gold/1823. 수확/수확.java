import java.io.*;
import java.util.*;

public final class Main {

    public static int[][] dp = new int[2001][2001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[] value = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            value[i] = num;
        }

        System.out.println(solve(value, n, 1, 1, n));
    }

    static int solve(int[] value, int n, int recur, int front, int end){
        if(front > end){
            return 0;
        }

        if(dp[front][end] != -1){
            return dp[front][end];
        }

        int ans = 0;
        ans = Math.max(ans, solve(value, n, recur + 1, front + 1, end) + value[front] * recur);
        ans = Math.max(ans, solve(value, n, recur + 1, front, end - 1) + value[end] * recur);

        return dp[front][end] = ans;
    }
}
