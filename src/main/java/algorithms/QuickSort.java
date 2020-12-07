package algorithms;

// Java program for implementation of QuickSort
// Класс с квиксортом
class QuickSort
{
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */

    /* Эта функция берет последний элемент как pivot, ставит его в нужное место в сортированном массиве
    и ставит все меньшие элементы влево, большие вправо. */

    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element

        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot

            if (arr[j] < pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */

    /*
    Основная функция, которая квиксортит. эрр - массив
    лоу - первый элемент
    хай - последний элемент
     */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */

            printArray(arr);

            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition


            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    // Принт массива
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 2, 6, 3, 15, 22, 1, 5, 11, 53, 17};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);

    }
}
