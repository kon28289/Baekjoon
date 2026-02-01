import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int cost;
        int value;

        Node(int cost, int value){
            this.cost = cost;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        int[][] dp = new int[N + 1][C + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        List<Node> city = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            city.add(new Node(cost, value));
        }

        for (int i = 1; i < N + 1; i++) {
            Node node = city.get(i - 1);
            for (int j = 1; j < C + 1; j++) {
                if(node.value > j){
                    if(dp[i - 1][j] == 0){
                        dp[i][j] = node.cost;
                    }
                    else{
                        dp[i][j] = Math.min(dp[i - 1][j], node.cost);
                    }
                }
                else{
                    if(i != 1)
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - node.value] + node.cost);
                    else
                        dp[i][j] = dp[i][j - node.value] + node.cost;
                }
            }
        }

        System.out.println(dp[N][C]);


    }

}
