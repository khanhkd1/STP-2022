#include<stdio.h>

#define MAX 105

int t, m, n, r, p;
char matrix[MAX][MAX];
int dx[4] = {0, -1, 0, 1};
int dy[4] = {-1, 0, 1, 0}; 

void input(){
    p = 0;
    scanf("%d %d\n", &m, &n);
    for (int i=0; i<m; i++){
        for (int j=0; j<n; j++){
            scanf("%c ", &matrix[i][j]);
            if (matrix[i][j] == '*'){
                p++;
            }
        }
    }
}

int outOfMatrix(int x, int y){
    if (x<0 || x>=m || y<0 || y>=n)
        return 1;
    return 0;
}

void DFS(int x, int y){
    matrix[x][y] = '#';
    for (int i=0; i<4; i++){
        int tx = x + dx[i];
        int ty = y + dy[i];
        if (!outOfMatrix(tx, ty) && matrix[tx][ty] != '#'){
            DFS(tx, ty);
        }     
    }
}

void solve(){
    r = 0;
    for (int i=1; i<m-1; i++){
        for (int j=1; j<n-1; j++){
            if (matrix[i][j] != '#'){
                r++;
                DFS(i, j);
            }
        }
    }
}

void output(){
    printf("%.2f\n", (1.0 * p)/r);
}

int main(){
    freopen("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt", "r", stdin);
    scanf("%d", &t);

    for (int i=0; i<t; i++){
        input();
        solve();
        output();
    }
    return 0;
}