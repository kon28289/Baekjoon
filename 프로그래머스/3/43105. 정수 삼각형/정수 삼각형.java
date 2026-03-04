import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int size = 0;
        for(int[] a : triangle){
            size++;
        }
        int[][] dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < size; i++){
            
            int length = 0;
            for(int a : triangle[i]){
                length++;
            }
            
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            
            for(int j = 1; j < length - 1; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);                
            }
            
            dp[i][length - 1] = triangle[i][length - 1] + dp[i - 1][length - 2];
            
            for(int j = 0; j < length; j++){
                answer = Math.max(dp[i][j], answer);    
            }
        }
        
        return answer;
    }
}