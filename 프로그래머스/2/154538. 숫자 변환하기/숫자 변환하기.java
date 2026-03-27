import java.util.*;

class Solution {
    
    static class Node{
        int value;
        int time;
        
        Node(int value, int time){
            this.value = value;
            this.time = time;
        }
    }
    
    public int solution(int x, int y, int n) {
        
        // bfs, dp
        
        int ans = 0;
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];
        q.add(new Node(x, 0));
        visited[x] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            int value = now.value;
            int time = now.time;
            
            
            if(value == y){
                ans = time;
                return ans;
            }
            
            if(value + n <= y && !visited[value + n]){
                q.add(new Node(value + n, time + 1));
                visited[value + n] = true;
            }
                
            if(value * 2 <= y && !visited[value * 2]){
                q.add(new Node(value * 2, time + 1));
                visited[value * 2] = true;
            }
                
            if(value * 3 <= y && !visited[value * 3]){
                q.add(new Node(value * 3, time + 1));
                visited[value * 3] = true;
            }
                
        }
        
        return -1;
        
    }
}