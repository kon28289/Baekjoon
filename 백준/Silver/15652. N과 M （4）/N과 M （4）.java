import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n + 1];
        solve(n, m, 0, 0);
    }

    static List<Integer> list = new ArrayList<>();

    private static void solve(int n, int m, int pre, int recur) {
        if(recur == m){
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i < n + 1; i++){
            if(i >= pre){
                list.add(i);
                solve(n, m, i, recur + 1);
                list.remove(list.size() - 1);
            }
        }
    }

}