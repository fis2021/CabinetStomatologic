import java.util.ArrayList;

public class FisaMedicala {

    private String nume;
    private String numarTelefon;
    private String data;
    private boolean q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;

    public FisaMedicala(String nume, String numarTelefon, String data, boolean q1, boolean q2, boolean q3, boolean q4, boolean q5, boolean q6, boolean q7, boolean q8, boolean q9, boolean q10) {
        this.nume = nume;
        this.numarTelefon = numarTelefon;
        this.data = data;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
        this.q9 = q9;
        this.q10 = q10;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isQ1() {
        return q1;
    }

    public void setQ1(boolean q1) {
        this.q1 = q1;
    }

    public boolean isQ2() {
        return q2;
    }

    public void setQ2(boolean q2) {
        this.q2 = q2;
    }

    public boolean isQ3() {
        return q3;
    }

    public void setQ3(boolean q3) {
        this.q3 = q3;
    }

    public boolean isQ4() {
        return q4;
    }

    public void setQ4(boolean q4) {
        this.q4 = q4;
    }

    public boolean isQ5() {
        return q5;
    }

    public void setQ5(boolean q5) {
        this.q5 = q5;
    }

    public boolean isQ6() {
        return q6;
    }

    public void setQ6(boolean q6) {
        this.q6 = q6;
    }

    public boolean isQ7() {
        return q7;
    }

    public void setQ7(boolean q7) {
        this.q7 = q7;
    }

    public boolean isQ8() {
        return q8;
    }

    public void setQ8(boolean q8) {
        this.q8 = q8;
    }

    public boolean isQ9() {
        return q9;
    }

    public void setQ9(boolean q9) {
        this.q9 = q9;
    }

    public boolean isQ10() {
        return q10;
    }

    public void setQ10(boolean q10) {
        this.q10 = q10;
    }
}
