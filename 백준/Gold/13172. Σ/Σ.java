import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static long MOD = 1000000007;
    static long power(int tmp){
        long res = 1;
        long base = tmp;
        long exp = MOD - 2;
        while(exp > 0){
            if(exp % 2 == 1){
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res % MOD;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        long result = 0;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if(s % n != 0){
                // 모듈러 연산 수
                // 모듈러 역원을 구해야 함
                // (s mod MOD * n^-1 mod MOD )mod MOD
                // == (s mod MOD * ((n ^ MOD-2) mod MOD mod MOD)) mod MOD
                long inverse = power(n) % MOD;
                long pivot = (s % MOD * inverse) % MOD;
                result = (result + pivot) % MOD;
                continue;
            }
            result = (result + (s / n) % MOD) % MOD;
        }
        System.out.println(result);
    }

}

