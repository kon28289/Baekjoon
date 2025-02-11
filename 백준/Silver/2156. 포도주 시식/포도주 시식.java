import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] wines = new int[N + 1];
        wines[0] = 0;
        for (int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            System.out.println(wines[1]);
            return;
        }

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = wines[1];
        dp[2] = wines[2] + dp[1];
        int answer = dp[2];


        for (int i = 3; i <= N; i++) {

            dp[i] = Math.max(dp[i - 3] + wines[i - 1] + wines[i], dp[i - 2] + wines[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }

}

