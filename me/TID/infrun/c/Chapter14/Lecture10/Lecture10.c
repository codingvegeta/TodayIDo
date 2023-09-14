#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

enum spectrum { red, orange, yellow, green, blue};
const char* colors[] = { "red","orange","yellow","green","blue" };

#define LEN 30

int main()
{
	char choice[LEN] = { 0, };
	enum spectrum color;
	bool color_is_found = false;

	while (1)
	{
		printf("Input a color name (empty line to quit)\n");
		color_is_found = scanf("%[^\n]%*c", choice);
		if (!color_is_found)
		{
			printf("Goodbye!");
			break;
		}

		if (strcmp(choice, colors[red]) == 0)
		{
			printf("Red rose\n");
		}
		else if (strcmp(choice, colors[orange]) == 0)
		{
			printf("Oranges\n");
		}
		else if (strcmp(choice, colors[yellow]) == 0)
		{
			printf("Bee\n");
		}
		else if (strcmp(choice, colors[green]) == 0)
		{
			printf("green apple\n");
		}
		else if (strcmp(choice, colors[blue]) == 0)
		{
			printf("blue see\n");
		}
		else
		{
			printf("Please try different color %s\n", choice);
		}
	}
}
