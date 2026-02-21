import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] a = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            st.nextToken();
        }

        int maxSum = k * x;

        boolean[][][] dp = new boolean[n + 1][k + 1][maxSum + 1];
        dp[0][0][0] = true;

        for (int i = 1; i < n + 1; i++) {
            int person = a[i];

            for (int j = 0; j < k + 1; j++) {
                for (int l = 0; l < maxSum + 1; l++) {
                    dp[i][j][l] = dp[i-1][j][l];

                    if(j >= 1 && l >= person && dp[i - 1][j - 1][l - person])
                        dp[i][j][l] = true;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < maxSum + 1; i++) {
            if(dp[n][k][i]){
                long result = (long)i * (maxSum - i);
                ans = Math.max(result, ans);
            }
        }

        System.out.println(ans);
    }
}
