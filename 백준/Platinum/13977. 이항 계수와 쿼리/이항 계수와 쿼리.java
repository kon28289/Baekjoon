import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static long MOD = 1000000007;
    static long result = 1L;
    static long[] num = new long[4000001];
    static long power(long n){
        // n의 MOD-2승을 구해야함
        // 1001 <- 얘를 나눠 1001/2 == 500.5인데 반올림 하면 501, 500으로 나눠짐
        // 250, 251, 250, 250
        // 125, 125, 125, 126, 125, 125
        // 62, 63, 62, 63, 62, 63, 63, 63, 62, 63, 62, 63
        // 31, 31, 31, 32, 31, 31, 31, 32,...
        // 15, 16, 15, 16, 16, 16,...
        // 7, 8, 8, 8, 7, 8, 8,...
        // 3, 4, 4, 4, 4, 4,...
        //
        long res = 1;
        long exp = MOD - 2;
        while (exp > 0){
            if(exp % 2 == 1){
                // 홀수일 때는 먼저 곱해줌
                res = (res *n) % MOD;
            }
            exp /= 2;
            n = (n*n)%MOD;
        }
        return res % MOD;
    }

    static void fact(long n){
        for(long i = 1; i <= n; i++){
            num[(int) i] = num[(int) (i - 1)] * i % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long m = Integer.parseInt(br.readLine());

        Arrays.fill(num, 1L);

        // n!을 구해서 mod연산을 해줌
        // n! % MOD
        fact(4000000);

        long n, k;
        for(int i = 0; i < m; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // (n-k)! ^ -1을 구해서 mod연산을 해줌
            // (n-k)! ^ -1 == (n-k)! ^ (MOD - 2) % MOD
            // (n-k)! ^ -1 % MOD == ((n-k)! ^ (MOD - 2) % MOD) % MOD
            // (n-k)!은 이미 구함, (n-k)! ^ (MOD - 2)의 값을 구해야함
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            long h = power(num[(int) (n-k)]) % MOD;
            long j = power(num[(int) k]) % MOD;
            long pivot = h * j % MOD;
            long ans = num[(int) n] * pivot % MOD;
            System.out.println(ans);
        }
        
    }

}

