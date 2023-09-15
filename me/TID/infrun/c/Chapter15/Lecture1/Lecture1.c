#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>

unsigned char to_decimal(const char bi[]);

int main()
{
	printf("Binary (string) to Decimal conversion\n");

	printf("%d\n", to_decimal("00000110"));
	printf("%d\n", to_decimal("00010110"));

	printf("%d\n", to_decimal("10010100"));
}

unsigned char to_decimal(const char bi[])
{
	const size_t length = strlen(bi);
	unsigned char sum = 0;

	for (size_t i = 0; i <length; i++)
	{
		if (bi[i] == '1')
		{
			sum += 1 * (int)pow(2, length - 1 - i);
		}
		else if (bi[i] != 0)
		{
			printf("Wrong character : %c", bi[i]);
			exit(1);
		}
	}
	
	return sum;
}