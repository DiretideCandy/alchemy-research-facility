<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Alchemy Research Facility</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<#include "parts/header.ftl">
<body>
<form method="POST" action="/logout" class="form-signin">
    <h2 class="form-heading">Log out</h2>

    <div class="form-group" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="logout" type="submit" autofocus="true">Log Out</button>
    </div>
</form>
</body>
</html>