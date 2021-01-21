package rs.uns.acs.ftn.VehicleService.util;

import java.util.ArrayList;
import java.util.Calendar;

public class Utility {

    public static String calToStr(Calendar cal) {
        String retVal = cal.get(Calendar.YEAR) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.DAY_OF_MONTH);
        return retVal;
    }

    public static Calendar strToCal (String str) {
        System.out.println("*** Utility: " + str);
        String[] parts = str.split("[.]");
//        for (int i = 0; i < parts.length; ++i) {
//            System.out.println(parts[i]);
//        }
        if (parts.length != 3) {
            return null;
        }
        Integer godina = Integer.valueOf(parts[0]);
        Integer mesec = Integer.valueOf(parts[1]);
        Integer dan = Integer.valueOf(parts[2]);
        System.out.println("GMD: " + godina + ", " + mesec + ", " + dan);
        Calendar retVal = Calendar.getInstance();
        retVal.set(Calendar.YEAR, godina);
        retVal.set(Calendar.MONTH, mesec - 1);
        retVal.set(Calendar.DAY_OF_MONTH, dan);
        return retVal;
    }

}
