import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int size = answers.length;
        
        
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int totalP1 = 0;
        int totalP2 = 0;
        int totalP3 = 0;
        int next = 0;
        for(int i = 0; i < size; i++){
            int correct = answers[i];
            if(correct == p1[next % p1.length])
                totalP1++;
            if(correct == p2[next % p2.length])
                totalP2++;
            if(correct == p3[next % p3.length])
                totalP3++;
            next += 1;
        }
        
        int max = Math.max(totalP1, Math.max(totalP2, totalP3));
        
        List<Integer> list = new ArrayList<>();
        if(totalP1 == max)
            list.add(1);
        if(totalP2 == max)
            list.add(2);
        if(totalP3 == max)
            list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}