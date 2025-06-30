import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int coinCount;
        int price;

        Node(int coinCount, int price){
            this.coinCount = coinCount;
            this.price = price;
        }
    }

    static int bfs(int[] arr, int m){
        LinkedList<Node> queue = new LinkedList<>();
        // 0까지 포함하는 배열
        boolean[] visitedPlus = new boolean[20001];
        boolean[] visitedMinus = new boolean[20001];

        queue.add(new Node(0,0));
        visitedPlus[0] = true;

        while(!queue.isEmpty()){
            Node coin = queue.getFirst();
            queue.remove(0);

            // 정답 반환
            if(coin.price == m)
                return coin.coinCount;

            for(int i = 0; i < arr.length; i++){
                // 구하려는 범위를 넘어서면 스킵
                if(Math.abs(arr[i] + coin.price) > 20000)
                    continue;

                int newPrice = coin.price + arr[i];
                // 범위에 맞으면 큐에 넣기
                if(newPrice >= 0 && !visitedPlus[newPrice]){
                    visitedPlus[newPrice] = true;
                    queue.add(new Node(coin.coinCount+1, newPrice));
                }
                else if(newPrice < 0){
                    newPrice = -newPrice;
                    if(!visitedMinus[newPrice - 1]){
                        visitedMinus[newPrice - 1] = true;
                        queue.add(new Node(coin.coinCount+1, newPrice * -1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(m == 0){
            System.out.println(0);
            return;
        }
        if(n == 0){
            System.out.println(-1);
            return;
        }
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(arr, m));


    }
}