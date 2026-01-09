import java.io.*;
import java.util.*;

public final class Main {
    static char[][] arr = new char[27][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = st.nextToken().charAt(0) - 'A';
            char c2 = st.nextToken().charAt(0) ;
            char c3 = st.nextToken().charAt(0) ;
            arr[c1][0] = c2;
            arr[c1][1] = c3;
            arr[c1][2] = '.';
        }
        for (int i =0; i<3;++i){
            dfs('A',i);
            System.out.println();
        }
    }
    static void dfs(char node, int rule){
        for (int i = 0; i < 3;++i) {
            if(i == rule){
                System.out.print(node);
            }
            if (arr[node-'A'][i] == '.'){
                continue;
            }
            dfs(arr[node-'A'][i],rule);
        }
    }

}
