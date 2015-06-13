package no.wact.jenjon13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Util {
    private final static Logger log = LogManager.getLogger(Util.class);

    private Util() {
    }

    /**
     * Converts a String-represented integer to an int, using Integer.parseInt.
     *
     * @param number The number to convert to an int.
     * @return The converted number as an int, or -1 if the conversion fails.
     */
    protected static int validateAndConvertNumberString(String number) {
        int resultingNumber;
        try {
            resultingNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            log.error("Could not convert to number: " + number, e);
            resultingNumber = -1;
        }

        return resultingNumber;
    }


}
