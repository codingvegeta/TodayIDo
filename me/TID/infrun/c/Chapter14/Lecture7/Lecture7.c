#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <conio.h>
#include <stdlib.h>

#define SLEN 101

struct book
{
	char name[SLEN];
	char author[SLEN];
};

void print_books(const struct book* books, int n);
void write_books(const char* filename, const struct book* books, int n);
struct book* read_books(const char* filename, int* n);
void read_books2(const char* filename, struct book** books_dptr, int * n);

int main()
{
	int temp;
	int n = 3;

	struct book* my_books = (struct book*)malloc(sizeof(struct book) * n);

	if (!my_books)
	{
		printf("Malloc failed");
		exit(1);
	}

	my_books[0] = (struct book){ "The Great Gatsby","F. Scott Fitzgerald" };
	my_books[1] = (struct book){ "Hamlet","William Snakespeare" };
	my_books[2] = (struct book){ "The Odyssey", "Homer" };

	print_books(my_books, n);

	printf("\nWriting to a file.\n");
	write_books("books.txt", my_books, n);
	free(my_books);
	n = 0;
	printf("Done.\n");

	printf("\nPress any key to read data from a file. \n\n");
	temp = _getch();

	my_books = read_books("books.txt", &n);
	//read_books2("books.txt", &my_books, &n);
	print_books(my_books, n);
	free(my_books);
	n = 0;

	return 0;

}

void print_books(const struct book* books, int n)
{
	for (int i = 0; i < n; i++)
	{
		printf("Book %d : \"%s\" written by \"%s\" \n", i + 1, books[i].name, books[i].author);
	}
}

void write_books(const char* filename, const struct book* books, int n)
{
	FILE* fp = fopen(filename, "w");

	if (fp == NULL)
	{
		fputs("Can't open file.", stderr);
		exit(1);
	}

	fprintf(fp, "%d\n", n);

	for (int i = 0; i < n; i++)
	{
		fprintf(fp, "%s\n%s\n", books[i].name, books[i].author);
	}

	fclose(fp);
}

struct book* read_books(const char* filename, int* n)
{
	FILE* fp = fopen(filename, "r");

	if (fp == NULL)
	{
		fputs("Cant' open file", stderr);
		exit(1);
	}

	int flag;
	flag = fscanf(fp, "%d%*c", n);
	if (flag != 1)
	{
		printf("File read failed");
		exit(1);
	}

	struct book* books = (struct book*)calloc(sizeof(struct book), *n);

	for (int i = 0; i < *n; i++)
	{
		flag = fscanf(fp, "%[^\n]%*c%[^\n]%*c", books[i].name, books[i].author);
		if (flag != 2)
		{
			printf("File read failed");
			exit(1);
		}
	}
	
	fclose(fp);
	
	return books;
}

void read_books2(const char* filename, struct book** books_dptr, int* n)
{
	FILE* fp = fopen(filename, "r");

	if (fp == NULL)
	{
		fputs("Cant' open file", stderr);
		exit(1);
	}

	int flag;
	flag = fscanf(fp, "%d%*c", n);
	if (flag != 1)
	{
		printf("File read failed");
		exit(1);
	}

	struct book* books = (struct book*)calloc(sizeof(struct book), *n);

	for (int i = 0; i < *n; i++)
	{
		flag = fscanf(fp, "%[^\n]%*c%[^\n]%*c", books[i].name, books[i].author);
		if (flag != 2)
		{
			printf("File read failed");
			exit(1);
		}
	}

	fclose(fp);

	*books_dptr = books;
}