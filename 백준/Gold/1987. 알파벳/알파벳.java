import java.io.*;
import java.util.*;

public final class Main {

    static char[][] graph;
    static int R;
    static int C;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int k = 0; k < s.length(); k++) {
                graph[i][k] = s.charAt(k);
            }

        }

        ans = 1;
        boolean[] visited = new boolean[26];
        visited[graph[0][0] - 'A'] = true;
        solve(visited,  0, 0, 1);
        System.out.println(ans);
    }

    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, -1, 0, 1};

    private static void solve(boolean[] visited, int row, int col, int count) {
        for (int i = 0; i < 4; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if(nRow >= 0 && nRow < R && nCol >= 0 && nCol < C && !visited[graph[nRow][nCol] - 'A']){
                visited[graph[nRow][nCol] - 'A'] = true;
                ans = Math.max(ans, count + 1);
                solve(visited, nRow, nCol, count + 1);
                visited[graph[nRow][nCol] - 'A'] = false;
            }
        }
    }
}
