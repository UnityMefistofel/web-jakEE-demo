package com.example.webjakeedemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "libraryServlet", value = "/library")
public class LibraryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/test_db",
                    "postgres",
                    "postgres");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from my_table");

            while (rs.next()) {
                printWriter.println(
                        rs.getString("title") + " " +
                        rs.getString("author"));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
