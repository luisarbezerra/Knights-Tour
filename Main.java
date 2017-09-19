import java.util.Random;

public class Main {

    public static int visitadas;

    public static int[][] criaMatriz(){

        int i, j;
        int matriz[][] = new int[8][8];

        for (i = 0; i < 8; i++){
            for (j = 0; j < 8; j++){
                matriz[i][j] = 0;
            }
        }

        return matriz;

    }


    public static int[][] clonaMatriz(int matriz[][]){

        int i, j;
        int matrizClone[][] = new int[8][8];

        for (i = 0; i < 8; i++){
            for (j = 0; j < 8; j++){
                matrizClone[i][j] = matriz[i][j];
            }
        }

        return matrizClone;

    }

    public static int numeroRandom (){

        int coordenada;

        Random gerador = new Random();
        coordenada = gerador.nextInt(8);

        return coordenada;

    }

    public static void imprimeMatriz (int matriz[][]) {

        int i, j;

        for (i = 0; i < 8; i++){
            for (j = 0; j < 8; j++){
                System.out.print(matriz[i][j] + " /");
            }
            System.out.println();
        }

    }

    public static void marcaTabuleiro(int x, int y, int turno, int[][] matriz) {

        matriz[x][y] = turno;
        visitadas ++;

    }

    public static boolean checaCasaNaoVisitada(int x, int y, int[][]matriz) {

        return matriz[x][y] == 0; //em caso de 0 (casa não visitada), retorna true, ou seja, vazia.

    }


    public static boolean checaCasaDentroTabueiro(int x, int y, int[][]matriz) {

        return x < 8 && x >= 0 && y < 8 && y >= 0; //em caso de a casa estar com coordenadas dentro do tabuleiro, retorna true.

    }

    public static boolean visitouTodas (int[][] matriz) {

        boolean visitou = true;

        for (int i = 0; i < 8 && visitou == true ; i++){
            for (int j = 0; j < 8 && visitou == true; j++){
                if (matriz[i][j] == 0) {
                    visitou = false;
                }
            }
        }

        return visitou;

    }

    public static void turnoDeJogo (int x, int y, int[][]matriz, int turno, long tempoInicial){

        int matrizClone[][] = clonaMatriz(matriz);
        marcaTabuleiro(x, y, turno, matrizClone);

        if (visitouTodas(matrizClone)){
            System.out.println("Visitou Todas! :)");
            System.out.println("Numero total de casas visitadas:  " + turno );
            imprimeMatriz(matrizClone);

            long tempoFinal = System.currentTimeMillis();
            System.out.println( (tempoFinal - tempoInicial) + " milisegundos" );
            System.exit(0);
        }

        turno++;

        if (checaCasaDentroTabueiro(x+2, y+1, matrizClone) && checaCasaNaoVisitada(x+2, y+1, matrizClone)){
            turnoDeJogo (x+2, y+1, matrizClone, turno, tempoInicial);
        }

        if (checaCasaDentroTabueiro(x+1, y+2, matrizClone) && checaCasaNaoVisitada(x+1, y+2, matrizClone)){
            turnoDeJogo (x+1, y+2, matrizClone, turno, tempoInicial);
        }

        if (checaCasaDentroTabueiro(x-1, y+2, matrizClone) && checaCasaNaoVisitada(x-1, y+2, matrizClone)){
            turnoDeJogo (x-1, y+2, matrizClone, turno, tempoInicial);
        }

        if (checaCasaDentroTabueiro(x-2, y+1, matrizClone) && checaCasaNaoVisitada(x-2, y+1, matrizClone)){
            turnoDeJogo (x-2, y+1, matrizClone, turno, tempoInicial);
        }

        if (checaCasaDentroTabueiro(x-2, y-1, matrizClone) && checaCasaNaoVisitada(x-2, y-1, matrizClone)){
            turnoDeJogo (x-2, y-1, matrizClone, turno, tempoInicial);
        }

        if (checaCasaDentroTabueiro(x-1, y-2, matrizClone) && checaCasaNaoVisitada(x-1, y-2, matrizClone)){
            turnoDeJogo (x-1, y-2, matrizClone, turno, tempoInicial);
        }

        if (checaCasaDentroTabueiro(x+1, y-2, matrizClone) && checaCasaNaoVisitada(x+1, y-2, matrizClone)){
            turnoDeJogo (x+1, y-2, matrizClone, turno, tempoInicial);
        }

        if (checaCasaDentroTabueiro(x+2, y-1, matrizClone) && checaCasaNaoVisitada(x+2, y-1, matrizClone)){
            turnoDeJogo (x+2, y-1, matrizClone, turno, tempoInicial);
        }
    }

    public static void main(String[] args) {

        visitadas = 0;
        int matriz[][] = criaMatriz();
        int x = numeroRandom(), y = numeroRandom();

        long tempoInicial = System.currentTimeMillis();

        turnoDeJogo(x, y, matriz, 1, tempoInicial); //primeiro turno = 1

    }

}
