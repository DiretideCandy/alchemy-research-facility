<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Эксперименты</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<#include "parts/header.ftl">
<main>
    <h1>Список экспериментов</h1>
    <p></p>
    <form action="/research/experiments/create" method="get">
        <button type="submit">Новый эксперимент</button>
    </form>
    <p></p>
    <table>
        <thead>
            <tr>
                <th>Номер</th>
                <th>Дата создания</th>
                <th>Ответственный</th>
                <th>Статус</th>
                <th>Прогресс</th>
            </tr>
        </thead>
        <tbody>
            <#list experiments as experiment>
                <#assign progress = experiment.progress>
                <tr>
                    <td><a href="/research/experiments/${experiment.id}">#${experiment.id}</a></td>
                    <td>${experiment.createdAt}</td>
                    <td>${experiment.createdBy}</td>
                    <td>${experiment.statusDescription}</td>
                    <td><#include "parts/experiment/progress-bar.ftl"></td>
                </tr>
            </#list>
        </tbody>

    </table>
</main>
</body>
</html>