import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1-2번 역량, 2-3번 역량, 1-3번 역량을 선택할 수 있음
        // 선택할 수 있는 역량들의 합을 구해서 저장함
        // 배열 3개를 만들어서 각각 저장하고 내림차순 정렬 후 앞에서부터 수강하기로 한 강의 개수만큼 더함

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] oneTwo = new int[N];
        int[] twoThree = new int[N];
        int[] oneThree = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());

            oneTwo[i] = one + two;
            twoThree[i] = two + three;
            oneThree[i] = one + three;
        }

        Arrays.sort(oneTwo);
        Arrays.sort(twoThree);
        Arrays.sort(oneThree);

        // 각 배열에서 K개씩 선택해서 더한 값을 비교해서 가장 큰 값을 출력
        int sumOneTwo = 0;
        int sumTwoThree = 0;
        int sumOneThree = 0;
        int index = N - 1;
        for (int i = 0; i < K; i++) {
            sumOneTwo += oneTwo[index];
            sumTwoThree += twoThree[index];
            sumOneThree += oneThree[index];
            index--;
        }

        int ans = 0;
        ans = Math.max(ans, sumOneTwo);
        ans = Math.max(ans, sumTwoThree);
        ans = Math.max(ans, sumOneThree);

        System.out.println(ans);

    }



}
