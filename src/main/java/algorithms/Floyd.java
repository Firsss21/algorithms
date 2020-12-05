package algorithms;

import java.util.Arrays;

public class Floyd {
//    Алгоритм поиска кратчайшего пути между узлами.
    /*
    for вершины в A
        for вершины в B
            if W[A,B] != infinity
                for вершины в C
                    if W[A,C] > W[A,B]+W[B,C]
                    W[A,C] = W[A,B]+W[B,C]
                    H[A,C] = H [A,B]
     */
    private static final int NODES_QUANTITY = 5;
    private static final int INF = Integer.MAX_VALUE;

    private int[][] weight_matrix = {{-1,10,-1,-1,-1},{-1,-1,12,-1,8},{-1,-1,-1,8,-1},{-1,6,8,-1,3},{-1,-1,-1,3,-1}};
    private int[][] history_matrix = {{0,2,0,0,0},{0,0,3,0,5},{0,0,0,4,0}, {0,2,3,0,5}, {0,0,0,4,0}};

    public Floyd() {
        printMatrix();
        algorithm();
        printMatrix();
    }

    private void algorithm() {
       for (int x = 0; x < NODES_QUANTITY; x++) {
           for (int y = 0; y < NODES_QUANTITY; y++) {
               if (weight_matrix[x][y] != -1) {
                   for(int z = 0; z < NODES_QUANTITY; z++) {

                        if (weight_matrix[x][z] > (weight_matrix[x][y] + weight_matrix[y][z])) {
                            weight_matrix[x][z] = (weight_matrix[x][y] + weight_matrix[y][z]);
                            history_matrix[x][z] = history_matrix[x][y];
                            System.out.printf("weight_matrix[%d][%d] = weight_matrix[%d][%d] + weight_matrix[%d][%d] \n",x,z,x,y,y,z);
                        }
                   }
               }
           }
       }
    }

    private void printMatrix() {
        System.out.println("weight matrix");
        for (int x = 0; x < NODES_QUANTITY; x++) {
            for (int y = 0; y < NODES_QUANTITY; y++){System.out.printf("%3d", weight_matrix[x][y]);}
            System.out.println("");
        }

        System.out.println("history matrix");
        for (int x = 0; x < NODES_QUANTITY; x++) {
            for (int y = 0; y < NODES_QUANTITY; y++){System.out.printf("%3d", history_matrix[x][y]);}
            System.out.println("");
        }

    }

}
