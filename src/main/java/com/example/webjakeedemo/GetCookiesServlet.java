package com.example.webjakeedemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "getCookiesServlet", value = "/getCookiesServlet")
public class GetCookiesServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        cookies.forEach(cookie -> pw.println("<h1>" + cookie.getName()+" "+cookie.getValue()+"</h1>"));
        pw.println("</html>");

    }

    public void destroy() {
    }

}
