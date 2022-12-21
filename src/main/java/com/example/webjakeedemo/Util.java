package com.example.webjakeedemo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Util {

    public static Connection connToPG(Map<String,String> paramSet) throws SQLException {
        String host = "localhost";
        String db   = "test_db";
        String port = "5432";
        String user = "postgres";
        String pass = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }

        if (!paramSet.isEmpty())
            for (Map.Entry<String,String> entry : paramSet.entrySet()) {
                String param = entry.getKey();
                switch (param) {
                    case "host" -> host = entry.getValue();
                    case "db"   -> db   = entry.getValue();
                    case "port" -> port = entry.getValue();
                    case "user" -> user = entry.getValue();
                }
            }

        return DriverManager.getConnection(
                "jdbc:postgresql://"+host+":"+port+"/"+db,
                ""+user,
                ""+pass);
    }

    public static List<String> sqlQuery(Map<String,String> paramSet, String currQueryType) throws SQLException {
        Statement statement = connToPG(paramSet).createStatement();
        List<String> resultList = new LinkedList<>();
        ResultSet rs;

        switch (currQueryType) {
            case "BookCount" -> {
                rs = statement.executeQuery("select id, quantity from my_table;");
            }
            case "BookList" -> {
                rs = statement.executeQuery("select title, author from my_table;");
            }
            default -> {
                rs = statement.executeQuery("select version();");
            }
        }

         while (rs.next()) {
             String rec = "";
             for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                 rec = rec + rs.getString(i) + "\t";
             }
             resultList.add(rec);
         }

         statement.close();

         return resultList;
    }

}
