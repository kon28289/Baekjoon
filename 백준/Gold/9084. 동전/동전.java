import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int j = 0; j < N; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[10001];
            dp[0] = 1;

            for(int coin : coins){
                for(int c = coin; c <= M; c++){
                    dp[c] += dp[c - coin];
                }
            }
            System.out.println(dp[M]);
        }

    }

}