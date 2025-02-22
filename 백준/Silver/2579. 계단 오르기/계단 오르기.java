import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {  
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }

        int[] cost = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = cost[1];
        dp[2] = cost[1] + cost[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + cost[i], dp[i - 3] + cost[i - 1] + cost[i]);
        }
        

        System.out.println(dp[n]);
    }
}
