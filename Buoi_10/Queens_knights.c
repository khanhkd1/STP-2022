#include <stdio.h>
int n, m, testCase=0, count, k, r, c;
char matrix[1005][1005];

int checkStop(row, col){
    if (row<0 || row>= n || col<0 || col>= m || matrix[row][col]=='K' || matrix[row][col]=='Q' || matrix[row][col]=='P')
        return 1;
    return 0;
}

int main(){
    freopen("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt", "r", stdin);
    scanf("%d %d ", &n, &m);
    while(n != 0 && m != 0){
        // input data
        scanf("%d", &k);
        count = n * m - k;
        for (int i = 0; i < k; i++){
            scanf("%d %d", &r, &c);
            matrix[r-1][c-1] = 'Q';
        }
        scanf("%d", &k);
        count -= k;
        for (int i = 0; i < k; i++){
            scanf("%d %d", &r, &c);
            matrix[r-1][c-1] = 'K';
        }
        scanf("%d", &k);
        count -= k;
        for (int i = 0; i < k; i++){
            scanf("%d %d", &r, &c);
            matrix[r-1][c-1] = 'P';
        }
        // end input data

        for (int row=0; row<n; row++){
            for (int col = 0; col < m; col++){
                if (matrix[row][col] == 'K'){
                    for (int subRow=row-2; subRow<=row+2; subRow+=4){
                            for (int subCol=col-1; subCol<=col+1; subCol+=2){
                                if (subRow<0 || subRow>=n || subCol<0 || subCol>=m)
                                    continue;
                                if (matrix[subRow][subCol] != 'K' && matrix[subRow][subCol] != 'Q' && matrix[subRow][subCol] != 'P' && matrix[subRow][subCol] != 'x'){
                                    matrix[subRow][subCol] = 'x';
                                    count--;
                                }
                            }
                        }

                    for (int subRow=row-1; subRow<=row+1; subRow+=2){
                        for (int subCol=col-2; subCol<=col+2; subCol+=4){
                            if (subRow<0 || subRow>=n || subCol<0 || subCol>=m)
                                continue;
                            if (matrix[subRow][subCol] != 'K' && matrix[subRow][subCol] != 'Q' && matrix[subRow][subCol] != 'P' && matrix[subRow][subCol] != 'x'){
                                matrix[subRow][subCol] = 'x';
                                count--;
                            }
                        }
                    }
                }
                else if (matrix[row][col] == 'Q'){
                    int checkStop1 = 0, checkStop2 = 0, checkStop3 = 0, checkStop4 = 0, checkStop5 = 0, checkStop6 = 0, checkStop7 = 0, checkStop8 = 0;
                    // Math.max(Math.max(row, n-row), Math.max(col, m-col))
                    for (int sub=1; sub<(n>m?n:m); sub++){
                        if (!checkStop1){
                            if (checkStop(row-sub, col-sub))
                                checkStop1=1;
                            else if (matrix[row-sub][col-sub] != 'x'){
                                matrix[row-sub][col-sub] = 'x';
                                count--;
                            }
                        }

                        if (!checkStop2){
                            if (checkStop(row-sub, col))
                                checkStop2=1;
                            else if (matrix[row-sub][col] != 'x'){
                                matrix[row-sub][col] = 'x';
                                count--;
                            }
                        }

                        if (!checkStop3){
                            if (checkStop(row-sub, col+sub))
                                checkStop3=1;
                            else if (matrix[row-sub][col+sub] != 'x'){
                                matrix[row-sub][col+sub] = 'x';
                                count--;
                            }
                        }

                        if (!checkStop4){
                            if (checkStop(row, col+sub))
                                checkStop4=1;
                            else if (matrix[row][col+sub] != 'x'){
                                matrix[row][col+sub] = 'x';
                                count--;
                            }
                        }

                        if (!checkStop5){
                            if (checkStop(row+sub, col+sub))
                                checkStop5=1;
                            else if (matrix[row+sub][col+sub] != 'x'){
                                matrix[row+sub][col+sub] = 'x';
                                count--;
                            }
                        }

                        if (!checkStop6){
                            if (checkStop(row+sub, col))
                                checkStop6=1;
                            else if (matrix[row+sub][col] != 'x'){
                                matrix[row+sub][col] = 'x';
                                count--;
                            }
                        }

                        if (!checkStop7){
                            if (checkStop(row+sub, col-sub))
                                checkStop7=1;
                            else if (matrix[row+sub][col-sub] != 'x'){
                                matrix[row+sub][col-sub] = 'x';
                                count--;
                            }
                        }

                        if (!checkStop8){
                            if (checkStop(row, col-sub))
                                checkStop8=1;
                            else if (matrix[row][col-sub] != 'x'){
                                matrix[row][col-sub] = 'x';
                                count--;
                            }
                        }

                        if (checkStop1 * checkStop2 * checkStop3 * checkStop4 * checkStop5 * checkStop6 * checkStop7 * checkStop8 == 1)
                            break;
                    }
                }
            }
        }
        
        printf("Board %d has %d safe squares.\n", ++testCase, count);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                // if (matrix[i][j] != 'K' && matrix[i][j] != 'Q' && matrix[i][j] != 'P' && matrix[i][j] != 'x')
                //     matrix[i][j] = 'o';
                // printf("%c ", matrix[i][j]);
                matrix[i][j] = 'o';
            }    
            // printf("\n");   
        }
            
        scanf("%d %d ", &n, &m);
    }
    return 0;
}