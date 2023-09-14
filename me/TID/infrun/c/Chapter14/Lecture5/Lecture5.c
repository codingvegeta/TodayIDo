#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define SLEN 81

struct namect
{
	char* fname;
	char* lname;
	int letters;
};

void getinfo(struct namect*);
void makeinfo(struct namect*);
void showinfo(const struct namect*);
void cleanup(struct namect*);

char* s_gets(char* st, int n);

int main()
{
	struct namect person;

	getinfo(&person);
	makeinfo(&person);
	showinfo(&person);
	cleanup(&person);

}

void getinfo(struct namect* pst)
{
	int flag;
	char temp[SLEN] = { 0, };

	printf("Please enter your first name.\n");
	flag = scanf("%[^\n]%*c", temp);
	if (flag !=1)
	{
		printf("Wrong input");
	}
	else
	{
		pst->fname = (char*)malloc(strlen(temp) + 1);
		if (pst->fname != NULL)
		{
			strcpy(pst->fname, temp);
		}
		else
		{
			printf("Malloc() failed");
		}
	}

	printf("Please enter your last name.\n");
	flag = scanf("%[^\n]%*c", temp);
	if (flag != 1)
	{
		printf("Wrong input");
	}
	else
	{
		pst->lname = (char*)malloc(strlen(temp) + 1);
		if (pst->lname != NULL)
		{
			strcpy(pst->lname, temp);
		}
		else
		{
			printf("Malloc() failed");
		}
	}
}

void makeinfo(struct namect* pst)
{
	pst->letters = strlen(pst->fname) + strlen(pst->lname);
}

void showinfo(const struct namect* pst)
{
	printf("%s %s, your name contains %d letters.\n", pst->lname, pst->fname, pst->letters);
}

void cleanup(struct namect* pst)
{
	free(pst->fname);
	free(pst->lname);
}
