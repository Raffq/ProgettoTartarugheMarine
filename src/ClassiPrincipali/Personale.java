package ClassiPrincipali;

public class Personale {
    private String matricola;
    private String nome;
    private String cognome;

    private String fkidcentro;

    public Personale() {
    }

    public Personale(String matricola, String nome, String cognome, String fkidcentro) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.fkidcentro=fkidcentro;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getfkidcentro() {
        return fkidcentro;
    }

    public void setfkidcentro(String fkidcentro) {
        this.fkidcentro = fkidcentro;
    }
}
