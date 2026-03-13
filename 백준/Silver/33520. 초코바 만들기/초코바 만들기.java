import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long[] arr1 = new long[N];
        long[] arr2 = new long[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr1[i] = Math.min(a,b);
            arr2[i] = Math.max(a,b);
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println((long) arr1[N - 1] * arr2[N - 1]);

    }

}