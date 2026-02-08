import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] difficult = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            difficult[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(difficult);

        st = new StringTokenizer(br.readLine());
        int[] player = new int[M];
        for (int i = 0; i < M; i++) {
            player[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int[] solved = new int[M];
        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N - 1;
            int mid = (left + right) / 2;
            while(left <= right){
                if(difficult[mid] <= player[i]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
                mid = (left + right) / 2;
            }
            solved[i] = left;

            left = 1;
            right = 400;
            mid = (left + right) / 2;
            while(left <= right){
                if(mid * mid * 3 - 3 * mid + 1 <= solved[i]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
                mid = (left + right) / 2;
            }
            sb.append(right).append(" ");
        }
        System.out.println(sb);



    }
}
