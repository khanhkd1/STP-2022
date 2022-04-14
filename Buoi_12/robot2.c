#include<stdio.h>
#include<math.h>

#define MAX 305

int T, X, Y, K, currentDir;
char direction[2][MAX];
int points[2][2];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

void input(){
    scanf("%d %d %d\n", &X, &Y, &K);
    for (int i=0; i<2; i++){
        for (int j=0; j<K; j++)
            scanf("%c ", &direction[i][j]);
    }
}

void reset(){
    currentDir = 1;
    for (int i=0; i<2; i++)
        for (int j=0; j<2; j++)
            points[i][j] = 0;
}

void move(int stt, int dir){
    points[stt][0] += dx[dir];
    points[stt][1] += dy[dir];
    currentDir = dir;
}


void solve(){
    reset();

    for (int i=0; i<2; i++){
        for (int j=0; j<K; j++){
            switch (direction[i][j]) {
                case 'W':
                    move(i, 0);
                    break;
                case 'N':
                    move(i, 1);
                    break;
                case 'E':
                    move(i, 2);
                    break;
                case 'S':
                    move(i, 3);
                    break;
                case 'L':
                    move(i, (currentDir+3)%4);
                    break;
                case 'R':
                    move(i, (currentDir+1)%4);
                    break;
                case 'C':
                    move(i, currentDir);
                    break;
                case 'B':
                    move(i, (currentDir+2)%4);
                    break;
            }
        }
    }
}

float distance(int x, int y){
    return sqrt(pow((x-X), 2) + pow((y-Y), 2));
}

void output(int t){
    if (points[0][0] == X && points[0][0] == Y && points[1][0] == X && points[1][1] == Y)
        printf("#%d Good game!", (t+1));
    else if (points[0][0] == X && points[0][0] == Y)
        printf("#%d Team A win", (t+1));
    else if (points[1][0] == X && points[1][0] == Y)
        printf("#%d Team B win", (t+1));
    else 
        printf("#%d %.3f %.3f\n", (t+1), distance(points[0][0], points[0][1]), distance(points[1][0], points[1][1]));
}

int main(){
    freopen("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt", "r", stdin);
    scanf("%d", &T);

    for (int t=0; t<T; t++){
        input();
        solve();
        output(t);
    }
    return 0;
}