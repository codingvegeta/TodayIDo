#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

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

void UpdateString(char* str, int(*pf)(int))
{
	while (*str)
	{
		*str = (*pf)(*str);
		str++;
	}
}

int main()
{
	char str[] = "Hello, World!";
	void (*pf)(char*);

	pf = ToUpper;

	printf("String literal %lld\n", (long long)("Hello, World!"));
	printf("Function pointer %lld\n", (long long)ToUpper);
	printf("Variable %lld\n", (long long)str);

	pf(str);

	printf("ToUpper %s\n", str);

	pf = ToLower;

	pf(str);

	printf("ToLower %s\n", str);
}
