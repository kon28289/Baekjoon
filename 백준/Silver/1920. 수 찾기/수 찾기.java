import java.io.*;
import java.util.*;

public final class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            solve(Integer.parseInt(st.nextToken()));
        }

    }

    private static void solve(int value) {
        int start = 0;
        int end = N - 1;
        int mid = (start + end) / 2;

        while(start <= end){
            if(value < arr[mid]){
                end = mid - 1;
                mid = (start + end) / 2;
            }
            else if(value > arr[mid]){
                start = mid + 1;
                mid = (start + end) / 2;
            }
            else{
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

}
