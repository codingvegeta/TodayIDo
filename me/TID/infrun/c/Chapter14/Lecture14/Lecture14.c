#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>

void update_string(char* str, int(*pf)(int));
void ToUpper(char* str);
void ToLower(char* str);
void Transpose(char* str);

int main()
{
	char options[] = { 'u','l' };
	int n = sizeof(options) / sizeof(char);

	typedef void (*FUNC_TYPE)(char*);
	FUNC_TYPE operations[] = { ToUpper, ToLower };

	printf("Enter a string\n>> ");
	char input[100];

	while (scanf("%[^\n]%*c",input) != 1)
	{
		printf("Please try again.\n>> ");
	}
	
	while (true)
	{
		printf("Choose an option:\n");
		printf("u) to upper\n");
		printf("l) to lower\n");

		char c;
		while (scanf("%[^\n]%*c", c) != 1)
		{
			printf("Please try again.\n");
		}

		bool find = false;

		switch (c)
		{
		case 'u':
			ToUpper(input);
			find = true;
			break;
		case 'l':
			ToLower(input);
			find = true;
			break;
		}
		for (int i = 0; i < n; i++)
		{
			if (options[i] == c) 
			{
				(*(operations[i]))(input);
				find = true;
			}
		}

		if (find) 
		{

		}

	}

}

void update_string(char* str, int(*pf)(int));
void ToUpper(char* str)
{

	printf("start %p\n", str);
	while (*str)
	{
		*str = toupper(*str);
		str++;
	}
	printf("end %p\n", str);
}

void ToLower(char* str)
{
	while (*str)
	{
		*str = tolower(*str);
		str++;
	}
}
void Transpose(char* str);