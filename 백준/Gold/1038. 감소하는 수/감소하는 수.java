import java.io.*;
import java.util.*;

public final class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());

        list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 10; j++) {
                solve(1, i, j);
            }
        }

        Collections.sort(list);
        if(N >= list.size()){
            System.out.println(-1);
            return;
        }
        System.out.println(list.get((int) N));
    }

    static List<Long> list;

    private static void solve(int recur, int end, long now) {
        if(recur == end){
            list.add(now);
            return;
        }
        int pre = (int) now % 10;
        for (int pick = pre - 1; pick >= 0; pick--) {
            long nxt = now * 10 + pick;
            if(nxt == now){
                continue;
            }
            solve(recur + 1, end, nxt);
        }
    }


}
