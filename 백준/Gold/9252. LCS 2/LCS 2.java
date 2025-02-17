import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int dfs(int i, int j, String A, String B, int[][] dp){
        if(i == A.length() || j == B.length()){
            return 0;
        }
        if(dp[i][j] != -1){ // 방문했다면 이미 계산됨
            return dp[i][j];
        }
        dp[i][j] = Math.max(dfs(i + 1,j,A,B,dp),dfs(i,j + 1,A,B,dp));

        if(A.charAt(i) == B.charAt(j)){
            dp[i][j] = Math.max(dp[i][j], dfs(i + 1,j + 1,A,B,dp) + 1);
        }

        return dp[i][j];
    }

    static void track(int pivot, StringBuilder sb, String A, String B, int[][] dp){
        int i = 0, j = 0;
        while(true){
            if(i == A.length() || j == B.length()){
                break;
            }
            if(dp[i][j] == pivot && A.charAt(i) == B.charAt(j)) {
                sb.append(A.charAt(i));
                pivot--;
                i++;
                j++;
            }
            else if(dp[i + 1][j] >= dp[i][j + 1]){
                i++;
            }
            else{
                j++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int aLen = A.length();
        int bLen = B.length();
        int[][] dp = new int[aLen+1][bLen+1];
        for(int i = 0; i <= aLen; i++){
            Arrays.fill(dp[i], -1);
        }

        int pivot = dfs(0, 0 ,A,B,dp);
        StringBuilder sb = new StringBuilder();
        track(pivot, sb, A, B, dp);

        System.out.println(pivot);
        System.out.println(sb.toString());
    }

}
