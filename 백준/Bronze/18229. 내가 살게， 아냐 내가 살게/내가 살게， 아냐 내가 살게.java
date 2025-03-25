import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                sum += tmp;
                if(sum >= K){
                    arr[i] = j;
                    break;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            if(arr[i] != 0){
                answer = Math.min(answer, arr[i]);
            }
        }

        for(int i = 0; i < N; i++) {
            if(arr[i] == answer){
                System.out.println(i + 1 + " " + arr[i]);
                return;
            }
        }

    }
}
