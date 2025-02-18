import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Matrix{
        int rows;
        int cols;

        Matrix(int rows, int cols){
            this.rows = rows;
            this.cols = cols;
        }
    }

    static int dfs(int left, int right, ArrayList<Matrix> matrix, int[][] dp){
        if(left == right){ // 분할 끝
            return 0;
        }
        if(dp[left][right] != -1){ // 이미 체크한 경우
            return dp[left][right];
        }
        dp[left][right] = Integer.MAX_VALUE;
        for(int mid = left; mid < right; mid++){
            dp[left][right] = Math.min(dp[left][right], dfs(left, mid, matrix, dp) + dfs(mid + 1, right, matrix, dp) + matrix.get(left).rows * matrix.get(mid).cols * matrix.get(right).cols);
        }
        return dp[left][right];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        ArrayList<Matrix> matrixList = new ArrayList<>();
        // 1-base를 위한 더미 데이터
        matrixList.add(new Matrix(0,0));
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            matrixList.add(new Matrix(row,col));
        }
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(1, n, matrixList, dp));
    }

}
