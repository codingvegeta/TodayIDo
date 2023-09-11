#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	char c;
	while (1)
	{
		printf("Enter the letter of your choice : \n");
		printf("a. avengers\tb. beep\n");
		printf("c. count\tq. quit\n");
		c = getchar();
		
		if (c == 'a')
		{
			printf("Avengers assemble!\n");
		}
		else if (c == 'b')
		{
			printf("\a");
		}
		else if (c == 'c')
		{
			int t;
			scanf("%d", &t);
			for (int i = 1; i <= t; i++)
			{
				printf("%d \n", i);
			}
		}
		else if (c == 'q')
		{
			break;
		}

		while (getchar() != '\n')
		{
			continue;
		}
	}
}
