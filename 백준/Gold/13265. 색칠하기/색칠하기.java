import java.io.*;
import java.util.*;

public class Main{

    static List<Integer>[] graph;
    static int n;
    static int[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n + 1];
            for(int j = 1; j < n + 1; j++){
                graph[j] = new ArrayList<>();
            }

            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                graph[node1].add(node2);
                graph[node2].add(node1);
            }
            visited = new int[n + 1];
            boolean answer = true;
            for (int j = 1; j < n + 1; j++) {
                if(visited[j] == 0){
                    if(!solve(j)){
                        answer = false;
                        break;
                    }
                }
            }

            if(answer){
                System.out.println("possible");
            }
            else{
                System.out.println("impossible");
            }
        }
    }

    private static boolean solve(int startNode){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startNode);
        visited[startNode] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : graph[now]){
                if(visited[next] == 0){
                    visited[next] = -visited[now];
                    q.add(next);
                }
                else if(visited[next] == visited[now]){
                    return false;
                }
            }
        }
        return true;
    }
}