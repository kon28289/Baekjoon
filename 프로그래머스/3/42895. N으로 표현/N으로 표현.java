import java.util.*;

class Solution {
    public int solution(int N, int number) {        
        if(N == number){
            return 1;
        }
        
        Set<Integer>[] dp = new HashSet[9];
        for(int i = 1; i <= 8; i++){
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(N);
        for(int i = 2; i <= 8; i++){
            int num = 0;
            for(int k = 0; k < i; k++){
                num += N * (Math.pow(10, k));
            }
            dp[i].add(num);
            
            for(int k = 1; k < i ; k++){
                Set<Integer> left = dp[k];
                Set<Integer> right = dp[i - k];
                
                for(int lt : left){
                    for(int rt : right){
                        dp[i].add(lt + rt);
                        dp[i].add(lt - rt);
                        dp[i].add(lt * rt);
                        if(rt != 0)
                            dp[i].add(lt / rt);
                    }
                }
                
            }
            
            if(dp[i].contains(number))
                return i;
        }
        return -1;
    }
}