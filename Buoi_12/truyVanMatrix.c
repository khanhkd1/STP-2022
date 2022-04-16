#include<stdio.h>

#define MAX 2005

int T, N, M, K, tmp1, tmp2, countNum;
int matrix[MAX][MAX];
int matrixOut[MAX][MAX];

void input(){
    scanf("%d %d %d", &N, &M, &K);
    for (int i=0; i<N; i++)
        for (int j=0; j<M; j++)
            scanf("%d", &matrix[i][j]);
}

int sum(int x, int y){
    int count = 0;
    for (int i=0; i<2; i++)
        for (int j=0; j<2; j++)
            count += matrixOut[x+i][y+j];
    return (count %4 == 0)?1:0;
}

void solve(int t){
    printf("#%d ", (t+1));
    for (int k=0; k<K; k++){
        scanf("%d %d", &tmp1, &tmp2);
        int dr=0;
        int dc=0;
        switch (tmp1){
            case 1:
                dr += tmp2;
                break;
            case 2:
                dc += tmp2;
                break;
            case 3:
                dr += tmp2*(N-1);
                break;
            case 4:
                dc += tmp2*(M-1);
                break;
        }
        for (int i=0; i<N; i++)
            for (int j=0; j<M; j++)
                matrixOut[(i+dr)%N][(j+dc)%M] = matrix[i][j];

        countNum = 0;
        for (int i=0; i<N-1; i++)
            for (int j=0; j<M-1; j++)
                if (sum(i, j))
                    countNum++;
        if (k != (K-1))
            printf("%d ", countNum);
        else printf("%d", countNum);
    }
    if ((t+1) != T)
        printf("\n");
}

int main(){
    freopen("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt", "r", stdin);
    scanf("%d", &T);
    for (int t=0; t<T; t++){
        input();
        solve(t);
    }
    return 0;
}