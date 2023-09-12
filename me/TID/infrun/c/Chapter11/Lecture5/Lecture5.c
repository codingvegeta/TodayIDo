#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

void swap(char** xp, char** yp);
void printStringArray(char* arr[], int size);
void selectionSort(char* arr[], int n);

int main()
{ 
	char* arr[] = {"Cherry", "AppleBee", "Pineapple", "Apple", "Orange"};
	int n = sizeof(arr) / sizeof(arr[0]);

	printStringArray(arr, n);

	selectionSort(arr, n);

	printStringArray(arr, n);

	return 0;
}

void swap(char** xp, char** yp)
{ 
	char *tmp = *xp;
        *xp = *yp;
       *yp = tmp;
}

void printStringArray(char* arr[], int size)
{
        for (int i = 0; i < size; i++) 
		{
          puts(arr[i]);
        }
        printf("\n");
}

void selectionSort(char* arr[], int n)
{
        for (int i = 0; i < n-1; i++) 
		{
          int min = i;
          for (int j = i+1; j < n; j++) 
          {
            if (strcmp(arr[j], arr[min]) < 0) 
            {
              min = j;
            }
          }
          swap(&arr[i], &arr[min]);
        }
}