import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int row;
        int col;

        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] graph = new char[n][m];
        int sRow = 0,sCol = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < m; j++){
                char tmp = s.charAt(j);
                if(tmp == 'I'){
                    sRow = i;
                    sCol = j;
                }
                graph[i][j] = tmp;
            }
        }

        Queue<Node> que = new ArrayDeque<>();
        Node start = new Node(sRow, sCol);
        que.add(start);
        boolean[][] visited = new boolean[n][m];
        visited[sRow][sCol] = true;

        int[] mRow = {1, 0, -1, 0};
        int[] mCol = {0, 1, 0, -1};
        int answer = 0;
        while(!que.isEmpty()){
            Node node = que.poll();
            int row = node.row;
            int col = node.col;
            visited[row][col] = true;
            if(graph[row][col] == 'P')
                answer++;

            for(int i = 0; i < 4; i++){
                int nRow = row + mRow[i];
                int nCol = col + mCol[i];
                if(nRow < n && nCol < m && nRow >=0 && nCol >= 0 && !visited[nRow][nCol] && graph[nRow][nCol] != 'X'){
                    que.add(new Node(nRow, nCol));
                    visited[nRow][nCol] = true;
                }
            }
        }

        if(answer == 0){
            System.out.println("TT");
            return;
        }
        System.out.println(answer);


    }
}