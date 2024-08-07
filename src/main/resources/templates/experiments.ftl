<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Эксперименты</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<#include "parts/header.ftl">
<#include "parts/sorting.ftl">
<main>
    <h2>Список экспериментов</h2>
    <p></p>
    <form action="/research/experiments/create" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Новый эксперимент</button>
    </form>
    <p></p>
    <form action="/research/experiments?sort=${sortBy},${sortDir}" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Фильтр по дате создания</button>
        <@spring.bind "dateFilterDTO.from" />
        <label for="from">от</label>
        <input type="datetime-local" id="from" name="from"
               <#if dateFilterDTO??><#if dateFilterDTO.from??>
                   value="${dateFilterDTO.from?string}"
               </#if></#if> />

        <@spring.bind "dateFilterDTO.to" />
        <label for="t">до:</label>
        <input type="datetime-local" id="to" name="to"
               <#if dateFilterDTO??><#if dateFilterDTO.to??>
                   value="${dateFilterDTO.to?string}"
               </#if></#if> />

    </form>
    <p></p>
    <table>
        <thead>
            <tr>
                <th>
                    <a href="/research/experiments?sort=${sortByIdUrl}">
                        Номер<#if sortBy=="id"> <b><#if sortDir=="desc">↓<#else>↑</#if></#if></b>
                    </a>
                </th>
                <th>
                    <a href="/research/experiments?sort=${sortByCreatedAtUrl}">
                        Дата создания<#if sortBy=="createdAt"> <b><#if sortDir=="desc">↓<#else>↑</#if></#if></b>
                    </a>
                </th>
                <th>
                    <a href="/research/experiments?sort=${sortByLastUpdatedAtUrl}">
                        Дата изменения<#if sortBy=="lastUpdatedAt"> <b><#if sortDir=="desc">↓<#else>↑</#if></#if></b>
                    </a>
                </th>
                <th>
                    <a href="/research/experiments?sort=${sortByCreatedByUrl}">
                        Ответственный<#if sortBy=="createdBy"> <b><#if sortDir=="desc">↓<#else>↑</#if></#if></b>
                    </a>
                </th>
                <th>
                    Статус
                </th>
                <th>
                    <a href="/research/experiments?sort=${sortByProgressUrl}">
                        Прогресс<#if sortBy=="progress"> <b><#if sortDir=="desc">↓<#else>↑</#if></#if></b>
                    </a>
                </th>
            </tr>
        </thead>
        <tbody>
            <#list experiments as experiment>
                <#assign progress = experiment.progress>
                <tr>
                    <td><a href="/research/experiments/${experiment.id}">#${experiment.id}</a></td>
                    <td>${experiment.createdAt}</td>
                    <td>${experiment.lastUpdatedAt}</td>
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