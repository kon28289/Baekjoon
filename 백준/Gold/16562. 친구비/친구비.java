import java.io.*;
import java.util.*;

public class Main{

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cost = new int[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            int root1 = find(p1);
            int root2 = find(p2);
            if(cost[root1] > cost[root2]){
                parent[root1] = root2;
            }
            else{
                parent[root2] = root1;
            }
        }

        int sum = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            int now = find(i);
            if(!visited.contains(now)){
                visited.add(now);
                sum += cost[now];
            }
        }

        if(sum > K){
            System.out.println("Oh no");
        }
        else{
            System.out.println(sum);
        }
    }

    private static int find(int now){
        if(parent[now] != now){
            return find(parent[now]);
        }
        return now;
    }
}