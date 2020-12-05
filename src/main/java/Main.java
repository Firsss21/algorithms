//package algorithms;

import algorithms.*;
import arrowHurwicz.ArrowHurwicz;
import arrowHurwicz.ArrowHurwiczEx;
import dualSimplexMethod.DualSimplexMethod;
import dualSimplexMethod.DualSimplexMethodWithoutFractions;
import dualSimplexMethod.ODZFinder;
import jordanGauss.JordanGauss;
import matrixGame.MatrixGame;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arrayThatWantsToSort;
        int[] sortedArray;
        arrayThatWantsToSort = new int[]{6,4,31,14,7,2};
        printMenu();

        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        while (selection != 0) {
            switch (selection) {
                case 1:
                    SelectSort selectSort = new SelectSort();
                    sortedArray = selectSort.sort(arrayThatWantsToSort);

                    System.out.println(Arrays.toString(arrayThatWantsToSort));
                    System.out.println(Arrays.toString(sortedArray));
                    break;
                case 2:
                    BubbleSort bubbleSort = new BubbleSort();
                    sortedArray = bubbleSort.sort(arrayThatWantsToSort);

                    System.out.println(Arrays.toString(arrayThatWantsToSort));
                    System.out.println(Arrays.toString(sortedArray));
                    break;
                case 3:
                    Floyd floyd = new Floyd();
                    break;
                case 4:
                    Knapsack knapsack = new Knapsack();
                    break;
                case 5:
                    Dijkstra dijkstra = new Dijkstra();

                    break;
                case 6:
//                    System.out.println(Arrays.toString(arrayThatWantsToSort));
//                    MergeSort mergeSort = new MergeSort();
//                    mergeSort.sortUnsorted(arrayThatWantsToSort, 0, 8);
                  MergeWithoutRecursion merge = new MergeWithoutRecursion();
                    break;
                case 7:
                    Kruskal kruskal = new Kruskal();
                    break;
                case 8:
                    String expression = "([{}])";
                    BalancedBrackets balancedBrackets = new BalancedBrackets(expression);break;
                case 9:
                    break;
                default:
                    break;
            }
            sc.nextInt();
            printMenu();
            System.out.print("Enter next menu item  ");
            selection = sc.nextInt();
        }

         /*
    Программа, решающая систему линейных уравнений
    методом Жордана-Гаусса с выбором главного элемента в таблице

    Программа, разыгрывающая сотню матричных игр

    Программа, решающая задачи нелинейного программирования методом Эрроу-Гурвица.

    Программа, ищущая точки, входящие в одз.

    Программа, решающая задачи линейного программирования с помощью двойственного симплекс-метода, с применением класса простых дробей.

     */
//        JordanGauss jordanGauss = new JordanGauss();
//        MatrixGame matrixGame = new MatrixGame();
//        ArrowHurwicz arrowHurwicz = new ArrowHurwicz();
//        ArrowHurwiczEx arrowHurwiczEx = new ArrowHurwiczEx();
//        DualSimplexMethod dualSimplexMethod = new DualSimplexMethod();
//        DualSimplexMethodWithoutFractions dualSimplexMethodWithoutFractions = new DualSimplexMethodWithoutFractions();
//        ODZFinder odzFinder = new ODZFinder();


    }

    private static void printMenu() {
        System.out.println("Select one of menu items");
        System.out.println("_________________________");
        System.out.println("1. Select sort algorithm");
        System.out.println("2. Bubble sort algorithm");
        System.out.println("3. Floyd algorithm");
        System.out.println("4. Knapsack algorithm");
        System.out.println("5. Dijkstra algorithm");
        System.out.println("6. Merge sort algorithm");
        System.out.println("7. Kruskal algorithm");
        System.out.println("8. Brackets balance algorithm");
        System.out.println("For exit enter 0");
        System.out.println("_________________________");
    }

}
