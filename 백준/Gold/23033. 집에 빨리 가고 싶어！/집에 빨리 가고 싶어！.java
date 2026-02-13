import java.io.*;
import java.util.*;

public final class Main {

    static int N;
    static ArrayList<Node>[] list;

    static class Node{
        int next;
        int time;
        int interval;

        Node(int next, int time, int interval){
            this.next = next;
            this.time = time;
            this.interval = interval;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            list[A].add(new Node(B, T, W));
        }

        Queue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.time));

        int[] times = new int[N + 1];

        int start;
        q.add(new Node(1, 0, 0));
        Arrays.fill(times, Integer.MAX_VALUE);
        times[1] = 0;
        while(!q.isEmpty()){
            Node n = q.poll();
            start = n.next;
            for (Node node : list[start]){
                int time = n.time;
                if(time % node.interval != 0){
                    time += node.interval - time % node.interval;
                }
                if(time + node.time < times[node.next]){
                    time += node.time;
                    times[node.next] = time;
                    q.add(new Node(node.next, time, 0));
                }
            }
        }
        System.out.println(times[N]);

    }
}
