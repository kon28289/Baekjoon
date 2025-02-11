import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Candy{
        int C;
        int Price;

        Candy(int C, int Price){
            this.C = C;
            this.Price = Price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 1;
        int m = 1;

        while(true){
            ArrayList<Candy> candies = new ArrayList<>();
            candies.add(new Candy(0,0)); // 1-base를 위한 더미 데이터

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);

            if(n == 0 && m == 0)
                break;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
                candies.add(new Candy(N,M));
            }
            int[][] dp = new int[n + 1][m + 1]; // n: 어떤 사탕인지, m: 가지고 있는 돈 -> 최대 칼로리

            for(int i = 1; i <= n; i++){
                for(int j = 0; j <= m; j++){
                    // 이전의 값을 그대로 쓰거나
                    dp[i][j] = dp[i - 1][j];
                    // 새로 구하거나
                    if(j >= candies.get(i).Price){ // 이전 값 | 캔디를 더 샀을 때
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - candies.get(i).Price] + candies.get(i).C);
                    }
                }
            }

            System.out.println(dp[n][m]);
        }






    }
}

