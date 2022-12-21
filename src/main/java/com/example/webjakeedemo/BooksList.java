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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "bookslist", value = "/bookslist")
public class BooksList extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,String> paramSet = new HashMap<>(); // заглушка для списка параметров подключения
        PrintWriter writer = response.getWriter();

        try {
            ResultSet resultSet = Util.sqlQuery(paramSet, "BookList");

            while (resultSet.next()) {
                String rec = "";
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    rec = rec + resultSet.getString(i) + "\t";
                }
                writer.println(rec);
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
