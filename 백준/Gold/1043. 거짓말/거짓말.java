import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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
                if(rank[r1] == rank[r2]){
                    rank[r2]++;
                }
            }
        }
    }

    static int[] parent;
    static int[] rank;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for(int i = 0; i <= N; i++)
            parent[i] = i;
        rank = new int[N + 1];
        Arrays.fill(rank,0);

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        arr = new int[num];

        // 진실을 아는 애들을 배열에 입력
        for(int i = 0; i < num; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }
        Arrays.sort(arr);

        // 미리 입력받은 애들로 분리 집합을 만듦
        for(int i = 1; i < num; i++){
            rank[arr[0]]++;
            parent[arr[i]] = arr[0];
        }

        List<List<Integer>> party = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int[] p = new int[tmp];
            party.add(new ArrayList<>());

            for(int j = 0; j < tmp; j++){
                int n = Integer.parseInt(st.nextToken());
                p[j] = n;
                party.get(i).add(n);
            }

            Arrays.sort(p);

            if(num == 0)
                continue;

            int flag = 0;
            for(int n : p){
                // 진실을 아는 애가 있음
                if(find(n) == arr[0]){
                    for(int v : p)
                        merge(v,arr[0]);
                    flag = 1;
                }
            }
            // 진실을 모르는 애들끼리 분리 집합을 만듦
            if(flag == 0){
                int t = p[0];
                for(int j = 1; j < tmp; j++)
                    merge(p[j], t);
            }
        }

        int result = M;
        if(num == 0){
            System.out.println(result);
            return;
        }
        for(int i = 0; i < M; i++){
            for(int p : party.get(i)){
                if(find(p) == find(arr[0])){
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}

