package fr.utbm.lo54.tools;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Helper {

    public static String formatFrenchDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

}
