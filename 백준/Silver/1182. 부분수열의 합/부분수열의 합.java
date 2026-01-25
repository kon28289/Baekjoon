import java.io.*;
import java.util.*;

public final class Main {

    static int ans;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        ans = 0;
        solve(S, 0, 0);
        System.out.println(ans);
    }

    private static void solve(int S, int sum, int start) {
        if(S == sum && start != 0){
            ans++;
        }

        for (int i = start; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                solve(S, sum + arr[i], i + 1);
                visited[i] = false;
            }
        }
    }


}
