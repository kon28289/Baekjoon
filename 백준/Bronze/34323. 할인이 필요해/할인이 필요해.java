import java.io.*;
import java.util.StringTokenizer;

public final class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n, m, s;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        s = Long.parseLong(st.nextToken());

        System.out.println(Math.min(s * (m+1) * (100-n) / 100, s * m));
    }
}