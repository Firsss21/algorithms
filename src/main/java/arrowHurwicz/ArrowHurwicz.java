package arrowHurwicz;

public class ArrowHurwicz {
    /*
    Задача о нелинейной прогаммировании градиентными методами
    Программа, решающая задачи нелинейного программирования методом Эрроу-Гурвица с точностью 0.0001
    В качестве лямбды значения 0.001

     */

    /*

    f(x_1,x_2)=-x_1 ^2 - x_2 ^2 -> max;
    {(x_1 - 7 ) ^ 2 + (x_2 - 7 ) ^2 <= 18
    {x_1;x_2 >= 0

    Возьмем любое допустимое решение системы ограничений в качестве начального приближения.
       X0 = (5;6)
       f(X0) = -5^2 -6^2 = -61

    2. В качестве начального шага вычислений выберем лямбда = 0.1 а(0)=0

    3. Преобразуем неравенство к виду 18 - (x_1 - 7 ) ^ 2 + (x_2 - 7 ) ^2
        введем g(x_1;x_2) = 18 - (x_1 - 7 ) ^ 2 + (x_2 - 7 ) ^2
        Определим частные производные от функций f и g;
        f'(x_1)=-2x_1;
        f'(x_2)=-2x_2;
        g'(x_1)=-2x_1+14;
        g'(x_2)=-2x_2+14;

    Далее запускаем итерационный процесс, координаты следующей точки будем находить по формулам
     */

    // Если точка в ОДЗ(проверка на одз), то проверяем достигнутую точность со значение функции в точке, которая последней попадала в область

    public ArrowHurwicz() {
        System.out.println("ArrowHurwicz");
        algorithm();
    }
    private float x1;
    private float x2;
    static private final float LAMBDA = 0.001f;
    private float a_prev = 0f;
    private float a;
    private float g_function(float x1, float x2) {
        return 16 - ((float)Math.pow((x1 - 6),2)) - ((float)Math.pow((x2 - 4),2));
    }

    private float g_function_derivative_x1(float x1) {
        return -2 * (x1-6);
    }
    private float g_function_derivative_x2(float x2) {
        return 8 - 2 * x2;
    }

    private float f_from_x_function(float x1,float x2) {
        return (float) ((-5 * x1) - (4 * Math.pow((x2-6),2)));
    }

    private float f_from_x1_function_derivative (float x1) {
        return -5;
    }
    private float f_from_x2_function_derivative (float x2) {
        return -8 * (x2 - 6);
    }

    private float getNextPointX1(float x) {
        return Math.max(0, x + (LAMBDA * (f_from_x1_function_derivative(x)  + (a * g_function_derivative_x1(x)))));
    }
    private float getNextPointX2(float x) {
        return Math.max(0, x + (LAMBDA * (f_from_x2_function_derivative(x)  + (a * g_function_derivative_x2(x)))));
    }

    private void algorithm () {
        this.x1 = 5;
        this.x2 = 5;
        float next_x2;
        float next_x1;
        float prev_accuracy_X = f_from_x_function(x1,x2);
        int iteration_counter = 0;

        while (true) {
            iteration_counter++;
            // если эта точка принадлежит одз
            a_prev = a;
            if (g_function(x1, x2) > 0) {
                a = 0;
            } else {

                a = a_prev - (LAMBDA * (g_function(x1, x2)));
            }
            next_x1 = getNextPointX1(x1);
            next_x2 = getNextPointX2(x2);

            System.out.println(iteration_counter + ": next_x1 = "+next_x1+", next_x2 = " +next_x2);

            if   (g_function(next_x1,next_x2) > 0) {

                if  ((Math.abs(f_from_x_function(next_x1,next_x2) - prev_accuracy_X)) < 0.0001) {

                    System.out.println("COMPLETED");
                    System.out.println("Iterations: " + iteration_counter);
                    System.out.println("x_1 = " + next_x1);
                    System.out.println("x_2 = " + next_x2);
                    System.out.println("Accuracy = " + Math.abs(f_from_x_function(next_x1,next_x2) - prev_accuracy_X));
                    System.out.println("f(x1,x2) = " + f_from_x_function(next_x1,next_x2));
                    break;
                }
                prev_accuracy_X = f_from_x_function(next_x1,next_x2);
            }

            x1 = next_x1;
            x2 = next_x2;


        }
        System.out.println("iteration_counter = " + iteration_counter );
    }

}
