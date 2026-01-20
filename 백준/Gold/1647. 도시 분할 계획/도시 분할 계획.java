import java.io.*;
import java.util.*;

public final class Main {

    static Queue<Edge> pq;
    static int[] parent;
    static int[] size;

    static class Edge{
        int start;
        int end;
        int cost;

        Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

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
        int M = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(start, end, cost));
        }

        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        Arrays.fill(size, 0);

        int count = 0;
        int result = 0;
        for (int i = 0; i < M; i++) {
            Edge edge = pq.poll();

            if(count == N - 2)
                break;

            if(find(edge.start) != find(edge.end)){
                merge(edge.start, edge.end);
                result += edge.cost;
                count++;
            }
        }

        System.out.println(result);
    }

    static int find(int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    static void merge(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);

        if(size[root1] > size[root2]){
            size[root1] += size[root2];
            parent[root2] = root1;
        }
        else{
            size[root2] += size[root1];
            parent[root1] = root2;
        }
    }
}
