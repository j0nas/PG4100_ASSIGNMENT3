package no.wact.jenjon13;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrimeServletTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDoPost() throws Exception {

    }

    @Test
    public void testValidateAndConvertNumberString() throws Exception {
        for (int i = 0; i < 11; i++) {
            Assert.assertEquals("The method should convert the provided String to the expected return value",
                    i, PrimeServlet.validateAndConvertNumberString(String.valueOf(i)));
        }
    }

    @Test
    public void testValidateAndConvert_InvalidCharReturnsMinusOne() throws Exception {
        Assert.assertEquals("The method should return -1 to represent invalid input",
                -1, PrimeServlet.validateAndConvertNumberString("Ø"));
    }
}
