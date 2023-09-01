#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <limits.h>
#include <stdlib.h>

int main()
{
    unsigned int u_max = UINT_MAX;

    char buffer[33];
    _itoa(u_max, buffer, 2);


    printf("decimal : %u\n", u_max);
    printf("binary : %s\n", buffer);
    //printf("%u\n", u_max);

    /*
    unsigned int u_max = UINT_MAX;
    unsigned int u_min = 0;
    signed int i_max = INT_MAX;
    signed int i_min = INT_MIN;


    printf("max of uint %u\n", u_max);
    printf("min of uint %u\n", u_min);
    printf("max of int %d\n", i_max);
    printf("min of int %d\n", i_min);
    */
  

    // printf("%d\n", sizeof(unsigned int));
    // printf("%d", sizeof(i));
}