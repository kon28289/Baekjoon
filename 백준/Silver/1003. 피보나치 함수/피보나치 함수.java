import java.io.*;
import java.util.*;

public final class Main {

    static void solve(int n){
        int[] count0 = new int[n + 1];
        int[] count1 = new int[n + 1];
        count0[0] = 1;
        count1[0] = 0;
        count0[1] = 0;
        count1[1] = 1;

        for(int i = 2; i < n + 1; i++){
            count0[i] = count0[i-1] + count0[i-2];
            count1[i] = count1[i-1] + count1[i-2];
        }

        System.out.println(count0[n] + " " + count1[n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == 0){
                System.out.println(1 + " " + 0);
                continue;
            }
            else if(tmp == 1){
                System.out.println(0 + " " + 1);
                continue;
            }
            solve(tmp);
        }

    }
}