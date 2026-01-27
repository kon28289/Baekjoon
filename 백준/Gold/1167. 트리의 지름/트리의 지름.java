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
    static boolean[] visited;
    static int ans;
    static int maxVertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = 0;
            int start = Integer.parseInt(st.nextToken());
            int end = 0;
            while(true){
                end = Integer.parseInt(st.nextToken());
                if(end == -1)
                    break;
                int cost = Integer.parseInt(st.nextToken());
                graph[start].add(new Node(end, cost));
                graph[end].add(new Node(start, cost));
            }
        }

        visited = new boolean[V + 1];
        ans = 0;
        maxVertex = -1;
        solve(1, 0);

        ans = 0;
        Arrays.fill(visited, false);
        solve(maxVertex, 0);
        System.out.println(ans);
    }




    private static void solve(int start, int len) {
        visited[start] = true;

        for (Node next : graph[start]){
            if(!visited[next.vertex]){
                solve(next.vertex, len + next.cost);
            }
        }

        if(ans <= len){
            maxVertex = start;
            ans = len;
        }
    }
}
