import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        int front = 0;
        int back = n - 1;

        int ans  = 0;
        while(front < back){
            int sum = arr[front] + arr[back];

            if(sum == x){
                front++;
                back--;
                ans++;
            }
            else if(sum > x){
                back--;
            }
            else{
                front++;
            }
        }
        System.out.println(ans);
    }


}
