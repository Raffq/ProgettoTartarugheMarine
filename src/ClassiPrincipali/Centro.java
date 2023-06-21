package ClassiPrincipali;

public class Centro {
    private String idCentro;
    private String nomeCentro;

    public Centro(String idCentro, String nomeCentro) {
        this.idCentro = idCentro;
        this.nomeCentro = nomeCentro;
    }

    public String getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(String idCentro) {
        this.idCentro = idCentro;
    }

    public String getNomeCentro() {
        return nomeCentro;
    }

    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }
}
