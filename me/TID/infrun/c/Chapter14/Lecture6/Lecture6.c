#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define SLEN 101

struct book
{
	char name[SLEN];
	char author[SLEN];
};

void print_books(const struct book books[], int n);

int main()
{
	//struct book my_books[3];
	struct book* my_books = (struct book*)malloc(sizeof(struct book) * 3);
	my_books[0] = (struct book){ "The Great Gatsby","F. Scott Fitzgerald" };
	my_books[1] = (struct book){ "Hamlet","William Snakespeare" };
	my_books[2] = (struct book){ "The Odyssey", "Homer"};

	print_books(my_books, 3);
}

void print_books(const struct book books[], int n)
{
	/*for (int i = 0; i < n; i++)
	{
		printf("Book %d : \"%s\" written by \"%s\" \n", i + 1, books[i].name, books[i].author);
	}*/
	for (int i = 0; i < n; i++)
	{
		printf("Book %d : \"%s\" written by \"%s\" \n", i + 1, (books+i)->name, (books+i)->author);
	}
}
