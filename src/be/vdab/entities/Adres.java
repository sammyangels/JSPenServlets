package be.vdab.entities;

import com.sun.xml.internal.fastinfoset.vocab.SerializerVocabulary;
import sun.misc.Version;

import java.io.Serializable;

/**
 * Created by Samuel Engelen on 21/04/2015.
 */
public class Adres implements Serializable {
    private static final long serialVersionUID = 1L;
    private String straat;
    private String huisNr;
    private int postcode;
    private String gemeente;

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public void setHuisNr(String huisNr) {
        this.huisNr = huisNr;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }
}

