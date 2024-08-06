<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Материалы</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<#include "parts/header.ftl">
<main>
    <h2>Список материалов</h2>
    <table>
        <tr>
            <th>Название</th>
            <th>Тип или источник</th>
            <th>На складе</th>
        </tr>
        <#list materials as material>
            <tr>
                <td>${material.name}</td>
                <td>${material.typePrettyName}</td>
                <td>${material.amount}</td>
            </tr>
        </#list>
    </table>
</main>
</body>
</html>