import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int x;
        int y;
        int v;
        int p;

        Node(int x, int y, int v, int p){
            this.x = x;
            this.y = y;
            this.v = v;
            this.p = p;
        }
    }

    static int find(int n){
        if(parent[n] == n){
            return n;
        }

        return parent[n] = find(parent[n]);
    }

    static void merge(int n1, int n2){
        int r1 = find(n1);
        int r2 = find(n2);

        if(r1 != r2){
            if(rank[r1] > rank[r2]){
                parent[r2] = r1;
            }
            else{
                parent[r1] = r2;
                if(rank[r1] == rank[r2])
                    rank[r2]++;
            }
        }
    }

    static int[] parent;
    static int[] rank;
    static Node[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++)
            parent[i] = i;
        rank = new int[N + 1];
        Arrays.fill(rank, 0);
        pos = new Node[N + 1];

        st = new StringTokenizer(br.readLine());

        int cX = Integer.parseInt(st.nextToken());
        int cY = Integer.parseInt(st.nextToken());
        int cV = Integer.parseInt(st.nextToken());
        pos[0] = new Node(cX, cY, cV, 0);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            Node node = new Node(x, y, v, p);
            pos[i] = node;
        }

        for (int i = 0; i < pos.length; i++) {
            Node node1 = pos[i];
            for (int j = i; j < pos.length; j++) {
                Node node2 = pos[j];
                double dist = Math.sqrt((node1.x - node2.x) * (node1.x - node2.x) + (node1.y - node2.y) * (node1.y - node2.y));
                dist = Math.ceil(dist);
                if (dist <= K && Math.abs(node1.v - node2.v) <= T) {
                    merge(j, i);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if (find(parent[i]) == find(parent[0]) && pos[i].p == 1){
                sb.append(i + " ");
            }
        }
        if(sb.length() == 0){
            System.out.println(0);
            return;
        }
        System.out.println(sb);


    }
}

