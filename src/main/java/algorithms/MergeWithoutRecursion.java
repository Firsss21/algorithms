package algorithms;

import java.util.Arrays;

public class  MergeWithoutRecursion {
    public MergeWithoutRecursion() {
        int arr[] = {12,3,9,7,5,11,4,8,10,1,6,2};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void printArray(int[] arr, int lim)
    {
        int i, j = 1;

        for (i = 0; i < arr.length; i++)
        {

            System.out.print(arr[i]);

            if (j >= lim) {
                System.out.print(" | ");

                j = 0;
            }
            else System.out.print("  ");

            j++;
        }
    }

    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        int length = arr.length;
        int i, j, k;
        int left_left, left_right, right_left, right_right;


        for(int step = 1; step < length; step *= 2 ) {
            left_left = 0;
            k = 0;

            while (left_left + step < length) {
                left_right = left_left + step - 1;
                right_left = left_right + 1;
                right_right = right_left + step - 1;

                if (right_right >= length) right_right = length - 1;

                i = left_left;
                j = right_left;

                while (i <= left_right && j <= right_right) {
                    if (arr[i] <= arr[j])
                        temp[k++] = arr[i++];
                    else
                        temp[k++] = arr[j++];
                }

                while (i <= left_right) temp[k++] = arr[i++];
                while (j <= right_right) temp[k++] = arr[j++];

                left_left = right_right + 1;


            }

            for (i = left_left; k < length; i++) temp[k++] = arr[i];
            for (i = 0; i < length; i++) arr[i] = temp[i];
            System.out.println("step " + step);
            printArray(arr, step);

            System.out.println(" ");
        }
    }
}
