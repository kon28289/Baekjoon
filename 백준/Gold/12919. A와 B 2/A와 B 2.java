
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String T;
    static String S;
    static int flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        solve(T);
        System.out.println(flag);
    }

    private static void solve(String now){
        if(flag == 1) return;

        if(now.length() < S.length()){
            return;
        }

        if(now.equals(S)){
            flag = 1;
            return;
        }

        if(now.charAt(now.length() - 1) == 'A'){
            String newString = now.substring(0, now.length() - 1);
            solve(newString);
        }

        if(now.charAt(0) == 'B'){
            String newString = new StringBuilder(now.substring(1)).reverse().toString();
            solve(newString);
        }
    }
}