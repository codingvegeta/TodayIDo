#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

#define NLEN 30

struct name_count
{
	char first[NLEN];
	char last[NLEN];
	int num;
};

void receive_input(struct name_count*);
void count_characters(struct name_count*);
void show_result(const struct name_count*);
char* s_gets(char* st, int n);

int main()
{
	struct name_count user_name;
	
	receive_input(&user_name);
	count_characters(&user_name);
	show_result(&user_name);

	return 0;

}

void receive_input(struct name_count* user)
{
	printf("Input your first name:\n>>");
	s_gets(user->first, NLEN);
	printf("Input your last name:\n>>");
	s_gets(user->last, NLEN);
}
void count_characters(struct name_count* user)
{
	int countA = 0;
	/*for (int i = 0; i < sizeof(user->first) / sizeof(user->first[0]); i++)
	{
		count++;

	}
	printf("%d %d", sizeof(user->first), sizeof(user->first[0]));*/
	while (user->first[countA] != '\0')
	{
		countA++;
	}

	/*for (int i = 0; i < sizeof(user->last) / sizeof(user->last[0]); i++)
	{
		count++;

	}
	*/

	int countB = 0;

	while (user->last[countB] != '\0')
	{
		countB++;
	}

	user->num = countA + countB;
}
void show_result(const struct name_count* user)
{
	printf("Hi, %s %s. Your name has %d characters.", user->last, user->first, user->num);
}
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
			*find = '\0';
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

