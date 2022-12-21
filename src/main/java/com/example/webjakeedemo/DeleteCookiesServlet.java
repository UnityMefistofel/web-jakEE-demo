package com.example.webjakeedemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "deleteCookiesServlet", value = "/deleteCookiesServlet")
public class DeleteCookiesServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Cookie cookie = new Cookie("user_id", "");
        List<Cookie> cookies = Arrays.asList(request.getCookies());

        //cookies.forEach(cookie -> cookie.setMaxAge(0));
        for (Cookie elem: cookies) {
            elem.setMaxAge(0);
            response.addCookie(elem);
        }

    }

    public void destroy() {
    }

}
