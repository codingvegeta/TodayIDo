#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main()
{
    double seed_money, target_money, annual_interest;

    printf("Input seed money : ");
    scanf("%lf", &seed_money);

    printf("Input target money : ");
    scanf("%lf", &target_money);

    printf("Input annual interest (%%): ");
    scanf("%lf", &annual_interest);

    double fund = seed_money;
    int year_count = 0;
    
    while (seed_money < target_money)
    {
        fund = fund + seed_money * annual_interest / 100.0;
        year_count++;
    }

    printf("It takes %d years\n", year_count);
}