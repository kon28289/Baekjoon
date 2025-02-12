import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Color{
        int R,G,B;

        Color(int r,int g,int b){
            R=r;
            G=g;
            B=b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringTokenizer st;
        Color[] colors = new Color[N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            colors[i] = new Color(R,G,B);
        }

        int[][] dp = new int[N + 1][4]; // 집/색 -> 비용
        dp[1][1] = colors[1].R;
        dp[1][2] = colors[1].G;
        dp[1][3] = colors[1].B;


        for(int i = 2; i <= N; i++) {
            for(int j = 1; j < 4; j++) {
                if(j == 1){
                    dp[i][j] = colors[i].R + Math.min(dp[i - 1][2], dp[i - 1][3]);
                }
                else if(j == 2){
                    dp[i][j] = colors[i].G + Math.min(dp[i - 1][1], dp[i - 1][3]);
                }
                else if(j == 3){
                    dp[i][j] = colors[i].B + Math.min(dp[i - 1][2], dp[i - 1][1]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i < 4; i++) {
            answer = Math.min(answer, dp[N][i]);
        }
        System.out.println(answer);
    }

}
