import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        solve(n, m, visited, 0);

    }

    static List<Integer> list = new ArrayList<>();

    private static void solve(int n, int m, boolean[] visited, int recur) {
        if(recur == m){
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i < n + 1; i++){
            if(!visited[i]){
                if(!list.isEmpty() && list.get(list.size() - 1) > i)
                    continue;
                list.add(i);
                visited[i] = true;
                solve(n, m, visited, recur + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}