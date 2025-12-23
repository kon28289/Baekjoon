import java.io.*;
import java.util.*;

public final class Main {

    public static int count = 0;

    public static void dfs(int[][] graph, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print((v + 1) + " ");

        for(int i = 0; i < graph[v].length; i++){
            if(!visited[i] && graph[v][i] != Integer.MAX_VALUE){
                dfs(graph, visited, i);
            }
        }
    }

    public static void bfs(int[][] graph, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int start = queue.poll();
            System.out.print((start + 1) + " ");
            for(int i = 0; i < graph[start].length; i++){
                if(!visited[i] && graph[start][i] != Integer.MAX_VALUE){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] graph1 = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(graph1[i], Integer.MAX_VALUE);
        }
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            graph1[start][end] = 1;
            graph1[end][start] = 1;
        }
        int[][] graph2 = new int[n][n];
        for(int i = 0; i < n; i++){
            graph2[i] = graph1[i].clone();
        }

        dfs(graph1, visited1,v - 1);
        System.out.println();
        bfs(graph2, visited2,v - 1);
        return;

    }
}