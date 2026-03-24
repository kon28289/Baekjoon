import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(solve(N - 2));
        }



    }

    private static long solve(int N) {
        if(N == 0){
            return 1;
        }

        long half = solve(N / 2);
        long returned = (half * half) % 1000000007;

        if(N % 2 == 1){
            returned = (returned * 2) % 1000000007;
        }

        return returned;
    }


}