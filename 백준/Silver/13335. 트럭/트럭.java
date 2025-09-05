import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public final class Main {

    public static int solve(int n, int w, int l, Queue<Integer> trucks) {
        Deque<Integer> bridge = new ArrayDeque<>();

        // 다리 길이만큼 다리 덱을 0으로 채운다.
        for (int i = 0; i < w; ++i) {
            bridge.offer(0);
        }

        // 시뮬레이션
        int time = 0;
        int bridgeWeight = 0;
        while (!bridge.isEmpty()) {
            ++time;
            bridgeWeight -= bridge.poll();

            if (!trucks.isEmpty()) {
                int truckWeight = trucks.peek();
                if (bridgeWeight + truckWeight <= l) {
                    bridgeWeight += truckWeight;
                    bridge.offer(trucks.poll());
                } else {
                    bridge.offer(0);
                }
            }
        }

        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Integer> trucks = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        bw.write(solve(n, w, l, trucks) + "\n");
        bw.flush();
    }
}