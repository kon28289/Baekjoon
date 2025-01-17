import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, L, R, X;
        int count = 0;
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int[] p = new int[N];


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }


        for(int mask = 1; mask < (1 << N); mask++){
            long sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < N; i++){
                if((mask & (1 << i)) != 0){
                    sum += p[i];
                    min = Math.min(min, p[i]);
                    max = Math.max(max, p[i]);
                }
            }

            if((max-min)>=X && sum>=L && sum<=R){
                count++;
            }
        }

        System.out.println(count);
    }

}

