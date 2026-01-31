import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int player;
        int power;
        long heart;

        Node(int player, int power, int heart){
            this.player = player;
            this.power = power;
            this.heart = heart;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] power = new int[N];
        for (int i = 0; i < N; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] heart = new int[N];
        for (int i = 0; i < N; i++) {
            heart[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            q.add(new Node(i, power[i], heart[i]));
        }

        int damage = 0;
        long[] damaged = new long[N];
        long[] self = new long[N];
        while(!q.isEmpty()){
            Node n = q.poll();
            if(q.isEmpty()){
                System.out.println(n.player + 1);
                return;
            }

            long total = damage - self[n.player];
            n.heart -= total - damaged[n.player];
            damaged[n.player] = total;

            if(n.heart <= 0){
                continue;
            }

            damage += n.power;
            self[n.player] += n.power;
            q.add(n);
        }

    }

}
