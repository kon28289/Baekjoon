#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int size, apple, moveCount, time = 0, x = 1, y = 1, moveDegree = 0, gameEnd = 1;
    string moveState = "S"; // straight
    cin >> size >> apple; // 게임보드 크기, 사과개수

    deque<pair<int, int>>appleLocation; // 사과를 저장해둘 덱
    deque<pair<int, int>>snake; // 뱀 위치 저장해둘 덱
    deque<pair<int, string>>move; // 방향 저장해둘 덱
    

    for (int i = 0; i < apple; i++) {
        int n1, n2;
        cin >> n1 >> n2;
        appleLocation.push_back({ n2, n1 }); // 사과 위치 저장
    }
    cin >> moveCount;
    for (int i = 0; i < moveCount; i++) {
        int n;
        string str;
        cin >> n >> str;
        move.push_back({ n,str }); // 방향전환 입력
    }
    snake.push_back({ x,y });

    while (gameEnd) {
        for (int i = 0; i < move.size(); i++) {
            if (time == move[i].first) { // 방향을 변경할 시간인지 확인
                if (move[i].second == "L") { // 변경할 방향 확인
                    moveDegree += 90;
                    move.pop_front();
                }
                else {
                    moveDegree += (-90);
                    move.pop_front();
                }
            }
        }
        
        moveDegree %= 360;
        
        // 이동
        if (moveDegree == 0 || moveDegree == 360) {
            x++;
            time++;
        }
        else if (moveDegree == 90 || moveDegree == -270) {
            y--;
            time++;
        }
        else if (abs(moveDegree) == 180) {
            x--;
            time++;
        }
        else if (moveDegree == 270 || moveDegree == -90) {
            y++;
            time++;
        }
        if (x > size || y > size || x < 1 || y < 1) { // 패배 조건, 벽에 닿았거나 자기 몸과 부딪혔거나
            break;
        }
        else {
            for (int i = 0; i < snake.size(); i++) {
                if (x == snake[i].first && y == snake[i].second) {
                    gameEnd = 0;
                    break;
                }
            }
        }
        snake.push_front({ x,y });

        //사과가 있는지 확인       
        auto iter = find(appleLocation.begin(), appleLocation.end(), make_pair(x,y));
        if (iter != appleLocation.end()) { // 사과가 있다면
            appleLocation.erase(iter);
        }
        else { // 사과가 없다면
            snake.pop_back();
        }
    }
    cout << time;
}
