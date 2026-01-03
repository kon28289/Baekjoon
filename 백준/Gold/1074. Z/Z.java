import java.io.*;
import java.util.*;

public final class Main {

    static int r, c, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        solve(size, 0,0);
    }

    private static void solve(int size, int row, int col) {
        if(r == row && c == col){
            System.out.println(answer);
            return;
        }

        if(r < row + size && c < col + size && r >= row && c >= col){
            solve(size / 2, row, col);
            solve(size / 2, row, col + size / 2);
            solve(size / 2, row + size / 2, col);
            solve(size / 2, row + size / 2, col + size / 2);
        }
        else{
            answer += size * size;
        }

    }
}