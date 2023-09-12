#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define TEST "A string from #define."

void custom_put(const char* str);
int custom_put2(const char* str);


int main() {
	
	char str[60] = "String array initialized";
	custom_put("hello world!");
    printf("%d",custom_put2("hello"));
}

void custom_put(const char* str) 
{ 
	while (*str != '\0')
	{
      putchar(*str++);
	}
}

int custom_put2(const char* str)
{ 
	int count = 0;
	while (*str != '\0') 
	{
		putchar(*str++);
		count++;
    }
    putchar('\n');

	return count;
}