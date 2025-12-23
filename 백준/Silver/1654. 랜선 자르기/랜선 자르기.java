import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long start = 1;
        long end = 0;
        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            end = Math.max(end, tmp);
        }

        long answer = 0;
        long pivot;
        while(end >= start) {
            int sum = 0;
            pivot = (end + start) / 2;
            for (int i = 0; i < k; i++) {
                sum += arr[i] / pivot;
            }
            if (sum >= n) {
                answer = pivot;
                start = pivot + 1;

            } else {
                end = pivot - 1;
            }
        }
        System.out.println(answer);

    }
}