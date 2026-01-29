import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int right = 0;
        int left = 0;
        int ans = 100001;
        int sum = 0;
        int count = 0;

        while(right < N || sum >= S){
            if(sum >= S){
                sum -= arr[left];
                left++;
                ans = Math.min(count, ans);
                count--;
            }
            else{
                sum += arr[right];
                right++;
                count++;
            }
        }

        if(ans == 100001){
            System.out.println(0);
            return;
        }
        System.out.println(ans);
    }

}
