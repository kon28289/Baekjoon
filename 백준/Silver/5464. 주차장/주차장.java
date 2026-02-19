import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] parkingLot = new int[N];
        int[] isParked = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            parkingLot[i] = Integer.parseInt(st.nextToken());
        }

        int[] cars = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cars[i] = Integer.parseInt(st.nextToken());
        }

        int[] inAndOut = new int[2 * M];
        for (int i = 0; i < 2 * M; i++) {
            st = new StringTokenizer(br.readLine());
            inAndOut[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new ArrayDeque<>();

        int ans = 0;
        int leftParkingLot = N;
        for (int i = 0; i < 2 * M; i++) {
            int car = inAndOut[i];
            if(car > 0){
                while(!q.isEmpty() && leftParkingLot > 0){
                    int nextCar = q.poll();
                    int whereToPark = -1;
                    for (int j = 0; j < N; j++) {
                        if(isParked[j] == 0){
                            whereToPark = j;
                            leftParkingLot -= 1;
                            break;
                        }
                    }
                    isParked[whereToPark] = nextCar;
                    ans = ans + cars[nextCar - 1] * parkingLot[whereToPark];
                }

                if(leftParkingLot == 0){
                    q.add(car);
                    continue;
                }
                int whereToPark = -1;
                for (int j = 0; j < N; j++) {
                    if(isParked[j] == 0){
                        whereToPark = j;
                        leftParkingLot -= 1;
                        break;
                    }
                }
                isParked[whereToPark] = car;
                ans = ans + cars[car - 1] * parkingLot[whereToPark];

            }
            else{

                while(!q.isEmpty() && leftParkingLot > 0){
                    int nextCar = q.poll();
                    int whereToPark = -1;
                    for (int j = 0; j < N; j++) {
                        if(isParked[j] == 0){
                            whereToPark = j;
                            leftParkingLot -= 1;
                            break;
                        }
                    }
                    isParked[whereToPark] = nextCar;
                    ans = ans + cars[nextCar - 1] * parkingLot[whereToPark];
                }

                int outCar = car * -1;
                for (int j = 0; j < N; j++) {
                    if(outCar == isParked[j]){
                        isParked[j] = 0;
                        leftParkingLot += 1;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);

    }


}
