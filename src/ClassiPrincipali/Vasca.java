package ClassiPrincipali;

public class Vasca {
    private String idVasca;
    private int postiOccupati;

    public Vasca(String idVasca, int postiOccupati) {
        this.idVasca = idVasca;
        this.postiOccupati = postiOccupati;
    }

    public String getIdVasca() {
        return idVasca;
    }

    public void setIdVasca(String idVasca) {
        this.idVasca = idVasca;
    }

    public int getPostiOccupati() {
        return postiOccupati;
    }

    public void setPostiOccupati(int postiOccupati) {
        this.postiOccupati = postiOccupati;
    }
}
