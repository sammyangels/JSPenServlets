package be.vdab.entities;

import java.util.Calendar;

/**
 * Created by Samuel Engelen on 21/04/2015.
 */
public class Begroeting {
    @Override
    public String toString() {
        int uur = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        return uur >= 6 && uur < 12 ? "Goedemorgen" :
                uur >= 12 && uur < 18 ? "Goedemiddag" : "Goedenavond";
    }
}
