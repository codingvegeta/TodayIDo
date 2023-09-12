#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void fit_str(char*, unsigned int);

int main() {
    char msg[] =
        "Just,"
        " do it!";
    puts(msg);
    printf("Length %d\n", strlen(msg));
    fit_str(msg, 4);
    puts(msg);
    printf("Length %d\n", strlen(msg));
}

void fit_str(char* str, unsigned int size)
{
    if (strlen(str) > size) {
      str[4] = '\0';
    }
}