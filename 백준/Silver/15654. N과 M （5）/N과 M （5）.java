import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }
        Arrays.sort(arr);
        boolean[] visited = new boolean[n];

        solve(n, m, 0, visited, arr);

    }

    static List<Integer> list = new ArrayList<>();

    private static void solve(int n, int m, int cur, boolean[] visited, int[] arr) {
        if(cur == m){
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                list.add(arr[i]);
                solve(n, m, cur + 1, visited, arr);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
