<%@ page import="model.Cart" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 09.12.2022
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
    <% Cart cart = (Cart) session.getAttribute("cart");
        String name = cart.getProduct();
        String count = cart.getPrCount().toString();
    %>
    <h3>Товар: <% name.length(); %></h3>
    <h3>Кол-во: <% count.length(); %></h3>
</body>
</html>
