#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void swap(int* xp, int* yp);
void printArray(int arr[], int size);
void selectionSort(int arr[], int n);

int main()
{ 
	int arr[] = {64, 25, 12, 22, 11};
	int n = sizeof(arr) / sizeof(arr[0]);
    
    printArray(arr, n);
	selectionSort(arr, n);
    printArray(arr, n);
}
void swap(int* xp, int* yp)
{ 
	int tmp = *xp;
        *xp = *yp;
        *yp = tmp;
}
void printArray(int arr[], int size)
{
    for (int i = 0; i < size; i++) 
    {
        printf(" %d", arr[i]);
    }
    printf("\n");
}
void selectionSort(int arr[], int n)
{
    for (int i = 0; i < n-1; i++) 
	{
      int min = i;

      for (int j = i + 1; j < n; j++) 
      {
        if (arr[j] < arr[min]) 
        {
          min = j;
        }
      }
        swap(&arr[i], &arr[min]);
    }
}