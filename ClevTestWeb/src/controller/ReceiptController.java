package controller;

import receipt.ReceiptGenerator;
import receipt.ReceiptPrinter;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import static constants.ConstantsJsp.*;

@WebServlet("/receipt")
public class ReceiptController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String[] param = request.getParameterValues(PARAM);
        ReceiptPrinter printer = new ReceiptPrinter();
        printer.printReceiptToConsoleAndSaveInFile(ReceiptGenerator.generate(param));
        StringBuilder builder = printer.getBuilder();
        request.setAttribute(BUILDER, builder.toString());
        request.getRequestDispatcher(RECEIPT_JSP).forward(request, response);
    }
}
