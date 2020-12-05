package dualSimplexMethod;

public class DualSimplexMethod {
    private static final float a = 33, b = 20, c = 12,
            a1 = 5, b1 = 2, c1 = 5,
            a2 = 4, b2 = 5, c2 = 1,
            p1 = 8, p2 = 4;
    public DualSimplexMethod() {
        printMatrix();
        Solve();
    }

    /*
    Создадим матрицу из коэффициентов неравенств для всех неравенств
    Так же для построеня первого опорного плана систему неравенств приведем к системе уравнений,
    путем введения доп переменных (ереход к канонической форме)
    Для первого неравенства х3, 2 х4, 3 х5
     */

    private Fraction[][] matrix = {{new Fraction((int) -a), new Fraction((int) -a1), new Fraction((int) -a2), new Fraction((int) 1),new Fraction((int) 0),new Fraction((int) -0)},
            {new Fraction((int) -b),new Fraction((int) -b1),new Fraction((int) -b2),new Fraction((int) 0),new Fraction((int) 1),new Fraction((int) 0)},
            {new Fraction((int) -c),new Fraction((int) -c1),new Fraction((int) -c2),new Fraction((int) 0),new Fraction((int) 0),new Fraction((int) 1)},
            {new Fraction((int) 0),new Fraction((int) -p1),new Fraction((int) -p2),new Fraction((int) 0),new Fraction((int) 0),new Fraction((int) 0)}};
    private int[] basisX = {3,4,5};
    private Fraction[] solveArr;
    /*
    Базисные переменные это переменные, которые входят только в одно уравнение системы ограничений и притом с единичным коэффициентом.
    Решим систему уравнений относительно базисных переменных: x3, x4, x5
     */
    private void printMatrix() {
        // Принтим матрицу на экран.
        System.out.println("__________________________________________");
        System.out.println("Базис     B    x1    x2    x3    x4    x5");
        for (int i = 0; i < 4; i++){
            if (i < 3) System.out.print("x" + basisX[i]+"   ");
            else System.out.print("F(X0)");

            for (int j=0; j < 6; j++) {

                System.out.printf("%6S", matrix[i][j].toString());
            }
            System.out.println("");
        }
        System.out.println("__________________________________________");
        solveArr = new Fraction[]{new Fraction(0), new Fraction(0), new Fraction(0), new Fraction(0), new Fraction(0)};
        for(int i = 0; i < basisX.length; i++) {
            solveArr[basisX[i]-1] = matrix[i][0];
        }
        System.out.print("X("+solveArr[0].toString()+"; "+solveArr[1].toString()+"; "+solveArr[2].toString()+"; "+solveArr[3].toString()+"; "+solveArr[4].toString()+") \n");
    }

    private void Solve() {
        Fraction fraction = new Fraction();
        float inf = Integer.MAX_VALUE;
        float currentAbsHighestvalue = inf;
        int rowIndex = 99999;
       while (true) {


           // Делаем проверку на выход из цикла.
//           Fraction row = new Fraction(0);
//           Fraction column = new Fraction(0);
//           for (int i = 0; i < matrix.length-1; i++) {
//               column = fraction.addition(column,matrix[i][0]);
//           }
//           for (int i = 1; i < matrix.length + 2; i++) {
//               row = fraction.addition(row,matrix[3][i]);
//           }
           boolean optimalniy_plan = true;
           for (int i = 0; i < matrix.length-1; i++) {
               if (matrix[i][0].floatValue() < 0) optimalniy_plan = false;
           }

//           if ((row.floatValue() >= 0) && (column.floatValue() >= 0)) {
            if (optimalniy_plan == true) {
               float x1 = 0,x2 = 0;
               for(int i = 0; i < basisX.length; i++) {
                   if (basisX[i] == 1) x1 = matrix[i][0].floatValue();
                   if (basisX[i] == 2) x2 = matrix[i][0].floatValue();
               }
               System.out.println("DONE");
               System.out.println("x1 = " + x1 + ", x2 = " + x2);
               System.out.println("p1 = " + p1 + ", p2 = " + p2);
               System.out.println("F(x) = p1 * x1 + p2 * x2 = " + ((x1 * p1) + (x2 * p2)));
//               System.out.println("FOUND SAME RESULT. MATRIX[3][0] = " + matrix[3][0].toString());
               break;
           }

             /* Выберем минимальный элемент из суммы
             * Определяем новую свободную переменную  */
            for (int i = 0; i < 4; i++) {
                if (matrix[i][0].floatValue() < currentAbsHighestvalue) {
                    currentAbsHighestvalue = matrix[i][0].floatValue();
                    rowIndex = i;
                }
            }
            // Определяем новую базисную переменную.
            float minDiv = 9999999; int columnIndex = 0;
            for(int i = 1; i < 6 ;i++)
            {
                if(matrix[rowIndex][i].floatValue() < 0f) {
                    if(Math.abs(fraction.division(matrix[3][i],matrix[rowIndex][i]).floatValue()) < minDiv) {
                        minDiv = Math.abs(fraction.division(matrix[3][i],matrix[rowIndex][i]).floatValue());
                        columnIndex = i;
                    }
                }
            }

            // Для остальных элементов матрицы построим прямоугольники
            // с вершинами в этих элементах a(ij)
            // и выделенном элементе a(11)
            // и найдем новые элементы по правилу
            // a(ij) - ( (a(1j) * (a(i1) ) / ( a(11) )
           // Преобразовываем симплекс таблицы с помощью метода Жордана - Гаусса
//           Метод прямоугольников
            for (int i = 0; i < 4; i++) {
                if((rowIndex) != i){ // строка для пропуска строки к изменению
                    for (int j = 0; j < 6; j++) {
                        if (j!=columnIndex)
                            matrix[i][j] = fraction.subtraction(matrix[i][j], fraction.division(fraction.multiplication(matrix[rowIndex][j], matrix[i][columnIndex]), matrix[rowIndex][columnIndex]));
                    }
                }
            }
            // Делим строку на себя
            Fraction matrixFirst = matrix[rowIndex][columnIndex];
            for (int i = 0; i < 6; i++)
                matrix[rowIndex][i] = fraction.division(matrix[rowIndex][i] , matrixFirst);

            // Столбцу задаем нули, кроме того, который выбрали.
            for (int i = 0; i < 4; i++) {
                if (rowIndex != i)
                    matrix[i][columnIndex] = new Fraction(0);
                else matrix[i][columnIndex] = new Fraction(1);
            }
            minDiv = inf;
            currentAbsHighestvalue = inf;

            basisX[rowIndex] = columnIndex; // Запоминаем смены
           System.out.println("Меняем слева x" + (rowIndex+3)  + " на x" + (columnIndex));

           printMatrix();

        }

    }

}
