#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

long loop_factorial(int n);
long recursive_factorial(int n);

int main()
{
	int num = 5;
	printf("%d\n", loop_factorial(num));
	printf("%d\n", recursive_factorial(num));
}

long loop_factorial(int n)
{
	long ans;

	for (ans = 1; n > 1 ; n--)
	{
		ans *= n;
	}

	return ans;
}


long recursive_factorial(int n)
{
	if (n >0)
		return n * recursive_factorial(n - 1);

	else
		return 1;
}
