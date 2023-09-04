#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main()
{
	const int secret_key = 333;
	int user_key = 0;

	do
	{
		printf("Enter secret code : ");
		scanf("%d", &user_key);
	} 
	while (user_key != secret_key);
	printf("Good!");
}