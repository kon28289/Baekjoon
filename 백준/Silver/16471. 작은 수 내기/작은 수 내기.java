
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] me = new int[N + 1];
        int[] you = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            me[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            you[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(me);
        Arrays.sort(you);

        int count = 0;
        int youIdx = N;
        for(int i = N; i > 0; i--){
            if(me[i] < you[youIdx]){
                youIdx--;
                count++;
            }
        }

        if(count >= (N + 1) / 2){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}