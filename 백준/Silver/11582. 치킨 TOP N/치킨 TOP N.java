import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static int[] arr;
    static int k;
    static int blockSize;
    static int[] buffer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        buffer = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        k = Integer.parseInt(br.readLine());
        blockSize = N / k;

        solve(0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void solve(int start, int end){
        if(start >= end)
            return;

        int mid = (start + end) / 2;
        solve(start, mid);
        solve(mid + 1, end);

        int size = end - start + 1;

        if(size <= blockSize)
            merge(start, mid, end);
    }

    private static void merge(int start, int mid, int end){
        int leftIdx = start;
        int rightIdx = mid + 1;
        int currentIdx = start;

        while(leftIdx <= mid && rightIdx <= end){
            if(arr[leftIdx] <= arr[rightIdx]){
                buffer[currentIdx] = arr[leftIdx];
                leftIdx++;
            }
            else{
                buffer[currentIdx] = arr[rightIdx];
                rightIdx++;
            }
            currentIdx++;
        }

        while(leftIdx <= mid){
            buffer[currentIdx] = arr[leftIdx];
            leftIdx++;
            currentIdx++;
        }

        while(rightIdx <= end){
            buffer[currentIdx] = arr[rightIdx];
            rightIdx++;
            currentIdx++;
        }

        for(int i = start; i <= end; i++){
            arr[i] = buffer[i];
        }
    }
}