import java.io.*;
import java.util.*;

public final class Main {

    static int[] parent;
    static int[] size;

    static class Edge{
        int start;
        int end;
        long cost;

        Edge(int start, int end, long cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            pq.add(new Edge(start, end, cost));
        }
        parent = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
        size = new int[V + 1];
        Arrays.fill(size, 1);

        long result = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            if(find(edge.start) != find(edge.end)){
                merge(edge.start, edge.end);
                result += edge.cost;
            }
        }
        System.out.println(result);
    }

    static int find(int node){
        if(parent[node] == node)
            return node;
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
