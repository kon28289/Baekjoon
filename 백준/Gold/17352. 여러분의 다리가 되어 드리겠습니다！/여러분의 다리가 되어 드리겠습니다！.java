import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int find(int n){ // 루트를 탐색
        if(parent[n] == n){
            return parent[n];
        }

        return parent[n] = find(parent[n]);
    }

    static void merge(int r1, int r2){
        int n1 = find(r1);
        int n2 = find(r2);
        if(find(n1) != find(n2)){
            // 루트가 다르면 합치기
            if(rank[n1] > rank[n2]){
                // 랭크가 더 큰 쪽으로 합치기
                parent[n2] = n1;
            }
            else{
                parent[n1] = n2;
                if(rank[n1] == rank[n2])
                    rank[n2]++;
            }
        }
    }

    static class edge{
        public int start;
        public int end;
    }

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        rank = new int[N];
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }
        Arrays.fill(rank, 0);

        List<edge> edges = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < N - 2; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge edge = new edge();
            edge.start = a;
            edge.end = b;
            edges.add(edge);
        }

        for(int i = 0; i < N - 2; i++){
            merge(edges.get(i).start - 1, edges.get(i).end - 1);
        }

        for(int i = 0; i < N; i++){
            // 간선을 토대로 분리집합을 만들자
            parent[i] = find(i);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int n : parent){
            set.add(n);
        }

        for(int n : set){
            System.out.print((n+1) + " ");
        }
    }

}

