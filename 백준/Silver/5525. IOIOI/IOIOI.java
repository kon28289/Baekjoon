import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        if(N >= 500000){
            System.out.println(0);
            return;
        }

        int ans = 0;
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I'){
                count++;
                i += 1;
            }
            else{
                count = 0;
            }

            if(count >= N){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
