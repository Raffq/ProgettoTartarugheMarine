package ClassiPrincipali;

import java.util.Date;

public class Componenti {
    private String idcomponenti;
    private String condizioneBecco;
    private String condizioneCollo;
    private String condizioneTesta;
    private String condizioneCoda;
    private String condizionePinne;
    private String condizioneOcchi;
    private String condizioneNaso;
    private Date dataCompilazione;
    private String fktarghetta;
    private String fkIdCartellaClinica;

    public Componenti(String idcomponenti, String condizioneBecco, String condizioneCollo, String condizioneTesta, String condizioneCoda, String condizionePinne, String condizioneOcchi, String condizioneNaso, Date dataCompilazione, String fktarghetta, String fkIdCartellaClinica) {
        this.idcomponenti = idcomponenti;
        this.condizioneBecco = condizioneBecco;
        this.condizioneCollo = condizioneCollo;
        this.condizioneTesta = condizioneTesta;
        this.condizioneCoda = condizioneCoda;
        this.condizionePinne = condizionePinne;
        this.condizioneOcchi = condizioneOcchi;
        this.condizioneNaso = condizioneNaso;
        this.dataCompilazione = dataCompilazione;
        this.fktarghetta = fktarghetta;
        this.fkIdCartellaClinica = fkIdCartellaClinica;
    }

    public String getIdcomponenti() {
        return idcomponenti;
    }

    public String getCondizioneBecco() {
        return condizioneBecco;
    }

    public String getCondizioneCollo() {
        return condizioneCollo;
    }

    public String getCondizioneTesta() {
        return condizioneTesta;
    }

    public String getCondizioneCoda() {
        return condizioneCoda;
    }

    public String getCondizionePinne() {
        return condizionePinne;
    }

    public String getCondizioneOcchi() {
        return condizioneOcchi;
    }

    public String getCondizioneNaso() {
        return condizioneNaso;
    }

    public Date getDataCompilazione() {
        return dataCompilazione;
    }

    public String getFktarghetta() {
        return fktarghetta;
    }

    public String getFkIdCartellaClinica() {
        return fkIdCartellaClinica;
    }

    public void setIdcomponenti(String idcomponenti) {
        this.idcomponenti = idcomponenti;
    }

    public void setCondizioneBecco(String condizioneBecco) {
        this.condizioneBecco = condizioneBecco;
    }

    public void setCondizioneCollo(String condizioneCollo) {
        this.condizioneCollo = condizioneCollo;
    }

    public void setCondizioneTesta(String condizioneTesta) {
        this.condizioneTesta = condizioneTesta;
    }

    public void setCondizioneCoda(String condizioneCoda) {
        this.condizioneCoda = condizioneCoda;
    }

    public void setCondizionePinne(String condizionePinne) {
        this.condizionePinne = condizionePinne;
    }

    public void setCondizioneOcchi(String condizioneOcchi) {
        this.condizioneOcchi = condizioneOcchi;
    }

    public void setCondizioneNaso(String condizioneNaso) {
        this.condizioneNaso = condizioneNaso;
    }

    public void setDataCompilazione(Date dataCompilazione) {
        this.dataCompilazione = dataCompilazione;
    }

    public void setFktarghetta(String fktarghetta) {
        this.fktarghetta = fktarghetta;
    }

    public void setFkIdCartellaClinica(String fkIdCartellaClinica) {
        this.fkIdCartellaClinica = fkIdCartellaClinica;
    }
}
