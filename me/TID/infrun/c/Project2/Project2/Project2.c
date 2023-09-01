//#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main()
{
    double won = 0;
    double dollar = 0;

    printf("Input won\n");
    scanf("%lf", &won);

    dollar = won * 0.00089;

    printf("Dollar = %lf\n", dollar);

    return 0;
}


