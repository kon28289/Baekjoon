import java.util.*;

class Solution {
    
    private static class Node{
        int row;
        int col;
        int time;
        
        Node(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
    public int solution(int[][] maps) {
        
        int rowSize = maps.length;
        int colSize = maps[0].length;
        
        int ans = solve(maps, rowSize, colSize);
        System.out.println(ans);
        return ans;
    }
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    
    private int solve(int[][] maps, int rowSize, int colSize){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 1));
        boolean[][] visited = new boolean[rowSize][colSize];
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.row == rowSize - 1&& now.col == colSize - 1){
                return now.time;
            }
            
            for(int i = 0; i < 4; i++){
                int nRow = now.row + dx[i];
                int nCol = now.col + dy[i];
                
                if(nRow >= 0 && nRow < rowSize && nCol >= 0 && nCol < colSize && !visited[nRow][nCol] && maps[nRow][nCol] != 0){
                    q.add(new Node(nRow, nCol, now.time + 1));
                    visited[nRow][nCol] = true;
                }
            }
            
        }        
        return -1;
    }
}