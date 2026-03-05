import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        
        int[] clothes = new int[n + 1];
        Arrays.fill(clothes, 1);
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int p : reserve){
            clothes[p] += 1;
        }
        for(int need : lost){
            clothes[need] -= 1;
        }
        
        for(int have : reserve){
            for(int need : lost){
                if(clothes[have] > 1){
                    if(clothes[need] == 0 && (have - 1 == need || have + 1 == need)){
                        clothes[need] += 1;
                        clothes[have] -= 1;
                        break;
                    }
                }
            }
        }
        
        for(int i : clothes){
            if(i > 0)
                answer++;
        }

        return answer - 1;
    }
}