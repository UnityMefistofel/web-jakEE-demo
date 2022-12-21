package com.example.webjakeedemo;

import com.example.webjakeedemo.Util;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "bookscount", value = "/bookscount")
public class BooksCount extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,String> paramSet = new HashMap<>(); // заглушка для списка параметров подключения
        PrintWriter writer = response.getWriter();

        try {
            List resultList = Util.sqlQuery(paramSet, "BookCount");
            resultList.forEach(s -> writer.println(s));
        } catch (SQLException e) {
            e.getSQLState();
        }
    }

}
