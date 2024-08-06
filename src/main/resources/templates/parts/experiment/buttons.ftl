<#if status == "CREATED" || status == "FILLED_IN">
    <#include "buttons-materials.ftl">
    <#include "buttons-equipment.ftl">
    <#if eqName != unknownString><#include "buttons-action.ftl"></#if>
    <#if status == "FILLED_IN">
        <#if roleMANAGER == "yes">
            <form action="/research/experiments/${experiment.id}/approve" method="get">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Согласовать</button>
            </form>
        <#else>
            <form>
                <button type="submit" disabled>Ожидайте согласования старшим сотрудником</button>
            </form>
        </#if>
    </#if>
<#elseif status == "APPROVED">
    <form action="/research/experiments/${experiment.id}/start" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Начать проведение эксперимента</button>
    </form>
<#elseif status == "RUNNING">
<#elseif status == "FINISHED">
    <form>
        <button type="submit" disabled>Ожидайте формирования отчёта</button>
    </form>
<#elseif status == "REPORTED">
    <form action="/research/reports/${experiment.reportId}" method="get">
        <button type="submit">Просмотреть отчёт</button>
    </form>
</#if>

<#if status != "CANCELLED">
    <form action="/research/experiments/${experiment.id}/cancel" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" <#if status == "CANCELLED">disabled</#if>>Отменить эксперимент</button>
    </form>
</#if>