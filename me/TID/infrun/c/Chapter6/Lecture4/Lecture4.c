#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define START 'A';


int main()
{
	const int NUM_ROWS = 12;
	const char FIRST_CHAR = 'A';

	for (int r = 0; r < NUM_ROWS; ++r)
	{
		for (int c = FIRST_CHAR + r; c < FIRST_CHAR + NUM_ROWS ;  ++c)
		{
			printf("%c ", c);
		}
		printf("\n");
	}
}