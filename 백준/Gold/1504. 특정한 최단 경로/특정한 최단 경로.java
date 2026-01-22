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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        if(E == 0){
            System.out.println(-1);
            return;
        }

        Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.cost));

        List<Node>[] list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, cost));
            list[end].add(new Node(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        int vertex1 = Integer.parseInt(st.nextToken());
        int vertex2 = Integer.parseInt(st.nextToken());

        int[] start1Result = solve(N, pq, list, 1);
        int[] startVertex1Result = solve(N, pq, list, vertex1);
        int[] startVertex2Result = solve(N, pq, list, vertex2);

        if(start1Result[vertex1] == Integer.MAX_VALUE
                || startVertex1Result[vertex2] == Integer.MAX_VALUE
                || startVertex2Result[N] == Integer.MAX_VALUE
                || start1Result[vertex2] == Integer.MAX_VALUE
                || startVertex2Result[vertex1] == Integer.MAX_VALUE
                || startVertex1Result[N] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        int distance1 = start1Result[vertex1] + startVertex1Result[vertex2] + startVertex2Result[N];
        int distance2 = start1Result[vertex2] + startVertex2Result[vertex1] + startVertex1Result[N];

        System.out.println(Math.min(distance1, distance2));


    }

    private static int[] solve(int N, Queue<Node> pq, List<Node>[] list, int start) {
        int[] result = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N + 1];
        result[start] = 0;
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();

            visited[node.vertex] = true;

            for (Node next : list[node.vertex]){
                if(!visited[next.vertex] && result[next.vertex] > result[node.vertex] + next.cost){
                    result[next.vertex] = result[node.vertex] + next.cost;
                    pq.add(new Node(next.vertex, result[next.vertex]));
                }
            }
        }
        return result;
    }
}
