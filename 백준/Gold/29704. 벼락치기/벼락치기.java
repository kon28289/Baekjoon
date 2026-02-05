import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int day;
        int money;

        Node(int day, int money){
            this.day = day;
            this.money = money;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        int maxMoney = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list.add(new Node(d, m));
            maxMoney += m;
        }

        int[][] dp = new int[N + 1][T + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        Arrays.fill(dp[0], 0);
        for (int i = 1; i < N + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < T + 1; j++) {
                Node node = list.get(i - 1);
                if(node.day <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - node.day] + node.money);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(maxMoney - dp[N][T]);

    }


}
