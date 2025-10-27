import java.io.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());
        long now = 0;
        for (int i =1;;++i) {
            now += i;
            if(now > num) {
                System.out.println(i-1);
                break;
            }
        }

    }
}