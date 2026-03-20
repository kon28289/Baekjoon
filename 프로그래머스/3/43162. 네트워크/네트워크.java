import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int[][] graph;
    
    public int solution(int n, int[][] computers) {
        
        // 그냥 다 연결하고 그래프 탐색해서 나오는 개수 구하면 될 듯
    
        graph = new int[n][n];
        int comNum = 0;
        for(int[] com : computers){
            for(int i = 0; i < n; i++){
                if(com[i] == 1){
                    graph[comNum][i] = com[i];
                    graph[i][comNum] = com[i];
                }
            }
            comNum++;
        }
        
        for(int i = 0; i < n; i++){
            graph[i][i] = 0;
        }
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                solve(i, n);
                answer++;
            }
        }        
        return answer;
    }
    
    private void solve(int start, int n){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i < n; i++){
                if(graph[now][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}