package nicebank.implementations.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class WithdrawalServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        response.setStatus(javax.servlet.http.HttpServletResponse.SC_OK);
        response.getWriter().println(
                "<html><head><title>Nice Bank ATM</title></head>" +
                        "<body>I don't know how to withdraw money yet, sorry</body>" +
                        "</html>");
    }
}

