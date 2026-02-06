import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];

        int left = 0;
        int right = 0;
        long computer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                computer += graph[i][j];
                right = Math.max(right, graph[i][j]);
            }
        }
        if(computer % 2 == 0)
            computer = computer / 2;
        else
            computer = computer / 2 + 1;

        int ans = 0;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            long cooled = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph[i][j] >= mid)
                        cooled += mid;
                    else
                        cooled += graph[i][j];
                }
            }

            if(cooled >= computer){
                right = mid - 1;
                ans = mid;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
