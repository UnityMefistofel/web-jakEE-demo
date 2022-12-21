package com.example.webjakeedemo;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Cart;

@WebServlet(name = "helloServlet", value = "/helloServlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello, World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String[] paramSet = new String[10];
//        paramSet[0] = request.getParameter("name");
//        paramSet[1] = request.getParameter("name");
//        response.setContentType("text/html");

        HttpSession httpSession = request.getSession();
        Integer cnt = (Integer) httpSession.getAttribute("count");

        if (cnt == null) {
            cnt = 1;
            httpSession.setAttribute("count", cnt);
        } else {
            httpSession.setAttribute("count", cnt+1);
        }

//        Cart cart = (Cart) httpSession.getAttribute("cart");
//        String n = request.getParameter("name");
//
//        Integer i = Integer.parseInt(request.getParameter("count"));
//
//        if (cart == null) {
//            cart = new Cart();
//
//            cart.setProduct(n);
//            cart.setPrCount(i);
//        }
//
//        httpSession.setAttribute("cart", cart);

        // Hello
        PrintWriter out = response.getWriter();
        String title = "Калькулятор";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "   <html>\n" +
                "   <head><title>" + title + "</title></head>\n");
        out.println("<body><h1> Hello, Dude" + "! Session count: " + cnt + "</h1>");
        out.println("<form action=\"calcSerlvet\" method=\"POST\">\n" +
                "    Первое число: <input name=\"par1\" />\n" +
                "    <br><br>\n" +
                "    Второе число: <input name=\"par2\" />\n" +
                "    <br><br>\n" +
                "    Действие: <select name=\"par3\">\n" +
                "        <option>Сложение</option>\n" +
                "        <option>Вычитание</option>\n" +
                "        <option>Умножение</option>\n" +
                "        <option>Деление</option>\n" +
                "    </select>\n" +
                "    <br><br>\n" +
                "    <input type=\"submit\" value=\"Submit\" />\n" +
                "</form>");
        out.println("</body></html>");





//        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }


    }

    public void destroy() {
    }
}