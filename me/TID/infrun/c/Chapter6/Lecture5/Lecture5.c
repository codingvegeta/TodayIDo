#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define NUMBER 5

int main()
{

	int arrays[NUMBER];

	int sum = 0;
	printf("%d���� ���ڸ� �Է����ּ��� : ", NUMBER);
	for (int i = 0; i < NUMBER; i++)
	{
		scanf("%d", &arrays[i]);
	}
	for (int i = 0; i < NUMBER; i++)
	{
		sum += arrays[i];
	}
	printf("Sum %d\n", sum);
}