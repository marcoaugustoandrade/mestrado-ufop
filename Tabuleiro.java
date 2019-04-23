package de.marcoandra.arvoresBinarias.ordenacao;

public class Tabuleiro {

    private char[] tabuleiro;
    private Tabuleiro proximo;

    public Tabuleiro() {
        tabuleiro = new char[9];
        proximo = null;
        preencher();
    }

    private void preencher() {
        for (int i = 0; i < 9; i++){
            tabuleiro[i] = '_';
        }
    }

    public char[] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(char[] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Tabuleiro getProximo() {
        return proximo;
    }

    public void setProximo(Tabuleiro proximo) {
        this.proximo = proximo;
    }
}

