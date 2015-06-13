package no.wact.jenjon13;

import org.junit.Assert;
import org.junit.Test;

import static no.wact.jenjon13.Util.validateAndConvertNumberString;

public class UtilTest {
    @Test
    public void testValidateAndConvertValidNumberConvertsToString() throws Exception {
        for (int i = 0; i < 11; i++) {
            Assert.assertEquals("The method should convert the provided String to the expected return value",
                    i, validateAndConvertNumberString(String.valueOf(i)));
        }
    }

    @Test
    public void testValidateAndConvert_InvalidCharReturnsMinusOne() throws Exception {
        Assert.assertEquals("The method should return -1 to represent invalid input",
                -1, validateAndConvertNumberString("Ø"));
    }

}
