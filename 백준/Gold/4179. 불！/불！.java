import java.io.*;
import java.util.*;

public final class Main {

    static int R;
    static int C;
    static char[][] graph;
    static int startRow;
    static int startCol;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static class Node{
        int row;
        int col;
        int ans;

        Node(int row, int col, int ans){
            this.row = row;
            this. col = col;
            this.ans = ans;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        startRow = 0;
        startCol = 0;
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = s.charAt(j);
                if(graph[i][j] == 'J'){
                    startRow = i;
                    startCol = j;
                }
            }
        }

        solve();
    }

    private static void solve() {
        Queue<Node> players = new ArrayDeque<>();
        Queue<Node> fire = new ArrayDeque<>();

        players.add(new Node(startRow, startCol, 0));
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(graph[i][j] == 'F')
                    fire.add(new Node(i, j, 0));
            }
        }

        boolean[][] visited = new boolean[R][C];
        visited[startRow][startCol] = true;
        while(!players.isEmpty()){
            int size = fire.size();
            for (int j = 0; j < size; j++){
                Node f = fire.poll();
                for (int i = 0; i < 4; i++) {
                    int nextRow = f.row + dx[i];
                    int nextCol = f.col + dy[i];

                    if(nextRow >= 0 && nextRow < R && nextCol >= 0 && nextCol < C){
                        if(graph[nextRow][nextCol] == '.'){
                            fire.add(new Node(nextRow, nextCol, f.ans + 1));
                            graph[nextRow][nextCol] = 'F';
                        }
                    }
                }
            }

            int playerSize = players.size();
            Node player;
            for (int k = 0; k < playerSize; k++) {
                player = players.poll();

                if(player.row + 1 == R || player.col + 1 == C || player.row == 0 || player.col == 0){
                    System.out.println(player.ans + 1);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nextRow = player.row + dx[i];
                    int nextCol = player.col + dy[i];

                    if(nextRow >= 0 && nextRow < R && nextCol >= 0 && nextCol < C && !visited[nextRow][nextCol]){
                        if(graph[nextRow][nextCol] == '.'){
                            players.add(new Node(nextRow, nextCol, player.ans + 1));
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }

        }
        System.out.println("IMPOSSIBLE");
    }
}
