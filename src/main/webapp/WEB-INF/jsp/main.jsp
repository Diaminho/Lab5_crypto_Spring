<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!--

-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Главная страница приложения!</title>
</head>
<body>
<h1>Начальная страница шифрования</h1>


<form method="post">
    <button formaction="fileBrowser" name="fileName">Выбрать файл с текстом</button>
    <button formaction="getKeyFile" name="keyFile">Выбрать файл с ключом</button>
</form>

<p>Выбран файл с текстом: "${fileName}"</p>
<p>Выбран файл с ключом: "${keyFile}"</p>


<form method="post">
    <button formaction="encrypt">Зашифровать</button>
    <button formaction="decrypt">Дешифровать</button>
</form>


</body>
</html>