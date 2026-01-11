import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class Main {
    static int[][] graph;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            graph = new int[2][num];
            dp = new int[2][num];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < num; k++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    graph[j][k] = tmp;
                    dp[j][k] = -1;
                }
            }

            dp[0][0] = graph[0][0];
            dp[1][0] = graph[1][0];
            for (int col = 1; col < num; col++) {
                for (int row = 0; row < 2; row++) {

                    if(row == 0){
                        dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col - 1] + graph[row][col]);
                    }
                    else{
                        dp[row][col] = Math.max(dp[row - 1][col - 1] + graph[row][col], dp[row][col - 1]);
                    }
                }
            }
            System.out.println(Math.max(dp[0][num - 1], dp[1][num - 1]));
        }
    }

}
