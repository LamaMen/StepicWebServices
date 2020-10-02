package db_work.main;

import db_work.dbService.DBService;
import db_work.servlets.SignInServlet;
import db_work.servlets.SignUpServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {

        // Start Hibernate
        DBService dbService = new DBService();

        // Add servlets
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignUpServlet(dbService)), "/signup");
        context.addServlet(new ServletHolder(new SignInServlet(dbService)), "/signin");

        // Starting server
        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        LOGGER.log(Level.INFO, "Server started");
        server.join();
    }
}