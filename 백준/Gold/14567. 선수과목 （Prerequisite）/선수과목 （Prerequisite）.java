import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            list[next].add(pre);
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            if(list[i].isEmpty()){
                dp[i] = 1;
            }
            else{
                for (int j = 0; j < list[i].size(); j++) {
                    dp[i] = Math.max(dp[list[i].get(j)] + 1, dp[i]);
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            System.out.print(dp[i] + " ");
        }
    }



}
