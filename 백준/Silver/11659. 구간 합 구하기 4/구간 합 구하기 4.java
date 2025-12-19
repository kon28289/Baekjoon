import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] sum = new int[n];
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            if(i != 0){
                sum[i] = sum[i - 1] + tmp;
            }
            else{
                sum[i] = tmp;
            }

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if(start == 0){
                bw.write(sum[end] + "\n");
            }
            else{
                bw.write(sum[end] - sum[start - 1] + "\n");
            }
        }
        bw.flush();


    }
}