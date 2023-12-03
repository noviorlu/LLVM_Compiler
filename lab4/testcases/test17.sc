#include "scio.h"

void quicksort(int start, int end, int arr[]){
    int pivot;
    int i;
    int j;
    int temp;
    if(start < end){
        pivot = start;
        i = start;
        j = end;
        while(i < j){
            while(arr[i] <= arr[pivot] && i < end){
                i = i + 1;
            }
            while(arr[j]>arr[pivot])
                j = j - 1;
            if(i < j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;
        quicksort(0, j-1, arr);
        quicksort(j+1, end, arr);
    }
}

int main() {
   int a[6];
   int start;
   int end;

   a[0] = 5;
   a[1] = 1;
   a[2] = 4;
   a[3] = 2;
   a[4] = 6;
   a[5] = 0;

   start = 0;
   end = 5;

   quicksort(start,end,a);

   writeInt(a[0]);
   newLine();

   writeInt(a[1]);
   newLine();

   writeInt(a[2]);
   newLine();

   writeInt(a[3]);
   newLine();

   writeInt(a[4]);
   newLine();

   writeInt(a[5]);
   newLine();

   return (0);
}
