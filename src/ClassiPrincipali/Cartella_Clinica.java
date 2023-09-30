package ClassiPrincipali;

import java.util.Date;

public class Cartella_Clinica {
    private String idCartellaClinica;
    private String specie;
    private int lunghezza;
    private int larghezza;
    private int peso;
    private String luogoRitrovamento;
    private Date dataAmmissione;
    private Date dataRilascio;
    private String fkMatricolamv;
    private String fktarghetta;

    public Cartella_Clinica(String idCartellaClinica, String specie, int lunghezza, int larghezza, int peso, String luogoRitrovamento, Date dataAmmissione, Date dataRilascio, String fkMatricolamv, String fktarghetta) {
        this.idCartellaClinica = idCartellaClinica;
        this.specie = specie;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.peso = peso;
        this.luogoRitrovamento = luogoRitrovamento;
        this.dataAmmissione = dataAmmissione;
        this.dataRilascio = dataRilascio;
        this.fkMatricolamv = fkMatricolamv;
        this.fktarghetta = fktarghetta;
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

    public Date getDataAmmissione() {
        return dataAmmissione;
    }

    public void setDataAmmissione(Date dataAmmissione) {
        this.dataAmmissione = dataAmmissione;
    }

    public Date getDataRilascio() {
        return dataRilascio;
    }

    public void setDataRilascio(Date dataRilascio) {
        this.dataRilascio = dataRilascio;
    }

    public String getIdCartellaClinica() {
        return idCartellaClinica;
    }

    public void setIdCartellaClinica(String idCartellaClinica) {
        this.idCartellaClinica = idCartellaClinica;
    }

    public String getFkMatricolamv() {
        return fkMatricolamv;
    }

    public void setFkMatricolamv(String fkMatricolamv) {
        this.fkMatricolamv = fkMatricolamv;
    }

    public String getFktarghetta() {
        return fktarghetta;
    }

    public void setFktarghetta(String fktarghetta) {
        this.fktarghetta = fktarghetta;
    }
}
