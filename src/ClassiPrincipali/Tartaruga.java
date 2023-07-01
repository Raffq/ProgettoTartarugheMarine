package ClassiPrincipali;

public class Tartaruga {
    private String targhetta;
    private String nomeTartaruga;
    private boolean presenteNelCentro;
    private String fkidcentro;
    private String fkidvasca;

    public Tartaruga(String targhetta, String nomeTartaruga, boolean presenteNelCentro, String fkidcentro, String fkidvasca) {
        this.targhetta = targhetta;
        this.nomeTartaruga = nomeTartaruga;
        this.presenteNelCentro = presenteNelCentro;
        this.fkidcentro = fkidcentro;
        this.fkidvasca = fkidvasca;
    }

    public String getTarghetta() {return targhetta;}

    public void setTarghetta(String targhetta) {this.targhetta = targhetta;}

    public String getNomeTartaruga() {return nomeTartaruga;}

    public void setNomeTartaruga(String nomeTartaruga) {this.nomeTartaruga = nomeTartaruga;}

    public boolean isPresenteNelCentro() {return presenteNelCentro;}

    public void setPresenteNelCentro(boolean presenteNelCentro) {this.presenteNelCentro = presenteNelCentro;}

    public String getFkidcentro() {return fkidcentro;}

    public void setFkidcentro(String fkidcentro) {this.fkidcentro = fkidcentro;}

    public String getFkidvasca() {return fkidvasca;}

    public void setFkidvasca(String fkidvasca) {this.fkidvasca = fkidvasca;}
}
