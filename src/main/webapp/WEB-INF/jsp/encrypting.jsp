<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!--

-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добро пожаловать, JSP!</title>
</head>
<body>
<h1>Начальная страница шифрования</h1>

<form action="result" method="post">
    <p>Введите имя файла: <input type="text" name="fileName"></p>
    <p>Введите имя файла с ключом: <input type="text" name="keyFile"></p>
    <p><button type="submit">Отправить</button></p>
</form>
</body>
</html>