#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 41

struct person
{
	char name[MAX];
	int age;
	float height;
};

int main()
{
	int flag;

	struct person genie;

	strcpy(genie.name, "Will Smith");
	genie.age = 1000;

	flag = scanf("%f", &genie.height);
	printf("%f\n", genie.height);

	struct person beauty = {
		.age = 20,
		.name = "Bell",
		.height = 150.f
	};

	struct person* someone;

	someone = &genie;

	someone->age = 1001;
	printf("%s %d\n", someone->name, (*someone).age);
}
