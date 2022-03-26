#include <stdio.h>

int matrix[105][105];
char array1[305], array2[305];
int t, n, m;

void input(){
    scanf("%d %d", &n, &m);
    for (int i=0; i<n; i++)
        for (int j=0; j<m; j++)
            scanf("%d", &matrix[i][j]);
    scanf("\n");
    for (int i=0; i<m; i++)
        scanf("%c", &array1[i]);
    for (int i=0; i<m; i++)
        scanf("%c", &array2[i]);
}

void checkInput(){
    for (int i=0; i<n; i++){
        for (int j=0; j<m; j++)
            printf("%d ", matrix[i][j]);
        printf("\n");
    }
    for (int i=0; i<m; i++)
        printf("%c", array1[i]);
    for (int i=0; i<m; i++)
        printf("%c", array2[i]);
}

int main() {
    scanf("%d", &t);
    for (int i=0; i<t; i++){
        input();
        checkInput();
    }
    return 0;
}