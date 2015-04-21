import org.apache.commons.math3.primes.Primes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet()
public class PrimeServlet extends HttpServlet {
    private final String PARAM_NAME = "number";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            final int n = validateAndConvertNumberString(req.getParameter(PARAM_NAME));
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
