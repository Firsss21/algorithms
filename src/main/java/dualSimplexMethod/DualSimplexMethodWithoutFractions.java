package dualSimplexMethod;

public class DualSimplexMethodWithoutFractions {
    private static final float a = 33, b = 20, c = 12,
            a1 = 5, b1 = 2, c1 = 5,
            a2 = 4, b2 = 5, c2 = 1,
            p1 = 8, p2 = 4;

//        private static final float a = 10, b = 30, c = 42,
//        a1 = 2, b1 = 3, c1 = 3,
//        a2 = 1, b2 = 4, c2 = 8,
//        p1 = 10, p2 = 3;
    public DualSimplexMethodWithoutFractions() {
        Solve();
    }
    /*
    Создадим матрицу из коэффициентов неравенств для всех неравенств
    Так же для построеня первого опорного плана систему неравенств приведем к системе уравнений,
    путем введения доп переменных (ереход к канонической форме)
    Для первого неравенства х3, 2 х4, 3 х5
     */
    private float[][] MATRIX = {{-a,-a1,-a2,1,0,0},
            {-b,-b1,-b2,0,1,0},
            {-c,-c1,-c2,0,0,1},
            {0,-p1,-p2,0,0,0}};

    private int[] basisX = {3,4,5};
    /*
    Базисные переменные это переменные, которые входят только в одно уравнение системы ограничений и притом с единичным коэффициентом.
    Решим систему уравнений относительно базисных переменных: x3, x4, x5
     */


    private void Solve() {

        float inf = Integer.MAX_VALUE;
        float currentAbsHighestvalue = inf;
        int currentAbsHighestIndex = 99999;
        int iterations =0 ;
        while (iterations != 3) {
            iterations++;
            /* Выберем минимальный элемент из суммы
             * Определяем новую свободную переменную  */
            for (int i = 0; i < 4; i++) {
                if (MATRIX[i][0] < currentAbsHighestvalue) {
                    currentAbsHighestvalue = MATRIX[i][0];
                    currentAbsHighestIndex = i;
                }
            }
            // Определяем новую базисную переменную.
            float minDiv = 9999999; int minDivIndex = 0;
            for(int i = 1; i < 6 ;i++)
            {
                if(MATRIX[currentAbsHighestIndex][i] < 0) {
                    if(Math.abs(MATRIX[3][i]/MATRIX[currentAbsHighestIndex][i]) < minDiv) {
                        minDiv = Math.abs(MATRIX[3][i]/MATRIX[currentAbsHighestIndex][i]);
                        minDivIndex = i;
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
                if((currentAbsHighestIndex) != i){ // строка для пропуска строки к изменению
                    for (int j = 0; j < 6; j++) {

                        if (j != minDivIndex)
                        MATRIX[i][j] = MATRIX[i][j] - ((MATRIX[currentAbsHighestIndex][j] * MATRIX[i][minDivIndex]) / MATRIX[currentAbsHighestIndex][minDivIndex]);

                    }
                }
            }
            // Делим строку на себя
            float matrixFirst = MATRIX[currentAbsHighestIndex][minDivIndex];
            for (int i = 0; i < 6; i++)
                MATRIX[currentAbsHighestIndex][i] /= matrixFirst;

            // Столбцу задаем нули, кроме того, который выбрали.
            for (int i = 0; i < 4; i++) {
                if (currentAbsHighestIndex != i)
                    MATRIX[i][minDivIndex] = 0;
                else MATRIX[i][minDivIndex] = 1;
            }
            minDiv = inf;
            currentAbsHighestvalue = inf;

            // Принтим матрицу на экран.
            System.out.println("___________________");
            for (int i = 0; i < 4; i++){
                for (int j=0; j < 6; j++) {
                    System.out.print(" ");
                    System.out.printf("%10f", MATRIX[i][j]);
                }
                System.out.println("");
            }
            System.out.println("___________________");

            basisX[currentAbsHighestIndex] = minDivIndex; // Запоминаем смены
            System.out.println("Меняем слева x" + (currentAbsHighestIndex+3)  + " на x" + (minDivIndex));

            // Делаем проверку на выход из цикла.
            float row = 0, column = 0;
            for (int i = 0; i < MATRIX.length-1; i++) {
                column += MATRIX[i][0];
            }
            for (int i = 1; i < MATRIX.length+2; i++) {
                row += MATRIX[3][i];
            }

            if ((row >= 0) && (column >= 0)) {

                float x1 = 0,x2 = 0;
                for(int i = 0; i < basisX.length; i++) {
                    if (basisX[i] == 1) x1 = MATRIX[i][0];
                    if (basisX[i] == 2) x2 = MATRIX[i][0];
                }

                System.out.println("DONE");
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
                System.out.println("p1 = " + p1 + ", p2 = " + p2);
                System.out.println("F(x) = p1 * x1 + p2 * x2 = " + ((x1 * p2) + (x2 * p1)));
                System.out.println("FOUND SAME RESULT. MATRIX[3][0] = " + MATRIX[3][0]);
                break;
            }

        }

    }

    public static void main(String[] args) {
        DualSimplexMethodWithoutFractions dualSimplexMethodWithoutFractions = new DualSimplexMethodWithoutFractions();
    }

}
