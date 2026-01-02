import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int tmp = Integer.parseInt(st.nextToken());
                graph[i][j] = tmp;
            }
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                if(graph[i][k] == 0)
                    continue;
                for(int j = 0; j < n ;j++){
                    if(graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}