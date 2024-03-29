package no.wact.jenjon13;

import org.apache.commons.math3.primes.Primes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class PrimeServlet extends HttpServlet {
    public static final String PARAM_NUMBER_TO_CHECK = "number";
    private final static Logger log = LogManager.getLogger(PrimeServlet.class);

    /**
     * Override of the javax.servlet.http.Servlet.doPost method.
     * Handles incoming POST requests to the servlet.
     *
     * @param req  The incoming request. Expected to contain a key/value-pair which primality to validate.
     * @param resp The response which is to be built up and sent back to the client
     * @throws ServletException If any binding errors occur
     * @throws IOException If any binding errors occur
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            final int n = Util.validateAndConvertNumberString(req.getParameter(PARAM_NUMBER_TO_CHECK));
            final String result = (String.valueOf(n == -1 ? n : Primes.isPrime(n)));

            writer.print(result);
            log.info(String.format("POST request: '%s' = %s | response = '%s'",
                    PARAM_NUMBER_TO_CHECK, req.getParameter(PARAM_NUMBER_TO_CHECK), result));
        }
    }


}
