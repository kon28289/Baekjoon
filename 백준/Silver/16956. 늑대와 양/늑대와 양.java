import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void printGraph(char[][] graph, int R, int C) {
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int R, C;
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] graph = new char[R + 1][C + 1];
        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            for(int j = 0; j < C; j++) {
                char tmp = a.charAt(j);
                graph[i][j+1] = tmp;
            }
        }

        int[] deltaRow = {0, 0, -1, 1}; // 상하좌우
        int[] deltaColumn = {-1, 1, 0, 0}; // 상하좌우
        int count = 0;
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(graph[i][j] == 'W') {
                    for(int k = 0; k < 4; k++) {
                        int dRow = i + deltaRow[k];
                        int dColumn = j + deltaColumn[k];
                        if(dRow < 0 || dRow > R || dColumn < 0 || dColumn > C) {
                            continue;
                        }
                        if(graph[dRow][dColumn] == 'W' || graph[dRow][dColumn] == 'S') {
                            if(graph[dRow][dColumn] == 'S') {
                                System.out.println(0);
                                return;
                            }
                            continue;
                        }
                        graph[dRow][dColumn] = 'D';

                    }
                }
            }
        }
        System.out.println(1);
        printGraph(graph, R, C);


    }
}
