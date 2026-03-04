import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static int[][] arr;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());


        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
           for(int j = 0; j < N; j++){
               int tmp = Integer.parseInt(st.nextToken());
               arr[i][j] = tmp;
           }
        }

        System.out.println(solve(N, 0, 0));
    }

    private static int solve(int size, int row, int col){
        if(size == 2){
            // 로직 수행하기
            int[] a = new int[4];
            a[0] = arr[row][col];
            a[1] = arr[row][col + 1];
            a[2] = arr[row + 1][col];
            a[3] = arr[row + 1][col + 1];
            Arrays.sort(a);
            return a[2];
        }

        int half = size / 2;
        int[] ans = new int[4];
        ans[0] = solve(half, row, col);
        ans[1] = solve(half, row, col + half);
        ans[2] = solve(half, row + half, col);
        ans[3] = solve(half, row + half, col + half);

        Arrays.sort(ans);
        return ans[2];
    }

}