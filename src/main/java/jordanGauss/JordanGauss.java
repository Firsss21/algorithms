package jordanGauss;

import java.util.Arrays;

/*
    Программа, решающая систему линейных уравнений
    методом Жордана-Гаусса с выбором главного элемента в таблице

 */
public class JordanGauss {
    private static final int MATRIX_SIZE = 5;
    private float[][] Matrix;

    public JordanGauss() {
        initMatrix();
        jordanGaussSolve();
    }

    private void initMatrix() {

//        Matrix = new float[][] {{-8,10,6,2,3,119},
//                {6,-4,-3,-10,-9,-58},
//                {-1,6,6,8,-2,98},
//                {-5,9,7,-9,7,75},
//                {-9,7,6,-2,-2,115}};

        Matrix = new float[][]{{-6, -5, -1, 9, -10,28},
                {-11,1,4,6,-11,24},
                {-7,7,9,9,4,52},
                {-6,-1,-10,14,-6,161},
                {-2,-15,6,4,5,-42}};

//        Matrix = new float[][] {{1, -7,4,-3,-3,-12},
//                {-1,-5,7,-1,4,30},
//                {-6,7,7,5,7,49},
//                {-5,-3,-6,-3,8,-7},
//                {-5,-5,-2,-3,-6,-67}};

        System.out.println(Arrays.deepToString(Matrix));

    }

    private void jordanGaussSolve() {

        float negativeInf = -Integer.MAX_VALUE;
        float currentAbsHighestvalue = negativeInf;
        int currentAbsHighestIndex = -999;


        for (int iterationCounter = 0; iterationCounter < MATRIX_SIZE; iterationCounter++) {
             /*
        Выберем максимальный по модулю элемент и меняем строки местами
         */
            for (int i = iterationCounter; i < MATRIX_SIZE; i++) {
                if (Math.abs(Matrix[i][iterationCounter]) > currentAbsHighestvalue) {
                    currentAbsHighestvalue = Math.abs(Matrix[i][iterationCounter]);
                    currentAbsHighestIndex = i;
                }
            }


            // swap row
            float[] tempRow = Matrix[iterationCounter];
            Matrix[iterationCounter] = Matrix[currentAbsHighestIndex];
            Matrix[currentAbsHighestIndex] = tempRow;


            // Для остальных элементов матрицы построим прямоугольники
            // с вершинами в этих элементах a(ij)
            // и выделенном элементе a(11)
            // и найдем новые элементы по правилу
            // a(ij) - ( (a(1j) * (a(i1) ) / ( a(11) )

            for (int i = 0; i < MATRIX_SIZE; i++) {
                if((iterationCounter) != i){ // строка для пропуска строки к изменению
                    for (int j = iterationCounter + 1; j < MATRIX_SIZE+1; j++) {
                        Matrix[i][j] = Matrix[i][j] - ((Matrix[iterationCounter][j] * Matrix[i][iterationCounter]) / Matrix[iterationCounter][iterationCounter]);
                    }
                }
            }


            // Делим <номеритерации> строку на a_номеритерации_номеритерации Matrix[номеритерации][номеритерации].
            float matrixFirst = Matrix[iterationCounter][iterationCounter];
            for (int i = 0; i < MATRIX_SIZE+1; i++)
                Matrix[iterationCounter][i] /= matrixFirst;

            // <номеритерации> столбец все нули, кроме первого
            for (int i = 0; i < MATRIX_SIZE; i++) {
                if (iterationCounter != i)
                    Matrix[i][iterationCounter] = 0;
                else Matrix[i][iterationCounter] = 1;
            }

                System.out.println("___________________");
                System.out.println("Iteration number = " + iterationCounter);
                for (int i = 0; i < MATRIX_SIZE; i++){
                    for (int j=0; j < MATRIX_SIZE+1; j++) {
                        System.out.print(" ");
                        System.out.print(Matrix[i][j]);
                    }
                    System.out.println("");
                }
                System.out.println("___________________");

        }
        System.out.println("Расхождения на 0.000005 связаны с вычислением на float без оптимизации");
    }



}
