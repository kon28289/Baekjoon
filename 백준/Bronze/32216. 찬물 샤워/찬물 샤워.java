import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k, t0;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        t0 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int T = t0;
        int anw = 0;
        for(int i = 0; i < n; i++){
            if(T > k){
                T += arr[i] - Math.abs(T - k);
            }
            else if(T < k){
                T += arr[i] + Math.abs(T - k);
            }
            else{
                T += arr[i];
            }
            anw += Math.abs(T - k);
        }

        System.out.println(anw);
    }
}
