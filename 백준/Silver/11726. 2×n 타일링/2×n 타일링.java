import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        if(n == 1){
            System.out.println(1);
            return;
        }
        dp[2] = 2;

        for(int i = 3; i < n + 1; i++){
            dp[i] = ((dp[i - 1] % 10007) + (dp[i - 2] % 10007)) % 10007;
        }
        System.out.println(dp[n]);

    }
}