package algorithms;


import java.util.Arrays;

public class SelectSort {

    /*
    Ищем минимальный элемент/максимальный элемент и ставим первым/последним.
    O(n*n) худшее, среднее и лучшее.
     */
    public int[] sort(int[] array) {
        int[] arrayToSort = array.clone();
        int minElementIndex;
        for (int y = 0; y < arrayToSort.length; y++)
        {
            minElementIndex = y;
            for (int i = y+1; i < arrayToSort.length; i++) {
                 if (arrayToSort[minElementIndex] > arrayToSort[i]) {
                      minElementIndex = i;
                        }
            }
        if (minElementIndex != y) swapElements(arrayToSort, minElementIndex, y);
        }
        return arrayToSort;
    }

    private void swapElements(int[] arr, int first, int second) {
        int temp = arr[first];
        System.out.println("Меняем элементы с индексами " + first + " и " + second);
        arr[first] = arr[second];
        arr[second] = temp;

    }


}
