import java.io.*;
import java.util.StringTokenizer;

public final class Main {
    public static boolean solve(String tmp){
        boolean isPalindrome = false;

        for(int i = 2; i < 65 && !isPalindrome; i++){
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(tmp);

            while(num > 0){
                int r = num % i;
                num /= i;

                if(r == 0){
                    sb.insert(0, 0);
                    continue;
                }
                // 알파벳 처리
                if(r >= 10){
                    sb.insert(0, (char)(r + 55));
                    continue;
                }
                sb.insert(0, r);
            }

            // 회문 체크
            int length = sb.length() / 2;
            String origin = sb.toString();
            String reverse = sb.reverse().toString();

            int k = 0;
            for (k = 0; k <= length; k++) {
                if (origin.charAt(k) != reverse.charAt(k)) {
                    break;
                }
            }
            if (k == length + 1) {
                isPalindrome = true;
            }
        }

        return isPalindrome;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();

            // 회문 검사
            if(solve(tmp)){
                sb.append("1").append("\n");
                continue;
            }
            sb.append("0").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}