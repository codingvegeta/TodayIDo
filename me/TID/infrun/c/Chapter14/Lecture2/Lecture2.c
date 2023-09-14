#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define MAX_TITLE 40
#define MAX_AUTHOR 40
#define MAX_BOOKS 3

char* s_gets(char* st, int n)
{
	char* ret_val;
	char* find;

	ret_val = fgets(st, n, stdin);
	if (ret_val)
	{
		find = strchr(st, '\n');
		if (find)
		{
			* find = '\0';
		}
		else
		{
			while (getchar() != '\n')
			{
				continue;
			}
		}
	}
	return ret_val;
}

struct book
{
	char name[MAX_TITLE];
	char author[MAX_AUTHOR];
	float price;
};

int main()
{
	struct book books[MAX_BOOKS];

	int count = 0;

	while(1)
	{
		printf("Input book title or press Enter \n>>");

		if (s_gets(books[count].name, MAX_TITLE) == NULL)
		{
			break;
		}

		if (books[count].name[0] == '\0')
		{
			break;
		}

		printf("Input the author \n>>");
		s_gets(books[count].author, MAX_TITLE);

		printf("Input the price \n>>");
		int flag = scanf("%f", &books[count].price);
		while (getchar() != '\n')
		{
			continue;
		}

		count++;

		if (count == MAX_BOOKS)
		{
			printf("No more books. \n");
			break;
		}
	}
	
	if (count > 0)
	{
		printf("\nThe list of books:\n");
		for (int i = 0; i < count; i++)
		{
			printf("\"%s \" written by %s : %.1f\n", books[i].name, books[i].author, books[i].price);
		}
	}
	else
	{
		printf("No books to show.\n");
	}
	

}
