import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sumA = 0;
        int sumB = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j = 0; j < n; j++){
            int tmp = Integer.parseInt(st.nextToken());
            sumA += tmp;
        }

        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < n; j++){
            int tmp = Integer.parseInt(st.nextToken());
            sumB += tmp;
        }

        System.out.println(sumB + " " + sumA);

    }
}
