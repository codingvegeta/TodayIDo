#define	_CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int g_int;

double g_arr[1000] = { 0,0, };

int x = 5;
int y = 1 + 2;
size_t z = sizeof(int);

void fun_sec();

int main()
{
	fun_sec();
}
