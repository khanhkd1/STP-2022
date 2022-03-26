#include <stdio.h>
#include <stdlib.h>

int cmpfunc (const void * a, const void * b) {
   return ( *(int*)a - *(int*)b );
}

int main() {
    freopen("/Users/khnhkd/StudySpace/java-study/src/STP_2022/input.txt", "r", stdin);
    int n, k, compare;
    int *item;
    scanf("%d %d", &n, &k);
    int array[n];
    for (int i = 0; i < n; i++)
        scanf("%d", &array[i]);
    qsort(array, n, sizeof(int), cmpfunc);
    int count = 0;
    for (int i = 0; i < n; i++){
            compare = array[i] + k;
            item = (int*) bsearch (&compare, array, n, sizeof (int), cmpfunc);
            if( item != NULL )
                count++;
        }
    printf("%d", count);
    return 0;
}