import java.io.*;
import java.util.*;

public final class Main {

    static class Match{
        int team1;
        int team2;

        Match(int team1, int team2){
            this.team1 = team1;
            this.team2 = team2;
        }
    }

    static int[] result;
    static List<Match> matches;
    static int[] freq;
    static int ans;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        matches = new ArrayList<>();
        freq = new int[M + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int team1 = Integer.parseInt(st.nextToken());
            int team2 = Integer.parseInt(st.nextToken());
            int win = Integer.parseInt(st.nextToken());

            if(win == 0) {
                matches.add(new Match(team1, team2));
            }
            else if(win == 1) {
                result[team1] += 1;
            }
            else {
                result[team2] += 1;
            }
        }

        ans = 0;
        max = -1;
        for (int i = 1; i < result.length; i++) {
            freq[result[i]]++;
            if(result[i] > max) {
                max = result[i];
            }
        }

        solve(0, matches.size(), K);
        System.out.println(ans);
    }

    private static void solve(int recur, int end, int K) {
        if(recur == end){
            if(result[K] == max && freq[max] == 1)
                ans++;
            return;
        }

        Match match = matches.get(recur);

        addWin(match.team1);
        solve(recur + 1, end, K);
        removeWin(match.team1);

        addWin(match.team2);
        solve(recur + 1, end, K);
        removeWin(match.team2);

    }

    static void addWin(int team){
        freq[result[team]]--;
        result[team] += 1;
        freq[result[team]]++;

        if(result[team] > max)
            max = result[team];
    }

    static void removeWin(int team){
        freq[result[team]]--;
        result[team] -= 1;
        freq[result[team]]++;

        while(max > 0 && freq[max] == 0)
            max--;
    }
}
