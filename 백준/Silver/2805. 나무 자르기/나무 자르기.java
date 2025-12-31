import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        int start = 0;
        int end = max;
        int mid;

        int answer = 0;
        while(start <= end){
            mid = (start + end) / 2;

            long sum = 0;
            for(int i = 0; i < n; i++){
                if(trees[i] > mid)
                    sum += trees[i] - mid;
            }
            if(sum >= m){
                answer = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        System.out.println(answer);

    }
}