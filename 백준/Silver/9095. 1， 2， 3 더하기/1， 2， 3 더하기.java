import java.io.*;
import java.util.*;

public final class Main {

    public static void solve(int n, int[] dp){
        for(int i = 3; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        System.out.println(dp[n-1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());

            if(tmp <= 3){
                System.out.println(dp[tmp - 1]);
                continue;
            }
            solve(tmp, dp);
        }

    }
}