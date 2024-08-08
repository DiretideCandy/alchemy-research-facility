<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Alchemy Research Facility</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<#include "parts/header.ftl">
<#assign roleMANAGER = roles?seq_contains("MANAGER")?string("yes", "no")>
<#assign roleAPI = roles?seq_contains("API")?string("yes", "no")>
<#assign roleSYSTEM_ADMIN = roles?seq_contains("SYSTEM_ADMIN")?string("yes", "no")>
<#assign roleSCIENTIST = roles?seq_contains("SCIENTIST")?string("yes", "no")>
<main>
    <h2>Лаборатория Исследования Магии и Алхимии</h2>
    <p>Добро пожаловать<#if user != anon>, ${user}</#if>!</p>
    <p></p>
    <p></p>

    <#if user == anon>
        <p>Для начала работы войдите в систему </p>
        <form action="/login" method="get">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">Войти</button>
        </form>
    <#else >
        <p>С чего начать: (текущие полномочия - <#list roles as role>
            [${role?replace('SYSTEM_ADMIN','Системный администратор')?replace('API','Младший сотрудник')?replace('SCIENTIST','Учёный')?replace('MANAGER','Старший сотрудник')}]
            </#list>)</p>
        <p></p>
        <#if roleSYSTEM_ADMIN == "yes" || roleMANAGER == "yes">
            <p>[Старший сотрудник]</p>
            <p><a href="/research/experiments">Просмотр и согласование экспериментов</a></p>
        </#if>
        <#if roleSYSTEM_ADMIN == "yes" || roleSCIENTIST == "yes">
            <p>[Учёный]</p>
            <p><a href="/research/experiments">Просмотр и проведение экспериментов</a></p>
            <p><a href="/research/equipment">Просмотр оборудования</a></p>
            <p><a href="/research/materials">Просмотр доступных материалов</a></p>
        </#if>
        <#if roleSYSTEM_ADMIN == "yes" || roleAPI == "yes">
            <p>[Младший сотрудник]</p>
            <p><a href="/swagger-ui/index.html">Ссылка на описание API</a></p>
        </#if>
    </#if>

</main>
</body>
</html>