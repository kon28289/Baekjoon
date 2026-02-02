import java.io.*;
import java.util.*;

public final class Main {

    static int[] arr;
    static boolean[] finished;
    static boolean[] visited;
    static int n;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            arr = new int[n + 1];
            finished = new boolean[n + 1];
            visited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            count = 0;
            for (int j = 1; j < n + 1; j++) {
                if(!visited[j])
                    dfs(j);
            }
            
            System.out.println(n - count);
        }


    }

    private static void dfs(int start) {
        visited[start] = true;
        int next = arr[start];

        if(!visited[next]){
            dfs(next);
        }
        else if(!finished[next]){
            int cur = next;
            count++;
            while(cur != start){
                cur = arr[cur];
                count++;
            }
        }
        finished[start] = true;
    }

}
