#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define MESSAGE "A symbolic string contant"
#define MAXLENGTH 81

int main() 
{ 
	char words[MAXLENGTH] = "A string in an array";
    const char* pt1 = "A pointer to a string.";

	puts("Puts() adds a newline at the end:");
    puts(MESSAGE);
    puts(words);
    puts(pt1);
    words[3] = 'p';
    puts(words);

}
