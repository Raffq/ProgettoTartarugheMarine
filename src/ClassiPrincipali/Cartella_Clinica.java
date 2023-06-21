package ClassiPrincipali;

public class Cartella_Clinica {
    String specie;
    int lunghezza;
    int larghezza;
    int peso;
    String luogoRitrovamento;

    /* DataCompilazione date */

    public Cartella_Clinica(String specie, int lunghezza, int larghezza, int peso, String luogoRitrovamento) {
        this.specie = specie;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.peso = peso;
        this.luogoRitrovamento = luogoRitrovamento;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getLuogoRitrovamento() {
        return luogoRitrovamento;
    }

    public void setLuogoRitrovamento(String luogoRitrovamento) {
        this.luogoRitrovamento = luogoRitrovamento;
    }
}
