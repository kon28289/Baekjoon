import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr);

        int ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            if(i == 0){
                ans += arr[i];
                break;
            }
            int n1 = arr[i];
            int n2 = arr[i - 1];

            int initialSum = n1 + n2;
            int multipliedSum = n1 * n2;
            if(n1 >= 0 && n2 >= 0){
                if(n1 == 0 || n2 == 0){
                    ans += initialSum;
                    continue;
                }
                if(initialSum < multipliedSum){
                    ans += multipliedSum;
                    i--;
                }
                else{
                    ans += n1;
                }
            }
            else if(n1 >= 0 && n2 < 0){
                if(n1 == 0){
                    if(i % 2 == 0){
                        ans += n1;
                        continue;
                    }
                    ans += multipliedSum;
                    i--;
                    continue;
                }
                ans += n1;
            }
            else if(n1 < 0 && n2 < 0){
                if(i % 2 == 0){
                    ans += n1;
                    continue;
                }
                ans += multipliedSum;
                i--;
            }
        }
        System.out.println(ans);
    }
}
