import org.apache.commons.math3.primes.Primes;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet()
public class PrimeServlet extends HttpServlet {
    static Logger log = Logger.getLogger(PrimeServlet.class);
    private final String PARAM_NUMBER_TO_CHECK = "number";

    @Override
    public void init(ServletConfig config) throws ServletException {
        PropertyConfigurator.configure(config.getServletContext().getRealPath("/") + "WEB-INF/log4j.properties");
        log.info("Set up!");
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("POST request: '" + PARAM_NUMBER_TO_CHECK + "' = " + req.getParameter(PARAM_NUMBER_TO_CHECK));

        try (PrintWriter writer = resp.getWriter()) {
            final int n = validateAndConvertNumberString(req.getParameter(PARAM_NUMBER_TO_CHECK));
            writer.print(n == -1 ? n : Primes.isPrime(n));
        }
    }

    protected int validateAndConvertNumberString(String number) {
        int resultingNumber;
        try {
            resultingNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            resultingNumber = -1;
        }

        return resultingNumber;
    }
}
