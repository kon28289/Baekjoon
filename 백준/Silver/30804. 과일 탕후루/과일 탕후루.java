import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] counts = new int[10];
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }

        int left = 0;
        int streak = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            if (counts[arr[i]] == 0)
                streak++;
            counts[arr[i]]++;

            if(streak > 2){
                counts[arr[left]]--;
                if(counts[arr[left]] == 0){
                    streak--;
                }
                left++;
            }

            answer = Math.max(answer, i - left + 1);
        }
        System.out.println(answer);

    }
}