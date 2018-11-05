<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Дешифрование</title>
</head>
<body>
<h2>Зашифрованный текст: </h2><p>${originalEncText}</p>
<h2>Ключ: </h2><p>${originalKey}</p>
<h2>Расшифрованный текст: </h2><p>${decryptedText}</p>

<form>
    <input type="submit" formaction="main" value="На главную" />
</form>
</body>
</html>