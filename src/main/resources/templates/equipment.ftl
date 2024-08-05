<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Оборудование</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<#include "parts/header.ftl">
<main>
    <h1>Список оборудования</h1>
    <table>
        <#list equipment as eq>
            <tr>
                <td>${eq.name}</td>
                <td>${eq.typePrettyName}</td>
                <td>${eq.amount}</td>
            </tr>
        </#list>
    </table>
</main>
</body>
</html>