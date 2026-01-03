import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;


        for(int i = 2; i < n + 1; i++){
            int tmp = (int) Math.sqrt(i);
            if(tmp * tmp != i) {
                for(int j = 1; j < tmp + 1 ; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            else
                dp[i] = 1;
        }
        System.out.println(dp[n]);
    }
}