package Matrix;

import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[100][50];

        for(int i = 0; i < matrix.length; i++){
            System.out.println("");
            for(int j = 0; j < matrix[i].length; j++){
                int rndI = (int)Math.round((Math.random() * 30) - 15);
                int rndJ = (int)Math.round((Math.random()* 30) - 15);
                matrix[i][j] = rndI - rndJ;
                System.out.print(matrix[i][j] + " ");
            }
        }

        System.out.println(" ");
        System.out.println("Вывод массива для проверки" );

        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);

        System.out.println(" ");
        System.out.println("Вывод массива отсортированного" );

        matrixBubbleSort(matrix);

        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);

    }

        public static int[][] matrixBubbleSort(int[][] sortMatrix) {
            int swap;
            for (int i = 0; i < sortMatrix.length; i++) {
                for (int j = 0; j < sortMatrix[i].length; j++) {

                    for (int l = 0; l < sortMatrix[i].length; l++) {
                        if (sortMatrix[i][j] <= sortMatrix[i][l]) {
                            swap = sortMatrix[i][j];
                            sortMatrix[i][j] = sortMatrix[i][l];
                            sortMatrix[i][l] = swap;
                        }
                    }
                }

            }
            return sortMatrix;
        }
    }


