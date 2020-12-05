package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    /*
    Алгоритм Дейкстры для поиска кратчайшего пути в взвешенном графе.
     */

    public Dijkstra()
    {
//        fillArray();
//        fill_begin_index();
        printArray();
        vertexInit();
        shortestDistanceFinder();
        printShortestWayToVertex();

      for (int i=1; i < SIZE; i++)
        wayFinder(i);
    }

    Scanner sc = new Scanner(System.in);
    final private int SIZE = 6;
    int[][] matrix =
            {{0 , 5 , 10, 0, 2, 0},
            {5 , 0 , 2 , 4 , 0 , 0},
            {10, 2, 0, 7, 0, 10},
            {0 , 4 , 7 , 0 , 3 , 0},
            {2 , 0 , 0 , 3 , 0 , 0},
            {0, 0 , 10, 0 , 0 , 0}};
    int[] minDistance = new int[matrix.length];
    int[] poseshenieVershini = new int[matrix.length];
    int begin_index = 0;
    /*

   Инициализация массива:
    for each узла
        узел = новый узел(inf, пустота)
        массив+=узел
     узел начала вес = 0
     */

    /*
    данныйузел(Дузел) = массив.мин()
    if дузел == конец то выход
    for each дуги
        if (дузел.вес + дуга.вес) < (дуга.другойузел.вес)
            дуга.друзел.вес = дузел.вес + дуга.вес
            дуга.друзел.откуда = дузел

     */





    private void shortestDistanceFinder() {
        int temp, minindex, min, inf = 10000;
        do
            {
                minindex = inf;
                min = inf;
                for (int i = 0; i< SIZE; i++)
                {
                    if ((poseshenieVershini[i] == 1) && (minDistance[i]<min))
                    {
                        min = minDistance[i];
                        minindex = i;
                    }
                }
                if (minindex != inf)
                {
                    for (int i = 0; i< SIZE; i++)
                    {
                        if (matrix[minindex][i] > 0)
                        {
                            temp = min + matrix[minindex][i];
                            if (temp < minDistance[i])
                            {
                                minDistance[i] = temp;
                            }
                        }
                    }
//                    System.out.println("mindistance = " + Arrays.toString(minDistance));

                    poseshenieVershini[minindex] = 0;
                }
        } while (minindex < inf);
    }

    private void wayFinder(int end) {
        int[] node = new int[SIZE];
        int[] weight_arr = new int[SIZE];
 //        int end = SIZE - 2;
        node[0] = end + 1;
        int k = 1;
        int weight = minDistance[end];
        while (end != begin_index)
        {
            for (int i = 0; i< SIZE; i++)
                if (matrix[i][end] != 0)
                {
                    int temp2 = weight - matrix[i][end];
                    if (temp2 == minDistance[i])
                    {
                        weight_arr[k] = weight;
                        weight = temp2;
                        end = i;
                        node[k] = i + 1;
                        k++;
                    }
                }
        }

        printBestWayResult(k,node,weight_arr);
    }

    private void fill_begin_index() {
        Scanner sc = new Scanner(System.in);
        begin_index = sc.nextInt();
    }
    private void vertexInit() {
        for (int i = 0; i< SIZE; i++)
        {
            minDistance[i] = 10000;
            poseshenieVershini[i] = 1;
        }
        minDistance[begin_index] = 0;
    }
    private void fillArray() {
        // Инициализация матрицы связей
        int temp;
        for (int i = 0; i< SIZE; i++)
        {
            matrix[i][i] = 0;
            for (int j = i + 1; j< SIZE; j++) {
                System.out.println("Введите расстояние " + (i+1) + " - " + (j+1) + ":");
                temp = sc.nextInt();
                matrix[i][j] = temp;
                matrix[j][i] = temp;
            }
        }
    }
    private void printArray() {
        // Вывод матрицы связей
        for (int i = 0; i< SIZE; i++)
        {
            for (int j = 0; j< SIZE; j++)
                System.out.print(" " + matrix[i][j]);
            System.out.println("");
        }
    }
    private void printBestWayResult(int k, int[] ver, int[] weight_arr) {
        System.out.print("Вывод кратчайшего пути: ");
        for (int i = k - 1; i >= 0; i--)
            System.out.print(ver[i]-1 + " -> (вес = "+(weight_arr[i])+") -> ");
        System.out.println("  Кол-во вершин, которое нужно пройти = " + (k-1));
    }
    private void printShortestWayToVertex() {
        // Вывод кратчайших расстояний до вершин
        System.out.println("Кратчайшие расстояние до вершин из начальной, индекс которой = " + begin_index);
        for (int i = 0; i< SIZE; i++)
            System.out.println("Минимальное расстояние до вершины " + i + " равно " + minDistance[i] + "");

    }
}
