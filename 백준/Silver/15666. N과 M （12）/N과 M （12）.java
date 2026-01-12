import java.io.*;
import java.util.*;

public final class Main {

    static List<Integer> arr;
    static List<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(!arr.contains(tmp))
                arr.add(tmp);
        }
        arr.sort((a1, a2) -> a1 - a2);
        result = new ArrayList<>();

        solve(n, m, 0);

    }

    private static void solve(int n, int m, int recur) {
        if(recur == m){
            for(int num : result){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if(recur != 0 && !result.isEmpty()){
                if(result.get(result.size() - 1) <= arr.get(i))
                    result.add(arr.get(i));
                else{
                    continue;
                }
            }
            else {
                result.add(arr.get(i));
            }
            solve(n, m, recur + 1);
            result.remove(result.size() - 1);
        }
    }
}
