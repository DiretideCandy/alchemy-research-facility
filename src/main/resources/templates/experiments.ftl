<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Эксперименты</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<#include "common/header.ftl">
<main>
    <h1>Список экспериментов</h1>
    <table>
        <#list experiments as experiment>
            <tr>
                <td><a href="/experiments/${experiment.id}">#${experiment.id}</a></td>
                <td>${experiment.createdAt}</td>
                <td>${experiment.createdBy}</td>
                <td>${experiment.statusName}</td>
                <td>${experiment.statusDescription}</td>
            </tr>
        </#list>
    </table>
</main>
</body>
</html>