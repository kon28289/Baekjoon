import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Item{
        public int W;
        public int V;

        Item(int w, int v){
            W = w;
            V = v;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Item> items = new ArrayList<>();
        int[][] dp = new int[N + 1][K + 1]; // 물품/무게
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            items.add(new Item(W, V));
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= K; j++){
                // 이전 값을 그대로 쓰거나
                dp[i][j] = dp[i - 1][j];
                // 다른 애하고 합치거나
                if(j >= items.get(i - 1).W){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - items.get(i - 1).W] + items.get(i - 1).V);
                }
            }
        }
        System.out.println(dp[N][K]);


    }
}

