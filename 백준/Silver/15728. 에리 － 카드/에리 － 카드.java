import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] shared = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            shared[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(shared);

        int[] max = new int[N];
        int maxValue = shared[N - 1];
        int minValue = shared[0];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int tmp1 = minValue * num;
            int tmp2 = maxValue * num;
            max[i] = Math.max(tmp1, tmp2);
        }
        Arrays.sort(max);
        System.out.println(max[N - K - 1]);

    }
}
