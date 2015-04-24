package no.wact.jenjon13;

import org.apache.commons.math3.primes.Primes;
import org.junit.Assert;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PrimeServletTest {
    public String testDoPost(String input) throws Exception {
        final HttpServletRequest requestMock = mock(HttpServletRequest.class);
        final HttpServletResponse responseMock = mock(HttpServletResponse.class);

        final StringWriter stringWriter = new StringWriter();
        final PrintWriter writer = new PrintWriter(stringWriter);
        when(responseMock.getWriter()).thenReturn(writer);

        final PrimeServlet primeServlet = new PrimeServlet();
        given(requestMock.getParameter(PrimeServlet.PARAM_NUMBER_TO_CHECK)).willReturn(input);
        primeServlet.doPost(requestMock, responseMock);
        writer.flush();

        return stringWriter.toString();
    }

    @Test
    public void testReturnsTrueOnValidPrimeInput() throws Exception {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        for (int prime : primes) {
            Assert.assertTrue("The servlet should recognize the passed parameter as a valid prime number",
                    Boolean.parseBoolean(testDoPost(String.valueOf(prime))));
        }
    }

    @Test
    public void testReturnsFalseOnValidNonPrimeInput() throws Exception {
        int[] non_primes = {32, 38, 42, 44, 48, 54, 60, 62, 68, 72};
        for (int prime : non_primes) {
            Assert.assertFalse("The servlet should recognize the passed parameter as a valid non-prime number",
                    Boolean.parseBoolean(testDoPost(String.valueOf(prime))));
        }
    }

    @Test
    public void testResultsAreInAccordanceWithApacheCommons() throws Exception {
        final Random random = new Random();

        for (int i = 0; i < 100; i++) {
            final int randomInt = random.nextInt();
            Assert.assertEquals("The servlet's results should be in accordance with what Primes.isPrime() returns",
                    Primes.isPrime(randomInt),
                    Boolean.parseBoolean(testDoPost(String.valueOf(randomInt))));
        }
    }

    @Test
    public void testReturnsMinusOneOnInvalidQueries() throws Exception {
        String[] invalidQueries = {"2d", "6f", "--ds"};

        for (String invalidQuery : invalidQueries) {
            Assert.assertEquals("The servlet should return \"-1\" as a response to each invalid query.",
                    "-1", testDoPost(invalidQuery));
        }
    }

    @Test
    public void testValidateAndConvertValidNumberConvertsToString() throws Exception {
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
