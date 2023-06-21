package ClassiPrincipali;

public class Tartaruga {
    String targhetta;
    String nomeTartaruga;
    boolean presenteNelCentro;

    public Tartaruga(String targhetta, String nomeTartaruga, boolean presenteNelCentro) {
        this.targhetta = targhetta;
        this.nomeTartaruga = nomeTartaruga;
        this.presenteNelCentro = presenteNelCentro;
    }

    public String getTarghetta() {
        return targhetta;
    }

    public void setTarghetta(String targhetta) {
        this.targhetta = targhetta;
    }

    public String getNomeTartaruga() {
        return nomeTartaruga;
    }

    public void setNomeTartaruga(String nomeTartaruga) {
        this.nomeTartaruga = nomeTartaruga;
    }

    public boolean isPresenteNelCentro() {
        return presenteNelCentro;
    }

    public void setPresenteNelCentro(boolean presenteNelCentro) {
        this.presenteNelCentro = presenteNelCentro;
    }
}
