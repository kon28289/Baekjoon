import java.io.*;
import java.util.*;

public final class Main {

    static int v;
    static int e;
    static List<Node>[] graph;

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

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startV = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];
        for (int i = 1; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int sV = Integer.parseInt(st.nextToken());
            int eV = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[sV].add(new Node(eV, cost));
        }

        int[] distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startV] = 0;
        boolean[] visited = new boolean[v + 1];

        Queue<Node> que = new PriorityQueue<>(Comparator.comparing(n -> n.cost));
        que.add(new Node(startV, 0));

        while(!que.isEmpty()){
            Node now = que.poll();

            if(visited[now.vertex])
                continue;
            visited[now.vertex] = true;

            for(Node next : graph[now.vertex]){
                if(distance[next.vertex] > distance[now.vertex] + next.cost){
                    distance[next.vertex] = distance[now.vertex] + next.cost;
                    que.add(new Node(next.vertex, distance[next.vertex]));
                }
            }
        }
        for (int i = 1; i < v + 1; i++) {
            if(distance[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }
}
