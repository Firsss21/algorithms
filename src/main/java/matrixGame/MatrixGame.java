package matrixGame;

public class MatrixGame {
    private static final int GAMES_COUNTER = 100;
    private static final int[][] MATRIX = {
            {9,17},
            {12,8},
            };

    private float p1,p2,q1,q2, winningValue;
    private int[] min = new int[MATRIX.length];
    private int[] max = new int[MATRIX.length];
    public MatrixGame() {

        getChances();
        play();
    }

    private void getMinFromRow() {
        int min_value = Integer.MAX_VALUE;
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX.length; j++) {
                if (MATRIX[i][j] < min_value) {
                    min_value = MATRIX[i][j];
                }
            }
            min[i] = min_value;
            min_value = Integer.MAX_VALUE;
        }
    }
    private void getMaxFromColumn() {
        int max_value = Integer.MIN_VALUE;
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX.length; j++) {
                if (MATRIX[j][i] > max_value) {
                    max_value = MATRIX[j][i];
                }
            }
            max[i] = max_value;
            max_value = Integer.MIN_VALUE;
        }
    }

    private void getChances() {
        float temp,temp2;
        temp = ((float)-(MATRIX[1][0] - MATRIX[1][1])/(float)(MATRIX[0][0] -  MATRIX[0][1]));
        p1 = temp /(temp + 1);
        p2 = 1 - p1;

        temp2 = ((float)-(MATRIX[0][1] -  MATRIX[1][1])/(MATRIX[0][0] - MATRIX[1][0]));
        q1 = temp2 / (temp2 + 1);
        q2 = 1 - q1;
        winningValue = (MATRIX[0][1] * p1) + (MATRIX[1][1] * p2);
    }

    /*
    Генерируем для каждого игрока 10 чисел от [0;1] с тремя нулями.
    Выбор стратегий игроками будем осуществлять используя геометрическое опредленние вероятности
      */
    private void play() {
        int a_index, b_index;
        float winSum = 0f;
        float winAvgSum = 0f;
        int b1_times = 0, b2_times = 0;
        int a1_times = 0, a2_times = 0;
        for(int i = 1; i<GAMES_COUNTER+1;i++) {
            float a_rand = (float) Math.random();
            float b_rand = (float) Math.random();

            if (a_rand < p1) {
                a1_times++;
                a_index = 0;
            } else {
                a2_times++;
                a_index = 1;
            }

            if (b_rand < q1) {
                b1_times++;
                b_index = 0;
            } else {
                b2_times++;
                b_index = 1;
            }

            winSum += MATRIX[a_index][b_index];
            winAvgSum = winSum / i;
            System.out.println(i+". A num = " + a_rand + ", B num = " + b_rand + ", Strategy A"+(a_index+1) + ", B" + (b_index+1) + ", win = " + MATRIX[a_index][b_index] + ", WinSum = " + winSum + ", WinAvgSum = " + winAvgSum);
        }

        float generatedA1_chance = (float) a1_times/(a1_times+a2_times);
        float generatedA2_chance = (float) a2_times/(a1_times+a2_times);
        float generatedB1_chance = (float) b1_times/(b1_times+b2_times);
        float generatedB2_chance = (float) b2_times/(b1_times+b2_times);

        System.out.println("Predicted value = " + winningValue + ", generated value = " + winAvgSum);
        System.out.println("Predicted a1 chance = " + p1 + ", generated chance = " + generatedA1_chance);
        System.out.println("Predicted a2 chance = " + p2 + ", generated chance = " + generatedA2_chance);
        System.out.println("Predicted b1 chance = " + q1 + ", generated chance = " + generatedB1_chance);
        System.out.println("Predicted b2 chance = " + q2 + ", generated chance = " + generatedB2_chance);
        System.out.println("A1 times = " + a1_times + ", B1 times = " + b1_times + ", A2 times = " + a2_times + ", B2 times = " + b2_times);
    }
}
