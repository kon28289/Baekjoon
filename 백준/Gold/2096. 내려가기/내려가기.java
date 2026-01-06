import java.io.*;
import java.util.*;

public final class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] maxPre = new int[3];
        int[] minPre = new int[3];

        // 첫 줄은 "한 줄에서 3개"를 읽어야 함
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            maxPre[i] = num;
            minPre[i] = num;
        }

        for (int i = 1; i < n; i++) {
            int[] maxCur = new int[3];
            int[] minCur = new int[3];

            st = new StringTokenizer(br.readLine());
            int leftCur = Integer.parseInt(st.nextToken());
            int midCur = Integer.parseInt(st.nextToken());
            int rightCur = Integer.parseInt(st.nextToken());

            maxCur[0] = Math.max(maxPre[0], maxPre[1]) + leftCur;
            maxCur[1] = Math.max(Math.max(maxPre[0], maxPre[1]), maxPre[2]) + midCur;
            maxCur[2] = Math.max(maxPre[1], maxPre[2]) + rightCur;

            minCur[0] = Math.min(minPre[0], minPre[1]) + leftCur;
            minCur[1] = Math.min(Math.min(minPre[0], minPre[1]), minPre[2]) + midCur; // 여기 수정
            minCur[2] = Math.min(minPre[1], minPre[2]) + rightCur;

            maxPre = maxCur;
            minPre = minCur;
        }

        int max = Math.max(Math.max(maxPre[0], maxPre[1]), maxPre[2]);
        int min = Math.min(Math.min(minPre[0], minPre[1]), minPre[2]);

        System.out.println(max + " " + min);
    }
}
