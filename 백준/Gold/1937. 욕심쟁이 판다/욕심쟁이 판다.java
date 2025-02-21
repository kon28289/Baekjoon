import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int answer = 0;

    static int dfs(int N, int row, int col, int maxValue, int[][] dp, int[][] matrix) {
        if(row <= 0 || row > N || col <= 0 || col > N){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        dp[row][col] = 0;
        for(int k = 0; k < 4; k++){
            int newRow = row + dRow[k];
            int newCol = col + dCol[k];
            if(newRow <= 0 || newRow > N || newCol <= 0 || newCol > N){
                continue;
            }
            if(matrix[newRow][newCol] > maxValue)
                dp[row][col] = Math.max(dp[row][col], dfs(N, newRow, newCol, matrix[newRow][newCol], dp, matrix) + 1);
        }
        answer = Math.max(answer, dp[row][col]);

        return dp[row][col];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N + 1][N + 1];
        for(int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                dfs(N, i,j, matrix[i][j], dp, matrix);
            }
        }

        System.out.println(answer + 1);
    }

}
