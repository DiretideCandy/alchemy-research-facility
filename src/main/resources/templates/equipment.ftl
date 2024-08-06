<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Оборудование</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<#include "parts/header.ftl">
<main>
    <h2>Список оборудования</h2>
    <table>
        <tr>
            <th>Название</th>
            <th>Тип</th>
            <th>На складе</th>
            <th>Доступные действия</th>
        </tr>
        <#list equipment as eq>
            <tr>
                <td>${eq.name}</td>
                <td>${eq.typePrettyName}</td>
                <td>${eq.amount}</td>
                <td>
                    <#assign comma = false>
                    <#list actions as action>
                        <#if action.equipmentType == eq.type>
                            [${action.name}]
                        </#if>
                    </#list>
                </td>
            </tr>
        </#list>
    </table>
</main>
</body>
</html>