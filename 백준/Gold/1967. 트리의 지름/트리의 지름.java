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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        boolean[] hasChild = new boolean[n + 1];
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

            if(!hasChild[p])
                hasChild[p] = true;
        }

        int ans = 0;
        result = 0;
        for (int i = 1; i < hasChild.length; i++) {
            if(!hasChild[i]) {
                solve(i, 0,  new boolean[n + 1]);
            }
            ans = Math.max(ans, result);
        }
        System.out.println(ans);
    }

    private static void solve(int start, int sum, boolean[] visited) {
        visited[start] = true;

        for (Node next : graph[start]){
            if(!visited[next.vertex]){
                solve(next.vertex, sum + next.cost, visited);
            }
        }
        result = Math.max(result, sum);
    }


}
