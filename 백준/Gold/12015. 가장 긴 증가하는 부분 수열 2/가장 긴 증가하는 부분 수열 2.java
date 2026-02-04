import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] tails = new int[N + 1];
        int length = 0;

        for (int i = 1; i < N + 1; i++) {
            int now = arr[i];

            int left = 1;
            int right = length;

            while(left <= right){
                int mid = (left + right) / 2;
                if(tails[mid] >= now){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            tails[left] = now;

            if(left > length)
                length = left;
        }
        System.out.println(length);

    }


}
