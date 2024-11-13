package com.example;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServerApp {
    public static void main(String[] args) throws Exception {
        // Create a basic Jetty server
        Server server = new Server(8080);

        // Set up a servlet context
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // Add the servlet to the context
        server.setHandler(context);
        context.addServlet(new ServletHolder(new HelloServlet()), "/hello");

        // Start the server
        server.start();
        System.out.println("Server started at http://localhost:8080/hello");

        // Join the server to keep it running
        server.join();
    }
}
