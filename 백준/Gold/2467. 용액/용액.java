import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int front = 0;
        int back = N - 1;

        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        while(front < back){
            int sum = arr[front] + arr[back];
            int absSum = Math.abs(sum);

            if(absSum < result){
                result = absSum;
                left = front;
                right = back;
                if(absSum == 0)
                    break;
            }

            if(sum < 0)
                front++;
            else
                back--;
        }

        System.out.println(arr[left] + " " + arr[right]);
    }
}
