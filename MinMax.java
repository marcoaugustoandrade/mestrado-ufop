package de.marcoandra.arvoresBinarias.ordenacao;

import java.util.Scanner;

public class MinMax {

    class tabuleiroSimulado{

        private char[] tabuleiro;
        private tabuleiroSimulado proximo;

        public tabuleiroSimulado() {
            tabuleiro = new char[9];
        }

        public char[] getTabuleiro() {
            return tabuleiro;
        }

        public void setTabuleiro(char[] tabuleiro) {
            this.tabuleiro = tabuleiro;
        }

        public tabuleiroSimulado getProximo() {
            return proximo;
        }

        public void setProximo(tabuleiroSimulado proximo) {
            this.proximo = proximo;
        }
    }

    private char[] tabuleiro;

    public MinMax() {

        tabuleiro = new char[9];
        preencher();
    }

    private void preencher() {
        for (int i = 0; i <= 8; i++)
                tabuleiro[i] = '_';
    }

    public void jogarHumano(int posX, int posY){

        switch (posX){
            case 0:
                switch (posY){
                    case 0:
                        tabuleiro[0] = 'X';
                        break;
                    case 1:
                        tabuleiro[1] = 'X';
                        break;
                    case 2:
                        tabuleiro[2] = 'X';
                        break;
                }
                break;
            case 1:
                switch (posY){
                    case 0:
                        tabuleiro[3] = 'X';
                        break;
                    case 1:
                        tabuleiro[4] = 'X';
                        break;
                    case 2:
                        tabuleiro[5] = 'X';
                        break;
                }
                break;
            case 2:
                switch (posY){
                    case 0:
                        tabuleiro[6] = 'X';
                        break;
                    case 1:
                        tabuleiro[7] = 'X';
                        break;
                    case 2:
                        tabuleiro[8] = 'X';
                        break;
                }
                break;
        }

        jogarComputador();

        imprimir();

        // 00 => 0
        // 01 => 1
        // 02 => 2

        // 10 => 3
        // 11 => 4
        // 12 => 5

        // 20 => 6
        // 21 => 7
        // 22 => 8

//
//        if (tabuleiro[posX][posY] == '_'){
//            tabuleiro[posX][posY] = 'X';
//            jogarComputador();
//        } else {
//            System.out.println("Essa posição já está em uso!");
//        }
    }

    private void jogarComputador() {

        // Contar quantos posições disponíveis no tabuleiro
        int contador = 0;
        for (int i = 0; i <= 8; i++){
            if (tabuleiro[i] == '_')
                contador++;
        }
        System.out.println(contador);

        // Contar quantos possibilidades
        int acumulador = 1;
        for (int i = contador; i > 0; i--){
            acumulador = acumulador * i;
        }
        System.out.println(acumulador);


        gerarCombinacoes();

    }

    private void gerarCombinacoes() {

    }


    public char verifica(){

        // 0 1 2
        // 3 4 5
        // 6 7 8

        if (tabuleiro[0] == 'X' && tabuleiro[1] == 'X' && tabuleiro[2] == 'X' ||
            tabuleiro[3] == 'X' && tabuleiro[4] == 'X' && tabuleiro[5] == 'X' ||
            tabuleiro[6] == 'X' && tabuleiro[7] == 'X' && tabuleiro[8] == 'X' ||
            tabuleiro[0] == 'X' && tabuleiro[3] == 'X' && tabuleiro[6] == 'X' ||
            tabuleiro[1] == 'X' && tabuleiro[4] == 'X' && tabuleiro[7] == 'X' ||
            tabuleiro[2] == 'X' && tabuleiro[5] == 'X' && tabuleiro[8] == 'X' ||
            tabuleiro[0] == 'X' && tabuleiro[4] == 'X' && tabuleiro[8] == 'X' ||
            tabuleiro[6] == 'X' && tabuleiro[4] == 'X' && tabuleiro[2] == 'X')
            return 'X';
        if (tabuleiro[0] == 'O' && tabuleiro[1] == 'O' && tabuleiro[2] == 'O' ||
            tabuleiro[3] == 'O' && tabuleiro[4] == 'O' && tabuleiro[5] == 'O' ||
            tabuleiro[6] == 'O' && tabuleiro[7] == 'O' && tabuleiro[8] == 'O' ||
            tabuleiro[0] == 'O' && tabuleiro[3] == 'O' && tabuleiro[6] == 'O' ||
            tabuleiro[1] == 'O' && tabuleiro[4] == 'O' && tabuleiro[7] == 'O' ||
            tabuleiro[2] == 'O' && tabuleiro[5] == 'O' && tabuleiro[8] == 'O' ||
            tabuleiro[0] == 'O' && tabuleiro[4] == 'O' && tabuleiro[8] == 'O' ||
            tabuleiro[6] == 'O' && tabuleiro[4] == 'O' && tabuleiro[2] == 'O')
            return 'O';

        return 'n';
    }

    public void imprimir(){

        for(int i = 0; i <= 2; i++)
            System.out.print(tabuleiro[i] + " ");
        System.out.println("\n");

        for(int i = 3; i <= 5; i++)
            System.out.print(tabuleiro[i] + " ");
        System.out.println("\n");

        for(int i = 6; i <= 8; i++)
            System.out.print(tabuleiro[i] + " ");
        System.out.println("\n");
    }

}

class TestaMinMax{

    public static void main(String[] args) {

        MinMax minMax = new MinMax();
        minMax.imprimir();

        while (minMax.verifica() == 'n') {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe a linha [0-2]: ");
            int x = scanner.nextInt();

            System.out.println("Informe a coluna [0-2]");
            int y = scanner.nextInt();

            minMax.jogarHumano(x, y);
        }

        System.out.println("Quem ganhou foi: " + minMax.verifica());
    }
}

