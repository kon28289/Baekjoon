import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int totalMin = Integer.MIN_VALUE;
        int totalMax = Integer.MIN_VALUE;
        for(int[] size : sizes){
        
            int min = Math.min(size[0], size[1]);
            int max = Math.max(size[0], size[1]);
            
            totalMin = Math.max(min, totalMin);
            totalMax = Math.max(max, totalMax);
        }
        answer = totalMin * totalMax;
        return answer;
    }
}