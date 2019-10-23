import java.util.Random;

public class Main {

    public static int visited;

    public static int[][] createMatrix(){

        int matrix[][] = new int[8][8];

        for (int row = 0; row < 8; row++){
            for (int column = 0; column < 8; column++){
                matrix[row][column] = 0;
            }
        }

        return matrix;

    }


    public static int[][] cloneMatrix(int matrix[][]){

        int i, j;
        int matrixCloned[][] = new int[8][8];

        for (i = 0; i < 8; i++){
            for (j = 0; j < 8; j++){
                matrixCloned[i][j] = matrix[i][j];
            }
        }

        return matrixCloned;

    }

    public static int randNum(){

        int coord;
        int SEED = 8;
        Random generator = new Random();
        coord = generator.nextInt(SEED);

        return coord;

    }

    public static void printMatrix(int matrix[][]) {

        for (int row = 0; row < 8; row++){
            for (int column = 0; column < 8; column++){
                System.out.print(matrix[row][column] + " /");
            }
            System.out.println();
        }

    }

    public static void markBoard(int x, int y, int turn, int[][] matrix) {

        matrix[x][y] = turn;
        visited++;

    }

    public static boolean checkNotVisited(int x, int y, int[][]matrix) {

        return matrix[x][y] == 0;

    }


    public static boolean checkBoard(int x, int y, int[][]matrix) {

        return x < 8 && x >= 0 && y < 8 && y >= 0;

    }

    public static boolean visitedAll(int[][] matrix) {

        boolean visited = true;

        for (int i = 0; i < 8 && visited == true ; i++){
            for (int j = 0; j < 8 && visited == true; j++){
                if (matrix[i][j] == 0) {
                    visited = false;
                }
            }
        }

        return visited;

    }

    public static void gameTurn(int x, int y, int[][]matriz, int turn, long inicialTime){

        int matrixClone[][] = cloneMatrix(matriz);
        markBoard(x, y, turn, matrixClone);

        if (visitedAll(matrixClone)){
            System.out.println("Visited everything! :)");
            System.out.println("Total visited:  " + turn );
            printMatrix(matrixClone);

            long finalTime = System.currentTimeMillis();
            System.out.println( (finalTime - inicialTime) + " milisecs" );
            System.exit(0);
        }

        turn++;

        if (checkBoard(x+2, y+1, matrixClone) && checkNotVisited(x+2, y+1, matrixClone)){
            gameTurn(x+2, y+1, matrixClone, turn, inicialTime);
        }

        if (checkBoard(x+1, y+2, matrixClone) && checkNotVisited(x+1, y+2, matrixClone)){
            gameTurn(x+1, y+2, matrixClone, turn, inicialTime);
        }

        if (checkBoard(x-1, y+2, matrixClone) && checkNotVisited(x-1, y+2, matrixClone)){
            gameTurn(x-1, y+2, matrixClone, turn, inicialTime);
        }

        if (checkBoard(x-2, y+1, matrixClone) && checkNotVisited(x-2, y+1, matrixClone)){
            gameTurn(x-2, y+1, matrixClone, turn, inicialTime);
        }

        if (checkBoard(x-2, y-1, matrixClone) && checkNotVisited(x-2, y-1, matrixClone)){
            gameTurn(x-2, y-1, matrixClone, turn, inicialTime);
        }

        if (checkBoard(x-1, y-2, matrixClone) && checkNotVisited(x-1, y-2, matrixClone)){
            gameTurn(x-1, y-2, matrixClone, turn, inicialTime);
        }

        if (checkBoard(x+1, y-2, matrixClone) && checkNotVisited(x+1, y-2, matrixClone)){
            gameTurn(x+1, y-2, matrixClone, turn, inicialTime);
        }

        if (checkBoard(x+2, y-1, matrixClone) && checkNotVisited(x+2, y-1, matrixClone)){
            gameTurn(x+2, y-1, matrixClone, turn, inicialTime);
        }
    }

    public static void main(String[] args) {

        visited = 0;
        int matriz[][] = createMatrix();
        int x = randNum(), y = randNum();

        long startTime = System.currentTimeMillis();

        gameTurn(x, y, matriz, 1, startTime);

    }

}
