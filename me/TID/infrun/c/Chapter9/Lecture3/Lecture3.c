#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int fibonacci(int number);

int main()
{
	for (int i = 0; i < 13; ++i)
	{
		printf("%d ", fibonacci(i));
	}

	return 0;
}

int fibonacci(int number)
{
	if (number > 2)
	{
		return fibonacci(number - 1) + fibonacci(number - 2);
	}
	else
	{
		return 1;
	}
}