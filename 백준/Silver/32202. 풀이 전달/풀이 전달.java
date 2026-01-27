import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int mod = 1000000007;

        int[] dpA = new int[N + 1];
        int[] dpB = new int[N + 1];

        dpA[1] = 1;
        dpB[1] = 2;

        int ans = 3;
        for (int i = 2; i < N + 1; i++) {
            dpA[i] = dpB[i - 1] % mod;
            dpB[i] = (((dpA[i - 1] + dpB[i - 1])) % mod * 2) % mod;
            ans = (dpA[i] + dpB[i]) % mod;
        }
        System.out.println(ans);
    }
}
