#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <assert.h>

int devide(int a, int b);

int main()
{
    va_list;
    int a, b;
    int f = scanf("%d%d", &a, &b);

    printf("a / b = %d", devide(a, b));

    return 0;
}

int devide(int a, int b)
{
    assert(b != 0);

    return a / b;
}

