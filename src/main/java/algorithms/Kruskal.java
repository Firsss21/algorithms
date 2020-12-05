package algorithms;

import java.util.Arrays;

public class Kruskal {

    /*
    Алгоритм Краскала для построения минимального остовного дерева ( другими словами минимальное покрывающее дерево )

    Ищем минимальное ребро, затем ищем следующее минимальное ребро, и что бы оно соеденяло вершины из разных компонент (не было в связи с ранее выбранными вершинами).
    Далее ищем еще одно мин ребро, далее ищем следующее мин ребро и уже несколько вершин сформировало цепочку.
    Далее ищем мин ребро и если несколько кандидатов - берем только то, которое свяжет нас с не связаннами до этого компонентами.
     */


     private static final int SIZE = 5;
     private int[] nodeDependence = new int[SIZE];
     private static final int INF = Integer.MAX_VALUE;
     private int[][] resultMatrix = new int[SIZE][SIZE];
    public Kruskal() {
        int[][] matrix = {
                {INF, 2, INF, 6, INF},
                {2, INF, 3, 8, 5},
                {INF, 3, INF, INF, 7},
                {6, 8, INF, INF, 9},
                {INF, 5, 7, 9, INF},
        };
        algohrithm(matrix);
    }

    // проверяем связь на зависимость и перемещаемся к следующему зависищему от него элементу.
    private int checkDependencies(int i)
    {
        while (nodeDependence[i] != i)
            i = nodeDependence[i];
        return i;
    }


    // создаем связь между i/j.
    private void edge(int i, int j)
    {
        int a = checkDependencies(i);
        int b = checkDependencies(j);
        nodeDependence[a] = b;
//        System.out.println("edge input i = " + i + ", j = " + j + " a = " + a + " b = " + b + " nodeDependence["+a+"] = " + nodeDependence[a]);
    }

    private void algohrithm(int[][] matrix)
    {
        int minDistance = 0; // кратчайшее расстояния для прохождения всех узлов

        for (int i = 0; i < SIZE; i++) // заполняем массив соеденений самим собой
            nodeDependence[i] = i;



        int edges = 0; // кол-во ребер
        while (edges < SIZE - 1) // пока не создадим минимальное кол-во ребер для соеденения всех узлов
            // мы проверяем матрицу с нуля каждый раз на поиск самой дешевой связи компонентов
        {
            int min = INF;
            int nodeA = 0, nodeB = 0;
            for (int iterator = 0; iterator < SIZE; iterator++)
            {
                for (int innerIterator = 0; innerIterator < SIZE; innerIterator++)
                {
                    if (matrix[iterator][innerIterator] < min) // ищем самую дешевую связь для соеденения узла № iterator
                    {
                        if (checkDependencies(iterator) != checkDependencies(innerIterator)) {
                            min = matrix[iterator][innerIterator];
                            nodeA = iterator;
                            nodeB = innerIterator;
                        }
                    }
                }
            }

            edge(nodeA, nodeB);

            resultMatrix[nodeA][nodeB] = min;
            resultMatrix[nodeB][nodeA] = min;

            System.out.println("edge " + edges + ": (" + nodeA + ", " + nodeB + ") weight = " + min);
            minDistance += min;
            edges++;
        }


        // вывод на экран
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                System.out.print(resultMatrix[x][y] + " ");
            }
            System.out.println("");
        }

        System.out.println("Shortest distance to pass all nodes = " + minDistance);
    }
}
