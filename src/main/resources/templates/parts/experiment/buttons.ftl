<#if status == "CREATED" || status == "FILLED_IN">
    <#include "buttons-materials.ftl">
    <#include "buttons-equipment.ftl">
    <#if eqName != unknownString><#include "buttons-action.ftl"></#if>
    <#if status == "FILLED_IN">
        <form action="/research/experiments/${experiment.id}/approve" method="get">
            <button type="submit">Согласовать</button>
        </form>
    </#if>
<#elseif status == "APPROVED">
    <form action="/research/experiments/${experiment.id}/start" method="get">
        <button type="submit">Начать проведение эксперимента</button>
    </form>
<#elseif status == "RUNNING">
    <form action="/research/experiments/${experiment.id}/finish" method="get">
        <button type="submit">Завершить проведение эксперимента</button>
    </form>
<#elseif status == "FINISHED">
    <form action="/research/experiments/${experiment.id}/create-report" method="post">
        <button type="submit">Предоставить отчёт</button>
    </form>
<#elseif status == "REPORTED">
</#if>

<#if status != "CANCELLED">
    <form action="/research/experiments/${experiment.id}/cancel" method="get">
        <button type="submit" <#if status == "CANCELLED">disabled</#if>>Отменить эксперимент</button>
    </form>
</#if>