public class Persoana {
    private String nume;
    private String prenume;
    private String nr;
    private String data;

    public Persoana(String nume, String prenume, String nr, String data){
        this.nume = nume;
        this.prenume = prenume;
        this.nr = nr;
        this.data = data;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
