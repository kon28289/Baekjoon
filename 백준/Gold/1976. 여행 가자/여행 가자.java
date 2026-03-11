import java.io.*;
import java.util.*;

public class Main{

    static int[] root;
    static int[] child;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        root = new int[N + 1];
        child = new int[N + 1];
        for(int i = 1; i <= N; i++){
            root[i] = i;
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1){
                    merge(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= M; i++){
            set.add(find(Integer.parseInt(st.nextToken())));
        }

        if(set.size() == 1){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }

    private static void merge(int n1, int n2){
        if(n1 == n2){
            return;
        }

        int root1 = find(n1);
        int root2 = find(n2);

        if(root1 != root2){
            if(child[root1] > child[root2]){
                root[root2] = root1;
                child[root1] += child[root2];
            }
            else{
                root[root1] = root2;
                child[root2] += child[root1];
            }
        }
    }

    private static int find(int n){
        if(root[n] == n){
            return n;
        }
        return find(root[n]);
    }
}