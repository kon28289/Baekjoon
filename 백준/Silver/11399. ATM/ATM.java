import java.io.*;
import java.util.*;

public final class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }

        Arrays.sort(arr);
        int result = 0;
        for(int i = 0; i < n; i++){
            result += arr[i];
            for(int j = 0; j < i; j++){
                result += arr[j];
            }
        }
        System.out.println(result);
    }
}