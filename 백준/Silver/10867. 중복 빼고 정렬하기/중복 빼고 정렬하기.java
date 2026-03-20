
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int size = set.size();
        int[] arr = new int[size];
        int i = 0;
        for(int num : set){
            arr[i] = num;
            i++;
        }

        Arrays.sort(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}