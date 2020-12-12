package nicebank.implementations.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nicebank.Account;
import nicebank.AutomatedTeller;
import nicebank.CashSlot;
import nicebank.implementations.ITeller;

import java.io.IOException;

public class WithdrawalServlet extends HttpServlet {

    private CashSlot cashSlot;
    private Account account;

    public WithdrawalServlet(CashSlot cashSlot, Account account) {
        this.cashSlot = cashSlot;
        this.account = account;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ITeller teller = new AutomatedTeller(cashSlot);
        int amount = Integer.parseInt(request.getParameter("amount"));
        teller.withdrawFrom(account, amount);

        response.setContentType("text/html");
        response.setStatus(javax.servlet.http.HttpServletResponse.SC_OK);
        response.getWriter().println(
                "<html><head><title>Nice Bank ATM</title></head>" +
                        "<body>Please take your $" + amount + "</body></html>");
        System.out.println("Take money: " + amount);
    }
}

