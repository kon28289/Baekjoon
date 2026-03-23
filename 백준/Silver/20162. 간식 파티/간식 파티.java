
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 0은 현재 간식을 안먹음, 1은 현재 간식을 먹음
        int[] dp = new int[N + 1];
        int ans = 0;
        for(int i = 1; i < N + 1; i++){
            dp[i] = score[i];

            for(int j = 1; j < i; j++){
                if(score[j] < score[i]){
                    dp[i] = Math.max(dp[i], dp[j] + score[i]);
                }
            }
            ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);
    }
}