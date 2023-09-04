#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int compute_pow(int base, int exp)
{
	int result = 1;
	for (int i = 0; i < exp; i++)
	{
		result *= base;
	}
	return result;
}


int main()
{
	int base, exp;
	while (scanf("%d %d", &base, &exp) == 2)
	{
		int result = compute_pow(base, exp);
		printf("Result = %d\n", result);
	}
	return 0;
}