package no.wact.jenjon13;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class PrimeServletTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDoPost() throws Exception {
        final HttpServletRequest requestMock = mock(HttpServletRequest.class);
        final HttpServletResponse responseMock = mock(HttpServletResponse.class);

        final StringWriter stringWriter = new StringWriter();
        final PrintWriter writer = new PrintWriter(stringWriter);
        when(responseMock.getWriter()).thenReturn(writer);

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 27};
        int currentPrime = 0;

        final PrimeServlet primeServlet = new PrimeServlet();
        given(requestMock.getParameter(PrimeServlet.PARAM_NUMBER_TO_CHECK))
                .willReturn(String.valueOf(primes[currentPrime]));

        primeServlet.doPost(requestMock, responseMock);
        primeServlet.doPost(requestMock, responseMock);
        primeServlet.doPost(requestMock, responseMock);
        primeServlet.doPost(requestMock, responseMock);


        verify(requestMock, atLeast(1)).getParameter(PrimeServlet.PARAM_NUMBER_TO_CHECK);
        writer.flush();

        System.out.println(stringWriter.toString());
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
