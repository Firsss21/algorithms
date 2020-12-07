package dualSimplexMethod;

public class ODZFinder {
    /*


    Решить исходную задачу графически и отметить на чертеже точки,
    соответствующие симплексным таблицам, полученным при выполнении
    программы из п.1 (этот этап можно запрограммировать).
     */

    private static final float a = 33, b = 20, c = 12,
    a1 = 5, b1 = 2, c1 = 5,
    a2 = 4, b2 = 5, c2 = 1,
    p1 = 8, p2 = 4;

    public class Point{
        float x;
        float y;
        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    public class ODZ {
        // плоскость верх или низ
        // первый поинт при нуль один
        // второй поинт при нуль два
        Point point_one;
        Point point_two;
        boolean plane; // определяем полуплоскость: true, если больше нуля, false, если меньше нуля
        public ODZ(Point point_one, Point point_two, Boolean plane) {
            this.point_one = point_one;
            this.point_two = point_two;
            this.plane = plane;
        }

        @Override
        public String toString() {
            String str = "Point1: x1=" + point_one.x + ", x2="+point_one.y+". Point2: x1="+point_two.x+",x2="+point_two.y ;
            return str;
        }
    }

    private void buildOdzForInequality() {
        // Находим одз для всех неравенств и определяем полуплоскости
        ODZ firstIneq = new ODZ(new Point(0, (a/a2)), new Point(a/a1,0),  (((a1*0)+(a2*0)-a) >= 0) ? true : false);
        ODZ secondIneq = new ODZ(new Point(0, (b/b2)), new Point(b/b1,0),  (((b1*0)+(b2*0)-b) >= 0) ? true : false);
        ODZ thirdIneq = new ODZ(new Point(0, (c/c2)), new Point(c/c1,0),  (((c1*0)+(c2*0)-c) <= 0) ? true : false);
        System.out.println(firstIneq.toString());
        System.out.println(secondIneq.toString());
        System.out.println(thirdIneq.toString());
    }
    /*
    F = 8x_1 + 4x_2 -> min
    { 5x_1 + 4x_2 <= 33
    { 2x_1 + 5x_2 <= 20
    { 5x+1 + x_2 <= 12
    { x_1, x_2 >= 0

    Построим ОДЗ(область допустимых решений), т.е решим графически систему неравенств.

    Для 5х_1 + 4х_2 <= 33
    x_1 = 0, x_2 = 8.25
    x_1 = 6,6, x_2 = 0
    Определим полуплоскость, задаваемую неравенством, выбрав точку 0, 0 определим знак неравенства в полуплоскости.
    5 * 0 + 4 * 0 - 33 <= 0

    Для 2x_1 + 5x_2 <= 20
    x_1 = 0, x_2 = 4
    x_1 = 10, x_2 = 0
    Определим полуплоскость, задаваемую неравенством, выбрав точку 0, 0 определим знак неравенства в полуплоскости.
    2 * 0 + 5 * 0 - 20 <= 0
    if ((a1*0 + a2*0 - a) >= 0) plane = true else plane = false
    (((a1*0)+(a2*0)-a) >= 0) ? true : false;

    Для 5x_1 + x_2 <= 12
    x_1 = 0, x_2 = 12
    x_1 = 2.4, x_2 = 0
    Определим полуплоскость, задаваемую неравенством, выбрав точку 0, 0 определим знак неравенства в полуплоскости.
    5 * 0 + 1 * 0 - 12 <= 0

    т.е для каждого неравенства полуплоскость ниже прямой.


    Шаг №2. Границы области допустимых решений.
    Пересечением полуплоскостей будет являться область, координаты точек
    которого удовлетворяют условию неравенствам системы ограничений задачи.

    Шаг №3. Рассмотрим целевую функцию задачи F = 8x1+4x2 → min.
    Построим прямую, отвечающую значению функции F = 8x1+4x2 = 0.
     Вектор-градиент, составленный из коэффициентов целевой функции,
      указывает направление максимизации F(X). Начало вектора – точка (0; 0),
       конец – точка (8;4). Будем двигать эту прямую параллельным образом.
        Поскольку нас интересует минимальное решение,
         поэтому двигаем прямую до первого касания обозначенной области.
          На графике эта прямая обозначена пунктирной линией.


    Прямая F(x) = const пересекает область в точке A.
     Так как точка A получена в результате пересечения прямых (4) и (5),
      то ее координаты удовлетворяют уравнениям этих прямых:
        x1=0
        x2=0

        Ответ:
    Решив систему уравнений, получим: x1 = 0, x2 = 0
    Откуда найдем минимальное значение целевой функции:
    F(X) = 8*0 + 4*0 = 0
     */


    /*5
    Программируем поиск нулей и определение полуплоскостей, задаваемые неравенством.

    Поиск пересекающихся векторов.

    Отлично за курсовую работу ставится только в случае
        реализации класса простых дробей и успешной защите работы.

     */

    /*
    Выделив область решения каждого неравенства системы ограничений, получим многоугольник допустимых решений ЗЛП.
    Построим основную прямую L = 0, то есть F = 8x1+4x2 = 0, проходящую через начало координат O(0,0) перпендикулярно вектору c(8;4).
    На рисунке видно, что областью допустимых решений является многоугольник ABCD.
        Перемещая прямую L = 0 в направлении вектора c(8;4), находим минимальную точку A, в которой пересекаются прямые L4 и L5:
        x1=0
        x2=0
        Решив систему уравнений, получим: x1 = 0, x2 = 0
    Откуда найдем минимальное значение целевой функции:
    F(X) = 8*0 + 4*0 = 0
     */
    // Поиск минимального значения целевой функции
    private float calcFunction(float x1, float x2) {
        return (p1 * x1) + (p2 * x2);
    }

    public ODZFinder() {
        System.out.println("ODZ");

        buildOdzForInequality();
        float result = calcFunction(0, 0);
        System.out.println(result);
    }
}