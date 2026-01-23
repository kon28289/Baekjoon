import java.io.*;
import java.sql.Array;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] values = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int value = Integer.parseInt(st.nextToken());
            values[i] = value;
        }

        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }


        int ans = 0;
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(N -> N.cost));
        for (int i = 1; i < n + 1; i++) {
            boolean[] visited = new boolean[n + 1];
            int[] result = new int[n + 1];
            Arrays.fill(result, Integer.MAX_VALUE);
            pq.add(new Node(i, values[i]));
            result[i] = 0;

            int sum = 0;
            while(!pq.isEmpty()){
                Node node = pq.poll();

                if(!visited[node.vertex]){
                    visited[node.vertex] = true;
                    sum += values[node.vertex];
                }
                else
                    continue;

                for (Node next : graph[node.vertex]){
                    if(!visited[next.vertex] && next.cost + result[node.vertex] < result[next.vertex]){
                        if(next.cost + result[node.vertex] <= m){
                            result[next.vertex] = next.cost + result[node.vertex];
                            pq.add(new Node(next.vertex, result[next.vertex]));
                        }
                    }
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);



    }
}
