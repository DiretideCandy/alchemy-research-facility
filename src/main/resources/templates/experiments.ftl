<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Эксперименты</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<#include "parts/header.ftl">
<main>
    <h2>Список экспериментов</h2>
    <p></p>
    <form action="/research/experiments/create" method="get">
        <button type="submit">Новый эксперимент</button>
    </form>
    <p></p>
    <table>
        <thead>
            <tr>
                <th>
                    <#if sortBy=="id">
                        <#if sortDir=="desc">
                            <#assign sortByIdUrl = "">
                        <#else>
                            <#assign sortByIdUrl = "id,desc">
                        </#if>
                    <#else>
                        <#assign sortByIdUrl = "id,asc">
                    </#if>
                    <a href="/research/experiments?sort=${sortByIdUrl}">
                        Номер<#if sortBy=="id"> <b><#if sortDir=="desc">↓<#else>↑</#if></#if></b>
                    </a>
                </th>
                <th>
                    <#if sortBy=="createdAt">
                        <#if sortDir=="desc">
                            <#assign sortByIdUrl = "createdAt,asc">
                        <#else>
                            <#assign sortByIdUrl = "">
                        </#if>
                    <#else>
                        <#assign sortByIdUrl = "createdAt,desc">
                    </#if>
                    <a href="/research/experiments?sort=${sortByIdUrl}">
                        Дата создания<#if sortBy=="createdAt"> <b><#if sortDir=="desc">↓<#else>↑</#if></#if></b>
                    </a>
                </th>
                <th>
                    <#if sortBy=="lastUpdatedAt">
                        <#if sortDir=="desc">
                            <#assign sortByIdUrl = "lastUpdatedAt,asc">
                        <#else>
                            <#assign sortByIdUrl = "">
                        </#if>
                    <#else>
                        <#assign sortByIdUrl = "lastUpdatedAt,desc">
                    </#if>
                    <a href="/research/experiments?sort=${sortByIdUrl}">
                        Дата изменения<#if sortBy=="lastUpdatedAt"> <b><#if sortDir=="desc">↓<#else>↑</#if></#if></b>
                    </a>
                </th>
                <th>
                    <#if sortBy=="createdBy">
                        <#if sortDir=="desc">
                            <#assign sortByIdUrl = "">
                        <#else>
                            <#assign sortByIdUrl = "createdBy,desc">
                        </#if>
                    <#else>
                        <#assign sortByIdUrl = "createdBy,asc">
                    </#if>
                    <a href="/research/experiments?sort=${sortByIdUrl}">
                        Ответственный<#if sortBy=="createdBy"> <b><#if sortDir=="desc">↓<#else>↑</#if></#if></b>
                    </a>
                </th>
                <th>
                    Статус
                </th>
                <th>
                    <#if sortBy=="progress">
                        <#if sortDir=="desc">
                            <#assign sortByIdUrl = "progress,asc">
                        <#else>
                            <#assign sortByIdUrl = "">
                        </#if>
                    <#else>
                        <#assign sortByIdUrl = "progress,desc">
                    </#if>
                    <a href="/research/experiments?sort=${sortByIdUrl}">
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