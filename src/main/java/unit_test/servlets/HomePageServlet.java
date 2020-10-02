package unit_test.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import unit_test.accountSrever.AccountServerI;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {
    public static final String PAGE_URL = "/admin";
    static final Logger logger = LogManager.getLogger(HomePageServlet.class.getName());
    private final AccountServerI accountServer;

    public HomePageServlet(AccountServerI accountServer) {
        this.accountServer = accountServer;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");

        int limit = accountServer.getUsersLimit();

        logger.info("Returned limit: {}", limit);
        response.getWriter().println(limit);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}