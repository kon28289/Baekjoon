import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(solve(a, b, c));
    }

    private static long solve(int a, int b, int c) {
        if(b == 1){
            return a % c;
        }

        int nB1 = b / 2;
        long n = solve(a, nB1, c);
        if(b % 2 == 1){
            return ((n * n) % c) * a % c;
        }
        return (n * n) % c;
    }
}
