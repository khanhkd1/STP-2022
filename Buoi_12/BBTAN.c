#include<stdio.h>
#define MAX 1005

int T, N, dir, x, y, count;
char matrix[MAX][MAX];

int dx[4] = {0, -1, 0, 1};
int dy[4] = {-1, 0, 1, 0};

void input(){
    scanf("%d\n", &N);
    for (int i=0; i<N; i++)
        for (int j=0; j<N; j++)
            scanf("%c ", &matrix[i][j]);
}

int outOfMatrix(int x, int y){
    if (x<0 || y<0 || x>=N || y>=N)
        return 1;
    return 0;
}

void changeDir(){
    if (matrix[x][y] == '/'){
        if (dir==1 || dir==3)
            dir = (dir + 1)%4;
        else dir = (dir + 3)%4;
    }
    else if (matrix[x][y] == '\\'){
        if (dir==1 || dir==3)
            dir = (dir - 1)%4;
        else dir = (dir + 1)%4;
    }
}

void solve(){
    dir = 2;
    x = 0; 
    y = 0;
    count = 0;

    while (!outOfMatrix(x, y)){
        if (matrix[x][y] != '0'){
            count++;
            changeDir();
        }
            
        x += dx[dir];
        y += dy[dir];
    }
}

void output(int t){
    printf("#%d %d\n", (t+1), count);
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