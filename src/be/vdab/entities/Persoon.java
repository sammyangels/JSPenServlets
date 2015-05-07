package be.vdab.entities;

import java.io.Serializable;

/**
 * Created by Samuel Engelen on 21/04/2015.
 */
public class Persoon implements Serializable {
    private static final long serialVersionUID = 1L;
    private String voornaam;
    private String familienaam;
    private int aantalKinderen;
    private boolean gehuwd;
    private Adres adres;

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public int getAantalKinderen() {
        return aantalKinderen;
    }

    public boolean isGehuwd() {
        return gehuwd;
    }

    public String getNaam() {
        return voornaam + ' ' + familienaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public void setAantalKinderen(int aantalKinderen) {
        this.aantalKinderen = aantalKinderen;
    }

    public void setGehuwd(boolean gehuwd) {
        this.gehuwd = gehuwd;
    }
}
