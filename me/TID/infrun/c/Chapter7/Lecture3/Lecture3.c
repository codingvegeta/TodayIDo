#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

#define BASE1 12000000.0
#define BASE2 46000000.0
#define BASE3 88000000.0
#define BASE4 150000000.0
#define BASE5 300000000.0
#define BASE6 500000000.0

#define RATE1 (6.0 / 100.0)
#define RATE2 (15.0 / 100.0)
#define RATE3 (24.0 / 100.0)
#define RATE4 (35.0 / 100.0)
#define RATE5 (38.0 / 100.0)
#define RATE6 (40.0 / 100.0)
#define RATE7 (42.0 / 100.0)

#define BASIC_EDUCTION 1500000.0

int main()
{
	double money = 0;
	double answer = 0.0;
	printf("금액을 입력해 주세요 :");
	scanf("%lf", &money);
	money -= BASIC_EDUCTION;

	if (money - BASE6 > 0)
	{
		answer += (money - BASE6) * RATE7;
		money -= (money - BASE6);
	}
	if (money - BASE5 > 0)
	{
		answer += (money - BASE5) * RATE6;
		money -= (money - BASE5);
	}
	if (money - BASE4 > 0)
	{
		answer += (money - BASE4) * RATE5;
		money -= (money - BASE4);
	}
	if (money - BASE3 > 0)
	{
		answer += (money - BASE3) * RATE4;
		money -= (money - BASE3);
	}
	if (money - BASE2 > 0)
	{
		answer += (money - BASE2) * RATE3;
		money -= (money - BASE2);
	}
	if (money - BASE1 > 0)
	{
		answer += (money - BASE1) * RATE2;
		money -= (money - BASE1);
	}
	
	answer += (money * RATE1);
	
	printf("금액은 %f 입니다", answer);

	return 0;
}