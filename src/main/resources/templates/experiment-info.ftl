<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Эксперимент ${experiment.id}</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<#include "common/header.ftl">
<#assign status = experiment.statusName>
<main>
    <p></p>
    <#if status == "CREATED">
        <form action="/research/experiments/${experiment.id}/edit" method="get">
            <button type="submit">Редактировать</button>
        </form>
    <#elseif status == "FILLED_IN">
        <form action="/research/experiments/${experiment.id}/approve" method="get">
            <button type="submit">Согласовать</button>
        </form>
    <#elseif status == "APPROVED">
        <form action="/research/experiments/${experiment.id}/start" method="get">
            <button type="submit">Начать проведение эксперимента</button>
        </form>
    <#elseif status == "RUNNING">
        <form action="/research/experiments/${experiment.id}/finish" method="get">
            <button type="submit">Завершить проведение эксперимента</button>
        </form>
    <#elseif status == "FINISHED">
        <form action="/research/experiments/${experiment.id}/create-report" method="get">
            <button type="submit">Предоставить отчёт</button>
        </form>
    <#elseif status == "REPORTED">
    </#if>

    <#if status != "CANCELLED">
        <form action="/research/experiments/${experiment.id}/cancel" method="get">
            <button type="submit" <#if status == "CANCELLED">disabled</#if>>Отменить эксперимент</button>
        </form>
    </#if>
    <p></p>
    <table>
        <tr>
            <td>Номер</td>
            <td>${experiment.id}</td>
        </tr>
        <tr>
            <td>Дата создания</td>
            <td>${experiment.createdAt}</td>
        </tr>
        <tr>
            <td>Дата изменения</td>
            <td>${experiment.lastUpdatedAt}</td>
        </tr>
        <tr>
            <td>Ответственный</td>
            <td>${experiment.createdBy}</td>
        </tr>
        <tr>
            <td>Статус</td>
            <td>${experiment.statusDescription}</td>
        </tr>
        <#assign eqName = experiment.equipmentName>
        <tr>
            <td>Оборудование</td>
            <td>
                <#if eqName != unknownString>
                    ${eqName}
                <#else>
                    Не выбрано
                </#if>
            </td>
        </tr>
        <#if eqName != unknownString>
            <tr>
                <td>Вид оборудования</td>
                <td>${experiment.equipmentType}</td>
            </tr>
        </#if>
        <tr>
            <td>Используемые материалы</td>
            <td>
                <#if experiment.materials?size == 0>
                    Не выбраны
                <#else>
                <table>
                    <thead>
                    <tr>
                        <th>Название</th>
                        <th>Тип или источник</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list experiment.materials as material>
                        <tr>
                            <td>${material.name}</td>
                            <td>${material.type}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
                </#if>
            </td>
        </tr>
        <tr>
            <td>Основное действие</td>
            <td>
                <#if experiment.actionName != unknownString>
                    ${experiment.actionName}
                <#else>
                    Не выбрано
                </#if>
            </td>
        </tr>
        <#assign repText = experiment.reportText>
        <tr>
            <td>Отчёт</td>
            <td>
                <#if repText != unknownString>
                    ${repText}
                <#else>
                    Отчёт не сформирован
                </#if>
            </td>
        </tr>
        <#if repText != unknownString>
            <tr>
                <td>Выявленный результат</td>
                <td>${experiment.reportResult}</td>
            </tr>
        </#if>
    </table>
</main>
</body>
</html>