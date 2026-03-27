import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];

        dp[0] = -1;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for(int i = 6; i <= N; i++){
            if(dp[i - 3] != -1 && dp[i - 5] != -1)
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            else if(dp[i - 3] != -1 && dp[i - 5] == -1)
                dp[i] = dp[i - 3] + 1;
            else if(dp[i - 3] == -1 && dp[i - 5] != -1)
                dp[i] = dp[i - 5] + 1;
            else
                dp[i] = -1;
        }

        System.out.println(dp[N]);

    }

}