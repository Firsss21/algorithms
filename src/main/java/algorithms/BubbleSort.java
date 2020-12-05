package algorithms;


import java.util.Arrays;

public class BubbleSort {

    /*
    Пузырьковая сортировка - это сравнение соседних элементов и смена чисел местами, если оно больше/меньше.
    После одного прохода по массиву последний элемент прохода по массиву(не массива) отсекается.
    О(n) - идеал. O(n*n) - среднее и худшее время.
     */

    public int[] sort(int[] array) {
        int[] arrayToSort = array.clone();
        boolean swap_elements;
//        int iterations = 0;
            for(int i = 0; i < arrayToSort.length - 1; i++) {
                swap_elements = false;
                for(int y = 0; y < (arrayToSort.length - i - 1); y++) {
                    if (arrayToSort[y] > arrayToSort[y+1]) {
                        swapElements(arrayToSort ,  y, y+1);
                        swap_elements = true;

                    }
//                    iterations ++ ;
                }
                if (!swap_elements) break;
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
