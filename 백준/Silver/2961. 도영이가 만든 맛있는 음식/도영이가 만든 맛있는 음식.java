import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class tasty{
        public int a;
        public int b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        List<tasty> list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            tasty t = new tasty();
            t.a = Integer.parseInt(st.nextToken());
            t.b = Integer.parseInt(st.nextToken());
            list.add(t);
        }

        
        int result = Integer.MAX_VALUE;
        for (int mask = 1; mask < (1 << m); mask++){
            // 전체 집합 하나하나를 확인
            int ans1 = 1;
            int ans2 = 0;
            for(int j = 0; j < m; j++){
                if((mask & (1 << j)) != 0){
                    ans1 *= list.get(j).a;
                    ans2 += list.get(j).b;
                }
            }
            result = Integer.min(result, Math.abs(ans1-ans2));
        }
        System.out.println(result);
    }
}
