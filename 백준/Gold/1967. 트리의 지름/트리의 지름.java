import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int vertex;
        int cost;

        Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    static List<Node>[] graph;
    static int result;
    static int maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[p].add(new Node(c, cost));
            graph[c].add(new Node(p, cost));
        }

        int ans = 0;
        result = 0;
        maxNode = 1;

        solve(1, 0, new boolean[n + 1]);
        result = 0;
        solve(maxNode, 0, new boolean[n + 1]);
        ans = Math.max(ans, result);

        System.out.println(ans);
    }

    private static void solve(int start, int sum, boolean[] visited) {
        visited[start] = true;

        if(sum > result){
            maxNode = start;
            result = sum;
        }

        for (Node next : graph[start]){
            if(!visited[next.vertex]){
                solve(next.vertex, sum + next.cost, visited);
            }
        }
    }


}
