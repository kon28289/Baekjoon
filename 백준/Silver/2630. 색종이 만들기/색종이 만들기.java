import java.io.*;
import java.util.*;

public final class Main {

    static int white = 0;
    static int blue = 0;

    static void solve(int row, int col, int size, int[][] graph){
        boolean cut = false;
        int firstColor = graph[row][col];
        for(int i = row; i < row + size && !cut; i++){
            for(int j = col; j < col + size; j++){
                if(graph[i][j] != firstColor){
                    cut = true;
                    break;
                }
            }
        }

        int newSize = size / 2;
        if(cut){
            solve(row, col, newSize, graph);
            solve(row + newSize, col, newSize, graph);
            solve(row, col + newSize, newSize, graph);
            solve(row + newSize, col + newSize, newSize, graph);
        }
        else{
            if(firstColor == 0)
                white++;
            else
                blue++;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row = 0, col = 0;
        solve(row, col, n, graph);
        System.out.println(white);
        System.out.println(blue);
    }
}