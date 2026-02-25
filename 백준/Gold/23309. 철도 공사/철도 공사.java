import java.io.*;
import java.util.*;

public class Main {

    static int[] pre;
    static int[] next;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        pre = new int[2000001];
        next = new int[2000001];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 0; i < N; i++) {
            if(i == 0){
                pre[arr[i]] = arr[N - 1];
                next[arr[i]] = arr[i + 1];
            }
            else if(i == N - 1){
                pre[arr[i]] = arr[i - 1];
                next[arr[i]] = arr[0];
            }
            else{
                pre[arr[i]] = arr[i - 1];
                next[arr[i]] = arr[i + 1];
            }
        }

        sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();
            int now = 0;
            int newStation = -1;
            if(action.equals("BN") || action.equals("BP")){
                now = Integer.parseInt(st.nextToken());
                newStation = Integer.parseInt(st.nextToken());
            }
            else{
                now = Integer.parseInt(st.nextToken());
            }

            solve(action, now, newStation);
        }
        System.out.println(sb);
    }

    private static void solve(String action, int now, int newStation){
        if(action.equals("BN")){
            int oldNext = next[now];
            sb.append(oldNext).append("\n");

            next[now] = newStation;
            next[newStation] = oldNext;
            pre[oldNext] = newStation;
            pre[newStation] = now;

        }
        else if(action.equals("BP")){
            int oldPre = pre[now];
            sb.append(oldPre).append("\n");

            pre[now] = newStation;
            pre[newStation] = oldPre;
            next[oldPre] = newStation;
            next[newStation] = now;
        }
        else if(action.equals("CN")){
            int oldNext = next[now];
            sb.append(oldNext).append("\n");

            next[now] = next[oldNext];
            next[oldNext] = 0;
            pre[next[now]] = now;
            pre[oldNext] = 0;
        }
        else{
            int oldPre = pre[now];
            sb.append(oldPre).append("\n");

            pre[now] = pre[oldPre];
            pre[oldPre] = 0;
            next[pre[now]] = now;
            next[oldPre] = 0;
        }
    }

}
